package com.hyuna.api.member.controller;
import com.hyuna.api.common.util.ValidationGroups;

import com.hyuna.api.member.dto.Member;
import com.hyuna.api.member.mapper.MemberMapper;
import com.hyuna.api.member.service.MemberService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
public class MemberController
{
	@Autowired
	MemberService memberService;
	@Autowired
	MemberMapper memberMapper;
	
	@GetMapping({"/memberAll"})
	public List<Member> memberAll()
	  throws Exception
	{
	  return this.memberService.memberAll();
	}
	
	@PostMapping({"/findMember"})
	public ResponseEntity<?> findMember(@RequestBody @Validated({ValidationGroups.group1.class}) Member member, BindingResult result) throws Exception {
		if (result.hasErrors()) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result.getFieldError());
		}
		
		return ResponseEntity.ok(this.memberService.findMember(member));
	}
}
