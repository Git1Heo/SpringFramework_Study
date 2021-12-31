package com.icia.member.Repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.member.dto.IdPwDTO;
import com.icia.member.dto.MemberDTO;

@Repository
public class MemberRepository {
	@Autowired
	private SqlSessionTemplate sql;
	
	
	
	public void insert(MemberDTO member) {
		//System.out.println("리파지토리" +member);
		sql.insert("Member.insertMember", member);
	
	}



	public MemberDTO signin(IdPwDTO idpw) {
		//System.out.println("리파지토리 아이디 비밀번호" +idpw);
		return sql.selectOne("Member.signin", idpw);
	}



	public List<MemberDTO> findAll() {
		return sql.selectList("Member.findAll");
	
	}



	public MemberDTO detail(long m_number) {
		return sql.selectOne("Member.detail", m_number);
	}



	public void remove(long m_number) {
		sql.delete("Member.remove", m_number);
		
	}



	public void update(MemberDTO member) {
		sql.update("Member.update", member);		
	}



	public String idDuplicate(String m_id) {
		return sql.selectOne("Member.idDuplicate",m_id);
	}

}
