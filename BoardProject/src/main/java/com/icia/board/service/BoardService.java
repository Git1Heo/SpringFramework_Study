package com.icia.board.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icia.board.dto.PageDTO;
import com.icia.board.dto.BoardDTO;
import com.icia.board.repository.BoardRepository;

public interface BoardService{
	// interface
	// 추상 메서드 가짐. => 실행블록은 없고 메소드 선언부만 있는것
	// interface를 구현(implements)하는 구현 클래스에서 실행블록을 작성함.
	public void insert(BoardDTO board);
	public List<BoardDTO> findAll();
	public void delete(long b_number);
	public void update(BoardDTO board);
	public BoardDTO detail(long b_number);
	public BoardDTO view(long b_number);
	
	public PageDTO paging(int page);
	public List<BoardDTO> pagingList(int page);
	public List<BoardDTO> search(String searchtype, String keyword);
	public void insertfile(BoardDTO board) throws IllegalStateException, IOException;
	
	
}


//@Service
//public class BoardService {
//
//	@Autowired
//	private BoardRepository br;
//	
//	public void insert(BoardDTO board) {
//		br.insert(board);		
//	}
//
//	public List<BoardDTO> findAll() {
//		List <BoardDTO> bList = br.findAll();
//		return bList;
//	}
//
//	public void delete(long b_number) {
//		br.delete(b_number);
//		
//	}
//
//	public void update(BoardDTO board) {
//		br.update(board);
//		
//	}
//
//	public BoardDTO detail(long b_number) {
//		BoardDTO board =br.detail(b_number);
//		return board;
//	}
//
//	public BoardDTO view(long b_number) {
//		BoardDTO board =br.view(b_number);
//		return board;
//	}
//
//}
