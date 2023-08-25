package com.example.demo.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDao extends JpaRepository<Member, String> {
	Member findByIdAndPwd(String id, String pwd);
	Member findByNameAndEmailAndPhone(String name, String email, String phone);
	Member findByIdAndEmailAndName(String id, String email, String name);
}
