package com.hyuna.api.member.mapper;

import com.hyuna.api.member.dto.Member;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public abstract interface MemberMapper
{
  public abstract Map<String, Object> findMember(Member paramMember);
  
  public abstract List<Member> memberAll() throws Exception;
}
