package com.icia.member.Service;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.member.Repository.MemberRepository;
import com.icia.member.dto.IdPwDTO;
import com.icia.member.dto.MemberDTO;

@Service
public class MemberService {
	@Autowired
	private MemberRepository mp;
	@Autowired
	private HttpSession session ;
	
	public void insert(MemberDTO member) {
		mp.insert(member);
		
	}

	public String signin(IdPwDTO idpw) {
		MemberDTO member =mp.signin(idpw);
		
		if(member != null) {			
			session.setAttribute("loginID", idpw.getM_id());
			session.setAttribute("loginNum", member.getM_number());
			return "main";
		}
		else
			return "signin";
		//return member;
	}

	public List<MemberDTO> findAll() {
		List <MemberDTO> mList=mp.findAll();
		for(MemberDTO t: mList) {
			System.out.println("리스트" +t);
		}
		return mList;
	}

	public MemberDTO detail(long m_number) {
		MemberDTO memberde =mp.detail(m_number);
		return memberde;
	}

	public void remove(long m_number) {
		mp.remove(m_number);
		
	}

	public void update(MemberDTO member) {
		mp.update(member);
		
	}

	public String idDuplicate(String m_id) {
		String result=mp.idDuplicate(m_id);
		if (result==null)
			return "ok"; //조회결과가 없기 때문에 해당 아이디는 사용 가능
		else
			return "no"; //조회결과가 있기 때문에 해당 아이디는 사용 불가능
	}

}
