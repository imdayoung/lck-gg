package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.SocialType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.OptionalInt;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByUsername(String username);

    Optional<Member> findByNickname(String nickname);

    Optional<Member> findBySocialTypeAndSocialId(SocialType socialType, String socialId);

    Optional<Member> findByRefreshToken(String refreshToken);

    boolean existsByUsername(String username);
}
