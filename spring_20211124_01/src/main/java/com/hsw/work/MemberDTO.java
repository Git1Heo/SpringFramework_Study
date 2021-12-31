package com.hsw.work;

import org.springframework.stereotype.Controller;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pw;
	private String name;
	private String mail;
	private String gender;

	
}
