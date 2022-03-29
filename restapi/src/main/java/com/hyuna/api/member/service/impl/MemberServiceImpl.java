package com.hyuna.api.member.service.impl;

import com.hyuna.api.member.dto.Member;
import com.hyuna.api.member.mapper.MemberMapper;
import com.hyuna.api.member.service.MemberService;
import com.hyuna.api.system.util.MessageUtil;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl  implements MemberService {
	
	@Autowired
	MemberMapper memberMapper;
	
	@Autowired
	MessageUtil messageUtil;
	
	
	public Map<String, Object> findMember(Member member) {
	  Map<String, Object> resultMap = new HashMap();
	  
	  Map<String, Object> map = this.memberMapper.findMember(member);
	  
	  String msg = "";
	  
	  if (map == null) {
	    msg = this.messageUtil.get("CODEMSG3001");
	  } else {
	    resultMap = map;
	    msg = this.messageUtil.get("CODEMSG0000");
	  }
	  
	  resultMap.put("msg", msg);
	  
	  return resultMap;
	}
	
	public List<Member> memberAll()  throws Exception{
		
	  List<Member> members = this.memberMapper.memberAll();
	  
	  return members;
	}
}
