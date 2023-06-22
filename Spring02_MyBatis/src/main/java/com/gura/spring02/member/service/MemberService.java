package com.gura.spring02.member.service;

import java.util.List;

import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dto.MemberDto;

public interface MemberService {
	public void addMember(MemberDto dto);
	public void updateMember(MemberDto dto);
	public void deleteMember(int num);
	public void getMemberInfo(ModelAndView mView, int num);
	public void getMemberList(ModelAndView mView);
}
