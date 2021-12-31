package com.hsw.ex.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hsw.ex.dto.TraineeDTO;

@Repository
public class TraineeRepositroy {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void insert(TraineeDTO trainee) {
	
		sql.insert("Trainee.insertTrainee", trainee);
		//Trainee -> namespace
		//insertTrainee -> id
		//전달한 매개변수
		
	}

	public List<TraineeDTO> findAll() {
		
		return sql.selectList("Trainee.findAll");
	}

	public TraineeDTO findById(long tnumber) {
		
		return sql.selectOne("Trainee.findById", tnumber);
	}

}
