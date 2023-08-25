package com.example.demo.member;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
	@Id
	private String id;
	private String pwd;
	private String storename;
	private String name;
	private String email;
	private String phone;
}
