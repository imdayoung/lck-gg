package com.example.demo.login.handler;

import com.example.demo.global.jwt.service.JwtService;
import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.login.dto.LoginSuccessResponse;
import com.example.demo.member.repository.MemberRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;

import java.io.IOException;

@RequiredArgsConstructor
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtService jwtService;
    private final MemberRepository memberRepository;
    private final ObjectMapper objectMapper;

    @Value("${jwt.access.expiration}")
    private String accessTokenExpiration;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        String username = extractUsername(authentication);
        String accessToken = jwtService.createAccessToken(username);
        String refreshToken = jwtService.createRefreshToken();

        jwtService.sendAccessAndRefreshToken(response, accessToken, refreshToken);

        LoginSuccessResponse loginSuccessResponse = LoginSuccessResponse.builder()
                .username(username)
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();

        ApiResponse<LoginSuccessResponse> successResponse = ApiResponse.success(loginSuccessResponse);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(successResponse));

        ApiResponse.success(loginSuccessResponse);

        memberRepository.findByUsername(username)
                .ifPresent(member -> {
                    member.updateRefreshToken(refreshToken);
                    memberRepository.saveAndFlush(member);
                });
    }

    private String extractUsername(Authentication authentication) {

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        return userDetails.getUsername();
    }
}
