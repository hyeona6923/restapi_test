package com.hyuna.api.member.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import lombok.Data;


@Data
public class Member
{
	private String no;
	
	@NotEmpty(message="이름은 필수입니다.", groups={com.hyuna.api.common.util.ValidationGroups.group1.class})
	private String name;
	
	@Email
	private String email;
	
	@Pattern(regexp="[0-9]{10,11}", message="정확한 휴대폰번호를 입력해주세요.")
	private String mobileNo;
	
}
