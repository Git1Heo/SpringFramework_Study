package com.hsw.ex;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

@Controller
public class HomeController {
	
	// 리턴타입 : String
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		// 기본주소(/) 요청에 대해 home.js를 출력해줌.
		// 컨트롤러 메서드에서 String 리턴은 해당 String값 .jsp를 출력하도록 처리됨	
		return "home";
	}

	//hello 주소를 받아줄 메서드 선언
	@RequestMapping(value="/hello")
	public String hello() {
		System.out.println("hello 메서드 호출되었습니다.");
		// hi.jsp 출력
		return "hi";
	}
	
	@RequestMapping(value="/intro")
	public String intro() {
		System.out.println("intro 호출");
		return "intro";
	}
	
	@RequestMapping(value="/input") // home.jsp 에서의 href값
	public String input1() // 이름 상관 없는듯 
	{
		System.out.println("input 호출");
		return "input";  // jsp 이름
	}
	
	// 화면에서 전달한 파라미터 받기
	@RequestMapping(value="/inputparam",method=RequestMethod.POST)
	public String inputParam(@RequestParam("param1") String param1,
							 @RequestParam("param2") String param2) {
		System.out.println("inputParam메소드");
		System.out.println("param1 : " +param1+ "  param2 : "+param2);
		return "home";
	}
	
	
}
