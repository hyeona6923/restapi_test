package com.hyuna.api.member.service;

import com.hyuna.api.member.dto.Member;
import java.util.List;
import java.util.Map;

public abstract interface MemberService
{
	public abstract Map<String, Object> findMember(Member paramMember) throws Exception;
	
	public abstract List<Member> memberAll() throws Exception;
}
