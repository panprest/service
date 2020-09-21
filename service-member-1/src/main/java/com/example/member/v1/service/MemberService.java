package com.example.member.v1.service;

import com.example.member.v1.model.Member;

public interface MemberService {
    String createMember(Member member);
    Member findById(String id);
}
