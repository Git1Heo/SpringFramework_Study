package com.hsw.work;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		
		return "join";
	}
	
	@RequestMapping(value = "join2", method = RequestMethod.GET)
	public String join2() {
		
		return "join2";
	}
	
	@RequestMapping(value = "/inputparam", method = RequestMethod.GET)
	public String memberJoin1(Model model, @RequestParam ("id") String id,
										  @RequestParam ("pw") String pw,
										  @RequestParam ("name") String name,
										  @RequestParam ("mail") String mail,
										  @RequestParam ("gender") String gender) {
		
		System.out.println("정보");
		System.out.println(id);
		System.out.println(pw);
		System.out.println(name);
		System.out.println(mail);
		System.out.println(gender);
		
		
		model.addAttribute("id",id);
		model.addAttribute("pw",pw);
		model.addAttribute("name",name);
		model.addAttribute("mail",mail);
		model.addAttribute("gender",gender);
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setMail(mail);
		memberDTO.setGender(gender);
		System.out.println(memberDTO);
		return "memberjoin";
		
		
	}
	//ModelAttribute로 DTO에 담을때 주의할점
	//jsp에서 사용한 input의name값과 DTO 필드값이 똑같아야함
	
	@RequestMapping(value = "/memberjoin2", method = RequestMethod.GET)
	public String memberJoin2(@ModelAttribute MemberDTO member, Model model) {
		System.out.println(member);
		model.addAttribute("member",member);
		return "login";
	}
}