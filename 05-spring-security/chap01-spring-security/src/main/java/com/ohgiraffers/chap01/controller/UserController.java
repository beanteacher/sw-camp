package com.ohgiraffers.chap01.controller;

import com.ohgiraffers.chap01.dto.CreateUserRequestDTO;
import com.ohgiraffers.chap01.aggregate.entity.User;
import com.ohgiraffers.chap01.security.dto.UserResponse;
import com.ohgiraffers.chap01.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "User 등록")
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;

    @PostMapping("/users")
    @Operation(summary = "회원가입")
    public ResponseEntity<Void> createUser(@RequestBody CreateUserRequestDTO userDTO) {

        User user = userService.createUser(userDTO);

        return ResponseEntity.status((HttpStatus.CREATED)).build();
    }

    @GetMapping("/users/{userSeq}")
    @Operation(summary = "회원 조회(관리자만 가능)")
    public ResponseEntity<UserResponse> getUserById(@PathVariable int userSeq) {
        UserResponse userResponse = userService.getUserById(userSeq);

        return ResponseEntity.ok(userResponse);
    }
}
