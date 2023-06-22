package com.gura.spring02.guest.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.guest.dao.GuestDao;
import com.gura.spring02.guest.dto.GuestDto;

//component scan을 통해서 bean이 될 수 있도록 서비스 클래서는 @Service 어노테이션을 붙인다.
@Service
public class GuestServiceImpl implements GuestService{
	
	//서비스는 비즈니스 로직을 처리하기 위해 Dao에 의존한다.
	@Autowired
	public GuestDao dao;
	
	@Override
	public void addGuest(GuestDto dto) {
		dao.insert(dto);
	}

	@Override
	public void updateGuest(GuestDto dto) {
		dao.update(dto);
	}

	@Override
	public void deleteGuest(GuestDto dto) {
		dao.delete(dto);
	}

	@Override
	public void getGuestInfo(ModelAndView mView, int num) {
		GuestDto dto = dao.getData(num);
		mView.addObject("dto", dto);
	}

	@Override
	public void getGuestList(ModelAndView mView) {
		List<GuestDto> list = dao.getList();
		mView.addObject("list", list);
	}

}
