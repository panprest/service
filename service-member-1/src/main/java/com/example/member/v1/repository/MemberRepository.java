package com.example.member.v1.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.member.v1.model.Member;

@Repository
public interface MemberRepository extends MongoRepository<Member, String>{

}
