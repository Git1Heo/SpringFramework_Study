package com.hsw.test;

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


@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
	
		return "index";
	}
	
	@RequestMapping(value="/login") // 
	public String input1() // 
	{
		System.out.println("input 호출");
		return "login";  // jsp 이름
	}
	
	@RequestMapping(value="/inputparam", method=RequestMethod.POST)
	public String idpw(Model model,@RequestParam ("id") String id,
						@RequestParam ("pw") String pw) {
		System.out.println("id : " + id+ "  pw : "+pw);
		//id를 model에 담아서 welcome.jsp로 가져가기
		model.addAttribute("idvalue",id);
		//pw pwvalue에 담고 welcom.jsp에서 출력
		model.addAttribute("pwvalue",pw);
		//val 변수를 hello에 담고 welcome.jsp에서 출력
		String var="헬로우";
		model.addAttribute("hello",var);
		
		return "welcome";
		
	}
}
