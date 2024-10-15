package com.ohgiraffers.chap01.service;

import com.ohgiraffers.chap01.dto.CreateUserRequestDTO;
import com.ohgiraffers.chap01.aggregate.entity.User;
import com.ohgiraffers.chap01.mapper.UserMapper;
import com.ohgiraffers.chap01.repository.UserRepository;
import com.ohgiraffers.chap01.security.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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
    private final BCryptPasswordEncoder passwordEncoder;

    @Transactional
    public User createUser(CreateUserRequestDTO userDTO) {
        User user = UserMapper.toEntity(userDTO);
        user.encryptPassword(passwordEncoder.encode(user.getUserPwd()));
        userRepository.save(user);

        return user;
    }

    /* 로그인 요청 시 AuthenticationManager를 통해서 호출 될 메소드 */
    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        /* 인증 토큰에 담긴 userId가 메소드로 넘어오므로 해당 값을 기준으로 DB에서 조회한다. */
        User user = userRepository.findByUserId(userId)
                .orElseThrow(() -> new UsernameNotFoundException(userId));

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(user.getUserRole().name()));
        return new org.springframework.security.core.userdetails.User(user.getUserId(), user.getUserPwd(), grantedAuthorities);
    }

    public UserResponse getUserById(int userSeq) {
        User user = userRepository.findById(userSeq).orElseThrow();

        return new UserResponse(user.getUserId(), user.getUserEmail(), user.getUserName());
    }
}
