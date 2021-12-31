package com.icia.board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.board.dto.BoardDTO;
import com.icia.board.service.BoardService;


@Controller
public class HomeController {
//	@Autowired
//	private BoardService bs;
	
	// 홈
	@RequestMapping (value="/" ,method=RequestMethod.GET)
	public String index() {
		return "/index";
	}
	
//	// 글작성
//	@RequestMapping (value="/insert" ,method=RequestMethod.GET)
//	public String insert() {
//		//views/board 폴더의 insert.jsp 출력
//		return "/board/insert";
//	}    ------------> BoardController로 이동
	
	// 글 작성 후 글 목록으로 가도록
//	@RequestMapping (value="/insert" ,method=RequestMethod.POST)
//	public String boardInsert(@ModelAttribute BoardDTO board) {
//		bs.insert(board);
//		
//		return "redirect:/findAll";
//	}  	-----------------> BoardController로 이동
	
	// 글목록
//	@RequestMapping (value="/findAll" ,method=RequestMethod.GET)
//	public String findAll(Model model) {
//		
//		List <BoardDTO> bList = bs.findAll();
//		model.addAttribute("bList", bList);
//		return "findAll";
//	}	-----------------> BoardController로 이동
	
	// 삭제
//	@RequestMapping (value="/delete" ,method=RequestMethod.GET)
//	public String delete(Model model, @RequestParam ("b_number")long b_number) {
//		
//		bs.delete(b_number);
//		return "redirect:/findAll";
//	}	-----------------> BoardController로 이동
	
	//수정
//	@RequestMapping (value="/update" ,method=RequestMethod.GET)
//	public String update(@RequestParam ("b_number") long b_number, Model model) {
//		
//		BoardDTO board =bs.detail(b_number);
//		model.addAttribute("updateShow", board);
//		return "/update";
//	}	-----------------> BoardController로 이동
	
	//수정
//	@RequestMapping (value="/update" ,method=RequestMethod.POST)
//	public String updateBoard(@ModelAttribute BoardDTO board) {	
//		bs.update(board);
//		return "redirect:/findAll";
//	}	-----------------> BoardController로 이동
	
	//조회
//	@RequestMapping (value="/view" ,method=RequestMethod.GET)
//	public String view(@RequestParam ("b_number") long b_number, Model model ) {
//	
//		BoardDTO board =bs.view(b_number);
//		model.addAttribute("view", board);
//		return "/view";
//	}	-----------------> BoardController로 이동
	
}
