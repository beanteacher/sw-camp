package com.ohgiraffers.chap01.security;

import com.ohgiraffers.chap01.security.filter.CustomAuthenticationFilter;
import com.ohgiraffers.chap01.security.filter.JwtFilter;
import com.ohgiraffers.chap01.security.handler.JwtAccessDeniedHandler;
import com.ohgiraffers.chap01.security.handler.JwtAuthenticationEntryPoint;
import com.ohgiraffers.chap01.security.handler.LoginFailureHandler;
import com.ohgiraffers.chap01.security.handler.LoginSuccessHandler;
import com.ohgiraffers.chap01.security.util.JwtUtil;
import com.ohgiraffers.chap01.service.UserService;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig { // 옛날버전 extends ...

    private final BCryptPasswordEncoder passwordEncoder;
    private final UserService userService;
    private final Environment env;
    private final JwtUtil jwtUtil;

    // 최신 버전
    @Bean
    protected SecurityFilterChain configure(HttpSecurity security) throws Exception {
        /* CSRF 토큰 발행 시 Client에서 매번 해당 토큰도 함께 넘겨주어야 하므로 기능 비활성화 */
        security.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> {
                    authz.requestMatchers(new AntPathRequestMatcher("/users/**", "POST")).permitAll()
                            .requestMatchers(new AntPathRequestMatcher("/users/**", "GET")).hasAnyAuthority("ADMIN")
                            .anyRequest().authenticated();
                })
                /* session 로그인 방식을 사용하지 않음(JWT Token 방식을 사용할 예정) */
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        /* 커스텀 로그인 필터 이전에 JWT 토큰 확인 필터를 설정 */
        security.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
        /* 커스텀 로그인 필터 추가 */
        security.addFilterAfter(getAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        security.exceptionHandling(
                exceptionHandling -> {
                    exceptionHandling.accessDeniedHandler(new JwtAccessDeniedHandler());
                    exceptionHandling.authenticationEntryPoint(new JwtAuthenticationEntryPoint());
                }
        );

        return security.build();
    }

    private Filter getAuthenticationFilter() {
        CustomAuthenticationFilter customAuthenticationFilter = new CustomAuthenticationFilter();
        customAuthenticationFilter.setAuthenticationManager(getAuthenticationManager());
        customAuthenticationFilter.setAuthenticationSuccessHandler(new LoginSuccessHandler(env));
        customAuthenticationFilter.setAuthenticationFailureHandler(new LoginFailureHandler());
        return customAuthenticationFilter;
    }

    private AuthenticationManager getAuthenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder);
        provider.setUserDetailsService(userService);

        return new ProviderManager(provider);
    }
}
