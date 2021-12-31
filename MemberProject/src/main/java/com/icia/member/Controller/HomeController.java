package com.icia.member.Controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.member.Service.MemberService;
import com.icia.member.dto.IdPwDTO;
import com.icia.member.dto.MemberDTO;



@Controller
public class HomeController {
	@Autowired
	private MemberService ms;
	@Autowired
	
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {		
		return "index";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String singup() {		
		return "signup";
	}
	
	@RequestMapping(value="/insert",method=RequestMethod.POST )
	public String inputparam(@ModelAttribute MemberDTO member) {
		//System.out.println(member);
		ms.insert(member);
		return "index";
		
	}
	
	
	@RequestMapping(value = "/signin", method = RequestMethod.GET)
	public String singin() {		
		return "signin";
	}
	
	//IdPwDTO
	@RequestMapping(value="/login",method=RequestMethod.POST )
	public String sign(Model model , @ModelAttribute IdPwDTO idpw) {
		String result =ms.signin(idpw);
		return result;		
	}
	
	//로그아웃 처리
	@RequestMapping(value="/logout", method=RequestMethod.GET)
	public String logout(HttpSession session) {
		//세션에 저장된 데이터를 지움
		session.invalidate();
		return "index";
	}
	
	@RequestMapping(value="/findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		List <MemberDTO> mList=ms.findAll();		
		model.addAttribute("mList",mList);
		return "findAll";
	}
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String detail(Model model , @RequestParam ("m_number") long m_number) {
		MemberDTO member =ms.detail(m_number);
		model.addAttribute("m", member);
		return "detail";
	}
	
	@RequestMapping(value="/remove", method=RequestMethod.GET)
	public String remove(Model model , @RequestParam ("m_number") long m_number) {
		ms.remove(m_number);
		return "redirect:/findAll";
	}
	
	
	@RequestMapping (value ="/update", method=RequestMethod.GET)
	public String updateShow(@RequestParam ("m_number") long m_number, Model model) {
		
		MemberDTO modeldetail =ms.detail(m_number);
		model.addAttribute("updateShow", modeldetail);
		
		return "update";
	}
	
	
	
	@RequestMapping (value ="/update", method=RequestMethod.POST)
	public String update(@ModelAttribute MemberDTO member ,Model model) {
		
		ms.update(member);
		//return "redirect:/findAll";

		//DB에서 데이터를 가지고 와서 detail.jsp로
//		MemberDTO memberUp=ms.detail(member.getM_number());
//		model.addAttribute("member",memberUp);
//		return "detail";
		
		//컨트롤러의 detail 주소 요청
		return "redirect:/detail?m_number="+member.getM_number();
		
	}
	
	//아이디 중복체크
	@RequestMapping(value="/idDuplicate", method=RequestMethod.POST)
	public @ResponseBody String idDuplicate(@RequestParam ("4k") String m_id) {
		
		System.out.println("MemberController.idDuplicate() : "+m_id);
		String result=ms.idDuplicate(m_id);
		return result; // "ok" or "no"
	}
	
	//ajax로 상세조회
	@RequestMapping(value="/detailAjax", method=RequestMethod.POST)
	public @ResponseBody MemberDTO detailAjax(@RequestParam ("m_number") long m_number) {
		
		
		MemberDTO member=ms.detail(m_number);
		return member; 
	}
	
	
	
	
}

