package com.gura.spring03;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping("/")
	public String home(HttpServletRequest request) {
		// home.jsp 페이지에서 필요한 모델(data)을 HttpServletRequest 객체에 담아두기
		// 응답에 필요한 데이터(Model)라고 가정하자
		List<String> noticeList = new ArrayList<String>();
		noticeList.add("날씨가 많이 더워지고 있어요.");
		noticeList.add("어쩌구..");
		noticeList.add("저쩌구..");

		request.setAttribute("noticeList", noticeList);

		// WEB-INF/views/home.jsp 페이지로 forward 이동해서 응답하겠다는 의미
		// "home"이라는 문자열을 리턴하면 앞에 "/WEB-INF/views/" 뒤에 ".jsp"가 자동으로 붙는다.
		return "home";
	}
	
	@RequestMapping("/play")
	public String play() {
		return "play";
	}
}
