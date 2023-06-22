package com.gura.spring02.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dao.MemberDao;
import com.gura.spring02.member.dto.MemberDto;

@Service
public class MemberServiceImpl implements MemberService{
	//Spring bean Container로부터 "new MemberDaoImpl()"이 컴포넌트 스캔을 통해 dao 데이터를 주입받음
	@Autowired
	private MemberDao dao; //setter method를 통해 주입받기 때문에 private
	
	@Override
	public void addMember(MemberDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteMember(int num) {
		dao.delete(num);
	}
	
	@Override
	public void getMemberInfo(ModelAndView mView, int num) {
		MemberDto dto = dao.getData(num);
		/*
		 * 수정할 회원의 정보를 ModelAndView 객체의 addObject(key, value) 메소드를 이용해서 담는다.
		 * ModelAndView 객체에 담은 값은 결국 HttpServletRequest 객체에 담긴다.(request scope에 담긴다.)
		 */
		mView.addObject("dto", dto);
	}

	@Override
	public void getMemberList(ModelAndView mView) {
		List<MemberDto> list = dao.getList();
		mView.addObject("list", list);
	}	
}
