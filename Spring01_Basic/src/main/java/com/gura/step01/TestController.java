package com.gura.step01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gura.step01.member.MemberDto;

/*
 * JSON 문자열 응답하는 방법
 * 
 * 1. pom.xml에 jackson-databind dependency를 추가한다.
 * 2. 컨트롤러 메소드에 @ResponseBody 어노테이션을 붙여준다.
 * 3. Dto, List, Map 등을 컨트롤러에서 리턴해주면 해당 객체에 담긴 정보가 json으로 구성되어서 응답한다.
 */

@Controller
public class TestController {
	
	// json은 자바 친화적이지 않기 때문에 dto, List, Map 같은 담아주는 타입이 있어줘야 한다.
	@ResponseBody
	@RequestMapping("/test/json1")
	public String json1() {
		
		return "{\"num\":1, \"name\":\"James\", \"addr\":\"noryangjin\"}";
	}
	
	@ResponseBody
	@RequestMapping("/test/json2")
	public MemberDto json2() {
		MemberDto dto = new MemberDto();
		dto.setNum(2);
		dto.setName("해골");
		dto.setAddr("원숭이");
		
		return dto;
	}
	
	@ResponseBody
	@RequestMapping("/test/json3")
	public Map<String, Object> json3(){
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("num", 3);
		map.put("name", "원숭이");
		map.put("addr", "동물원");
		
		return map;
	}
	
	@ResponseBody
	@RequestMapping("/test/json4")
	public List<String> json4(){
		List<String> names = new ArrayList<String>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		return names;
	}
	
	@ResponseBody
	@RequestMapping("/test/json5")
	public List<MemberDto> json5(){
		List<MemberDto> list = new ArrayList<>();
		list.add(new MemberDto(1, "김구라", "노량진"));
		list.add(new MemberDto(2, "해골", "행신동"));
		list.add(new MemberDto(3, "원숭이", "동물원"));
		
		return list;
	}
	
	@ResponseBody
	@RequestMapping("/test/json6")
	public List<Map<String, Object>> json6(){
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		Map<String, Object> map2 = new HashMap<String, Object>();
		Map<String, Object> map3 = new HashMap<String, Object>();
		
		map1.put("num", 1);
		map2.put("num", 2);
		map3.put("num", 3);
		
		map1.put("name", "김구라");
		map2.put("name", "해골");
		map3.put("name", "행신동");
		
		map1.put("addr", "노량진");
		map2.put("addr", "행신동");
		map3.put("addr", "동물원");
		
		List<Map<String, Object>> list = new ArrayList<>();
		list.add(map1);
		list.add(map2);
		list.add(map3);
		
		return list;		
	}
}
