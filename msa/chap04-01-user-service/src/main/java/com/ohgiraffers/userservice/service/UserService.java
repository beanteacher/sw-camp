package com.ohgiraffers.userservice.service;

import com.ohgiraffers.userservice.aggregate.UserEntity;
import com.ohgiraffers.userservice.client.OrderServiceClient;
import com.ohgiraffers.userservice.dto.CreateUserRequest;
import com.ohgiraffers.userservice.dto.OrderInfoResponse;
import com.ohgiraffers.userservice.dto.UserInfoResponse;
import com.ohgiraffers.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final BCryptPasswordEncoder passwordEncoder;
    private final OrderServiceClient orderServiceClient;

    @Transactional
    public void createUser(CreateUserRequest newUser) {
        UserEntity user = modelMapper.map(newUser, UserEntity.class);
        user.encryptPassword(passwordEncoder.encode(newUser.getPwd()));
        userRepository.save(user);
    }

    /* 로그인 요청 시 AuthenticationManager를 통해서 호출 될 메소드 */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        /* 인증 토큰에 담긴 userId가 메소드로 넘어오므로 해당 값을 기준으로 DB에서 조회 한다. */
        UserEntity loginUser = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId));

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(loginUser.getUserRole().name()));

        return new User(loginUser.getUserId(), loginUser.getPwd(), grantedAuthorities);
    }


    public UserInfoResponse getUserInfoById(Long id) {

        UserEntity user = userRepository.findById(id).orElseThrow();
        /* 유저의 정보 안에 주문내역이 포함되어야 하는 경우
        * OrderService Instance와의 통신을 통해 해당 정보를 가져오도록 한다. */
        UserInfoResponse userInfoResponse = modelMapper.map(user, UserInfoResponse.class);
        List<OrderInfoResponse> orderInfoList = orderServiceClient.getUserOrders(id);
        userInfoResponse.setOrderInfoResponseList(orderInfoList);
        
        return userInfoResponse;
    }
}
