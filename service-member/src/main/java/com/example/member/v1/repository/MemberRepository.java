package com.example.member.v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.member.v1.model.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member, String>{

}
