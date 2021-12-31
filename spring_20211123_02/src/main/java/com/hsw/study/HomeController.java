package com.hsw.study;

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

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {		
		return "index";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String idpw(@RequestParam("id") String id,
						@RequestParam("pw") String pw) {
		System.out.println("inputParam메소드");
		System.out.println("param1 : " +id+ "  param2 : "+pw);
		return "index";
		
	}
	
}
