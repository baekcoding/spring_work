package com.gura.spring02.guest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.guest.dto.GuestDto;
import com.gura.spring02.guest.service.GuestService;

@Controller
public class GuestController {
	
	@Autowired
	private GuestService service;
	
	@RequestMapping("/guest/list")
	public ModelAndView List(ModelAndView mView) {
		service.getGuestList(mView);
		mView.setViewName("guest/list");
		
		return mView;
	}
	
	/*
	@RequestMapping("/guest/list")
	public String guestList(HttpServletRequest request) {
		
		List<GuestDto> list = dao.getList();
		
		request.setAttribute("list", list);
		
		return "guest/list";
	}
	*/
	
	@RequestMapping("/guest/insertform")
	public String insertform() {
		return "guest/insertform";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/guest/insert")
	public String insert(GuestDto dto) {
		service.addGuest(dto);
		return "guest/insert";
	}
	
	@RequestMapping("/guest/updateform")
	public ModelAndView updateform(ModelAndView mView, int num) {
		
		service.getGuestInfo(mView, num);
		mView.setViewName("guest/updateform");
		
		/*
		 * 두 개의 정보가 모두 담긴 ModelAndView 객체를 리턴해주면
		 * addObject(key, value)를 통해서 담은 정보는 request scope에 담기고
		 * setViewName(view page 위치)를 통해서 담은 정보는 해당 view page로 forward 이동해서 응답된다.
		 */
		
		return mView;
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/guest/update")
	public String update(GuestDto dto) {
		service.updateGuest(dto);		
		return "guest/update";
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/guest/delete")
	public String delete(GuestDto dto) {
		service.deleteGuest(dto);
		return "redirect:/guest/list";
	}
}
