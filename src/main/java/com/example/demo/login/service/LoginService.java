package com.example.demo.login.service;

import com.example.demo.global.response.error.ApplicationError;
import com.example.demo.global.response.exception.ApplicationException;
import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberRole;
import com.example.demo.member.repository.MemberRepository;
import com.example.demo.member.repository.MemberRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LoginService implements UserDetailsService {

    private final MemberRepository memberRepository;
    private final MemberRoleRepository memberRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Member member = memberRepository.findByUsername(username)
                .orElseThrow(() -> new ApplicationException(ApplicationError.MEMBER_NOT_FOUND));

        List<MemberRole> memberRoles = memberRoleRepository.findByMember(member);

        String[] roles = memberRoles.stream()
                .map(role -> role.getRole().toString())
                .toArray(String[]::new);

        return org.springframework.security.core.userdetails.User.builder()
                .username(member.getUsername())
                .password(member.getPassword())
                .roles(roles)
                .build();
    }
}
