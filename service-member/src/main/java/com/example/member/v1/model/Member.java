package com.example.member.v1.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "member")
public class Member {
	@Id
	private String id;
	@Field(value = "name")
	private String name;
	@Field(value = "phone")
	private String phone;
	@Field(value = "client")
	private List<String> client;
}
