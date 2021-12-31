package com.icia.board.repository;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.icia.board.dto.BoardDTO;

@Repository
public class BoardRepository {
	
	@Autowired
	private SqlSessionTemplate sql;
	
	public void insert(BoardDTO board) {
		sql.insert("Board.insert", board);
		
	}

	public List<BoardDTO> findAll() {
		return sql.selectList("Board.findAll");
		
	}

	public void delete(long b_number) {
		sql.delete("Board.delete", b_number);
		
	}

	public void update(BoardDTO board) {
		sql.update("Board.update", board);
		
	}

	public BoardDTO detail(long b_number) {
		return sql.selectOne("Board.detail", b_number);
		
	}
	
	public BoardDTO view(long b_number) {
		sql.update("Board.viewAdd",b_number);
		BoardDTO board= sql.selectOne("Board.detail", b_number);
		return board;
		
	}
	
	public int boardCount() {
		return sql.selectOne("Board.count");
	}
	
	public List<BoardDTO> pagingList(int pagingStart) {
		return sql.selectList("Board.pagingList", pagingStart);
	}

	public List<BoardDTO> pagingList1(Map<String, Integer> pagingParam) {
		return sql.selectList("Board.pagingList1", pagingParam);
	}

	public List<BoardDTO> search(Map<String, String> searchParam) {
		
		return sql.selectList("Board.search",searchParam);
	}

	public void insertFile(BoardDTO board) {
		sql.insert("Board.insertfile", board);
	}

	


}
