package com.example.member.v1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.member.v1.model.Member;
import com.example.member.v1.service.MemberService;


@RestController
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping(value = "/create")
	public String createMember(@RequestBody Member member) {
		
		return memberService.createMember(member);
	}
	
	@GetMapping(value = "/check/{id}")
	public Member getMember(@PathVariable(value = "id") String id) {
		return memberService.findById(id);
	}
}
