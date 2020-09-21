package com.example.member.v1.repository;

import java.util.List;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.example.member.v1.model.Member;

@Repository
public class MemberRedisRepo {
	private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public MemberRedisRepo(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(Member member){
    	try {
            hashOperations.put("MEMBER", member.getId(), member);
            System.out.println("saved");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
    }
    public List findAll(){
        return hashOperations.values("MEMBER");
    }

    public Member findById(String id){
        return (Member) hashOperations.get("MEMBER", id);
    }

    public void update(Member member){
        save(member);
    }

    public void delete(String id){
        hashOperations.delete("MEMBER", id);
    }
}
