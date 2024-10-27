package com.example.demo.member.service;

import com.example.demo.global.response.error.ApplicationError;
import com.example.demo.global.response.exception.ApplicationException;
import com.example.demo.member.dto.MemberSignUpRequest;
import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.Role;
import com.example.demo.member.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public void signUp(MemberSignUpRequest memberSignUpRequest) throws Exception {

        if (memberRepository.findByUsername(memberSignUpRequest.getUsername()).isPresent()) {
            throw new ApplicationException(ApplicationError.USERNAME_DUPLICATED);
        }

        Member member = Member.builder()
                .username(memberSignUpRequest.getUsername())
                .password(memberSignUpRequest.getPassword())
                .nickname(memberSignUpRequest.getNickname())
                .age(memberSignUpRequest.getAge())
                .role(Role.USER)
                .build();

        member.passwordEncode(passwordEncoder);
        memberRepository.save(member);
    }
}
