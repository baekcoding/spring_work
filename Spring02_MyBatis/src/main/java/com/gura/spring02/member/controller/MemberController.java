package com.gura.spring02.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.member.dao.MemberDao;
import com.gura.spring02.member.dto.MemberDto;
import com.gura.spring02.member.service.MemberService;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService service; //setter method를 통해 주입받기 때문에 private
	
	//회원추가 폼 요청 처리
	@RequestMapping("/member/insertform")
	public String insertform() {
		return "member/insertform";
	}
	
	@RequestMapping("/member/insert")
	public String insert(MemberDto dto) {
		service.addMember(dto);
		//view page로 forward 이동해서 응답
		return "member/insert";
	}
	
//	@RequestMapping("/member/updateform2")
//	public String updateform2() {
//		return "member/updateform";
//	}
	
	@RequestMapping("/member/updateform")
	public ModelAndView updateform(ModelAndView mView, int num) {
		service.getMemberInfo(mView, num);
		//view page의 위치도 ModelAndView 객체에 담아서 리턴해야 한다.
		mView.setViewName("member/updateform");
		//모델(data)과 view page의 정보가 모두 담긴 ModelAndView 객체를 리턴해주면
		//spring이 알아서 처리해 준다.
		return mView;
	}
	
	/*
	 * @RequestMapping 에 method 속성의 값을 명시하지 않으면 요청 방식을 가리지 않고
	 * 경로만 맞으면 모두 처리해 준다.(GET, POST, PUT, DELETE)
	 * 
	 * method 속성의 값을 명시하면 경로가 맞더라도 요청 방식이 다른 경우 처리해주지 않는다.
	 * 일반적으로 POST인 경우에는 요청 방식을 명시해 주는 것이 좋다.
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/member/update")
	public String update(@ModelAttribute(value="dto") MemberDto dto) {
		service.updateMember(dto);
		return "member/update";
	}
	
	/*
	 * @RequestMapping("/member/update") 
	 * public String update(MemberDto dto) {
	 * dao.update(dto); return "member/update"; }
	 */
	
	@RequestMapping("/member/delete")
	public String delete(@RequestParam(value = "num", defaultValue = "0")  int num) {
		service.deleteMember(num);
		return "redirect:/member/list";
	}
	
	@RequestMapping("/member/list")
	public ModelAndView list(ModelAndView mView) {
		service.getMemberList(mView);
		mView.setViewName("member/list");
		// /WEB-INF/views/member/list.jsp 페이지로 forward 이동해서 응답
		return mView;
	}
}
