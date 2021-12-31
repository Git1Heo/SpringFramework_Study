package com.hsw.ex.Conntroller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hsw.ex.dto.TraineeDTO;
import com.hsw.ex.service.TraineeService;

@Controller
public class HomeController {
	
	// 스프링이 관리하는 객체를 사용하기
	// 의존성 주입(DI Dependency Injection)
	@Autowired
	private TraineeService ts;
	//new 없이 컨트롤러가 서비스를 관리
	
	//TraineeService ts=new TraineeService();
	

	
	
	@RequestMapping(value="/",method=RequestMethod.GET )
	public String index() {
		return "index";		
	}
	
	@RequestMapping(value="insert",method=RequestMethod.GET )
	public String insert() {
		return "insert";		
	}
	
	@RequestMapping(value="inputparam",method=RequestMethod.POST )
	public String inputparam(@ModelAttribute TraineeDTO trainee) {

		
//		TraineeDTO insert = new TraineeDTO();
//		insert.setName(name);
//		insert.setAge(age);
//		insert.setPhoneNumber(phoneNumber);
//		insert.setGender(gender);
//		insert.setBirth(birth);
//		insert.setAddress(address);
		System.out.println("컨트롤러");
		System.out.println(trainee);
		
		ts.insert(trainee);
		return "index";		
	}
	
	@RequestMapping (value="/findAll", method=RequestMethod.GET)
	public String findAll(Model model) {
		System.out.println("전체목록");
		//select * from Trainee 결과를 mybatis가 List에 담아주고 그 리턴을 가져옴
		List <TraineeDTO> tList=ts.findAll();
		model.addAttribute("tList",tList);
		return "findAlljsp";
	}
	
	@RequestMapping(value="/findById",method=RequestMethod.GET )
	public String findById(Model model ,@RequestParam ("tnumber") long tnumber) {
		model.addAttribute("tn", tnumber);
		
		TraineeDTO trainee =ts.findById(tnumber);
		model.addAttribute("where", trainee);
		/*
		 *TraineeService.findById()호출
		 *TraineeRepository.findById()호출 (mapper 호출시 sql.selectOne()메서드 사용)
		 *trainee-mapper.findById 호출 (mapper에서 parameterType="long" 이라고 하면됨)
		 *
		 * 호출하고 역순으로 리턴을 가져와서 (리턴없이 뭐가 돼야 할지 관건)
		 * 최종 출력은 detail.jsp에서 출력하면 됨
		 */
		
		//ts.findById(tnumber);
		return "findById";		
	}
	
}
