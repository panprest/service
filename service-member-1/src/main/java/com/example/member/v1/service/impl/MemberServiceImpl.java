package com.example.member.v1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.example.member.v1.model.Member;
import com.example.member.v1.repository.MemberRedisRepo;
import com.example.member.v1.repository.MemberRepository;
import com.example.member.v1.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService{
	private RedisTemplate redisTemplate;
	
	@Autowired
	private MemberRepository memberRepository;
	
	@Autowired
	private MemberRedisRepo memberRedisRepo;
	
	@Override
	public String createMember(Member member) {
		// TODO Auto-generated method stub
		String response = "";
		try {
			memberRepository.save(member);
			response = "success";
			System.out.println(response);
		} catch (Exception e) {
			// TODO: handle exception
			response = e.toString();
			System.out.println(response);
		}
		return response;
	}

	@Override
	public Member findById(String id) {
		// TODO Auto-generated method stub
		Member response = new Member();
		try {
			response = memberRedisRepo.findById(id);
			if (response==null) {
				response = memberRepository.findById(id).orElse(null);
				redisTemplate.opsForHash().entries("id|"+id);
				System.out.println("saved");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return response;
	}

}
