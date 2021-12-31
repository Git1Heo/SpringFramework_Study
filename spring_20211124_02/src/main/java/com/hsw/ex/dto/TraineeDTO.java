package com.hsw.ex.dto;

import java.sql.Date;

import lombok.Data;

@Data
public class TraineeDTO {
	
	private long tnumber;
	private String t_name;
	private String age;
	private String phoneNumber;
	private String gender;
	private String birth;
	private String address;

}
