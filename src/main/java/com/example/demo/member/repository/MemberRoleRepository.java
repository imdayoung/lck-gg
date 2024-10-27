package com.example.demo.member.repository;

import com.example.demo.member.entity.Member;
import com.example.demo.member.entity.MemberRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRoleRepository extends JpaRepository<MemberRole, Long> {

    List<MemberRole> findByMember(Member member);
}
