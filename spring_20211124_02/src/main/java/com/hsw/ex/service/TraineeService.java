package com.hsw.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hsw.ex.dto.TraineeDTO;
import com.hsw.ex.repository.TraineeRepositroy;

@Service
public class TraineeService {
	
	@Autowired
	private TraineeRepositroy tr;

	public void insert(TraineeDTO trainee) {
		System.out.println("TraineeService()메서드 호출");
		System.out.println("객체값 : " +trainee);
		
		tr.insert(trainee);
	}

	public List<TraineeDTO> findAll() {
		List<TraineeDTO> tList=tr.findAll();
		
		for(TraineeDTO t: tList) {
			System.out.println(t);
		}
		return tList;
	}

	public TraineeDTO findById(long tnumber) {
		// TODO Auto-generated method stub
		TraineeDTO trainee = tr.findById(tnumber);
		System.out.println("TraineeService.findById() : " +trainee);
		return trainee;
	}

}
