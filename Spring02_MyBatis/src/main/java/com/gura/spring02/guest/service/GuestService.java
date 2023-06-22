package com.gura.spring02.guest.service;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.gura.spring02.guest.dto.GuestDto;

//메소드명은 임의로 정할 수 있다.
public interface GuestService {
	public void addGuest(GuestDto dto);
	public void updateGuest(GuestDto dto);
	public void deleteGuest(GuestDto dto);
	public void getGuestInfo(ModelAndView mView, int num);
	public void getGuestList(ModelAndView mView);
}
