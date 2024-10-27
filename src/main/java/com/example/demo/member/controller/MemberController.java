package com.example.demo.member.controller;

import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.member.dto.MemberSignUpRequest;
import com.example.demo.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> signUp(@RequestBody MemberSignUpRequest memberSignUpRequest) throws Exception {

        memberService.signUp(memberSignUpRequest);
        return ResponseEntity.ok(ApiResponse.success("Sign up success"));
    }
}
