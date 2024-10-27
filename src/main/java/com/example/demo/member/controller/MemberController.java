package com.example.demo.member.controller;

import com.example.demo.global.response.response.ApiResponse;
import com.example.demo.member.dto.MemberSignUpRequest;
import com.example.demo.member.service.MemberService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/test")
    public ResponseEntity<ApiResponse<String>> test() {

        return ResponseEntity.ok(ApiResponse.success("Test success"));
    }

    @PostMapping("/signup")
    public ResponseEntity<ApiResponse<String>> signUp(@RequestBody MemberSignUpRequest memberSignUpRequest) throws Exception {

        memberService.signUp(memberSignUpRequest);
        return ResponseEntity.ok(ApiResponse.success("Sign up success"));
    }
}
