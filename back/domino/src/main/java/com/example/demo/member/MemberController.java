package com.example.demo.member;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // rest api controller
@CrossOrigin(origins = "*") // 모든 ip로부터 요청 받기 허용
@RequestMapping("/member") // 기본 url: member
public class MemberController {
	@Autowired
	private MemberService service;

	// 회원가입
	@PostMapping("")
	public Map join(MemberDto dto) {
		MemberDto d = service.join(dto);
		Map map = new HashMap();
		map.put("dto", d);
		return map;
	}

	// 멤버 전체조회
	@GetMapping("")
	public Map getByall() {
		ArrayList<MemberDto> list = service.getAll();
		Map map = new HashMap<>();
		map.put("list", list);
		return map;
	}

	// 맴버 Id로 검색
	@GetMapping("/{id}")
	public Map getById(@PathVariable("id") String id) {
		MemberDto dto = service.getById(id);
		Map map = new HashMap<>();
		map.put("dto", dto);
		return map;
	}

	// 맴버 로그인 인증
	@GetMapping("/{id}/{pwd}")
	public Map login(@PathVariable("id") String id, @PathVariable("pwd") String pwd) {
		MemberDto dto = service.getByIdAndPwd(id, pwd);
		Map map = new HashMap<>();
		map.put("dto", dto);
		return map;
	}

	// id찾기
	@GetMapping("/{name}/{email}/{phone}")
	public Map getId(@PathVariable("name") String name, @PathVariable("email") String email,
			@PathVariable("phone") String phone) {
		String id = service.getId(name, email, phone);
		Map map = new HashMap<>();
		map.put("id", id);
		return map;
	}

	// pwd찾기
	@GetMapping("/{id}/{email}/{name}")
	public Map getPwd(@PathVariable("id") String id, @PathVariable("email") String email,
			@PathVariable("name") String name) {
		String pwd = service.getId(id, email, name);
		Map map = new HashMap<>();
		map.put("pwd", pwd);
		return map;
	}

}
