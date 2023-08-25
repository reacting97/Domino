package com.example.demo.member;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	
	@Autowired
	private MemberDao dao;
	
	public MemberDto join(MemberDto dto) {
		Member vo = dao.save(new Member(dto.getId(), dto.getPwd(), dto.getStorename(), dto.getName(), dto.getEmail(), dto.getPhone()));
		return new MemberDto(vo.getId(), vo.getPwd(), vo.getStorename(), vo.getName(), vo.getEmail(), vo.getPhone());
	}
	
	public ArrayList<MemberDto> getAll(){
		ArrayList<Member> list = (ArrayList<Member>) dao.findAll();
		ArrayList<MemberDto> dlist = new ArrayList<>();
		for(Member vo:list) {
			dlist.add(new MemberDto(vo.getId(), vo.getPwd(), vo.getStorename(), vo.getName(), vo.getEmail(), vo.getPhone()));
		}
		return dlist;
	}
	
	public MemberDto getById(String id) {
		Member vo = dao.findById(id).orElse(null);
		if(vo == null) {
			return null;
		}
		return new MemberDto(vo.getId(), vo.getPwd(), vo.getStorename(), vo.getName(), vo.getEmail(), vo.getPhone());
	}
	
	public MemberDto getByIdAndPwd(String id, String pwd) {
		Member vo = dao.findByIdAndPwd(id, pwd);
		if(vo == null) {
			return null;
		}
		return new MemberDto(vo.getId(), vo.getPwd(), vo.getStorename(), vo.getName(), vo.getEmail(), vo.getPhone());
	}
	
	public String getId(String name, String email, String phone) {
		Member vo = dao.findByNameAndEmailAndPhone(name, email, phone);
		if(vo == null) {
			return null;
		}
		return vo.getId();
	}
	
	public String getPwd(String id, String email, String name) {
		Member vo = dao.findByIdAndEmailAndName(id, email, name);
		if(vo == null) {
			return null;
		}
		return vo.getPwd();
	}
	
}
