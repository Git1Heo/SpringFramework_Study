package com.icia.board.Controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.icia.board.dto.BoardDTO;
import com.icia.board.dto.CommentDTO;
import com.icia.board.dto.PageDTO;
import com.icia.board.service.BoardService;
import com.icia.board.service.CommentServive;

@Controller
@RequestMapping(value="/board/*")

public class BoardController {
	
	@Autowired
	private BoardService bs;
	@Autowired
	private CommentServive cs;
	
	// 글작성
	@RequestMapping (value="/insert" ,method=RequestMethod.GET)
	public String insert() {
		//views/board 폴더의 insert.jsp 출력
		return "/board/insert";
	}
	
	// 글 작성 후 글 목록으로 가도록
	@RequestMapping (value="/insert" ,method=RequestMethod.POST)
	public String boardInsert(@ModelAttribute BoardDTO board) {
		bs.insert(board);
		
		return "redirect:/board/paging";
	}
	
	@RequestMapping (value="/insertfile" ,method=RequestMethod.POST)
	public String insertfile(@ModelAttribute BoardDTO board) throws IllegalStateException, IOException {
		bs.insertfile(board);
		
		return "redirect:/board/paging";
	}	
	
	
	// 글목록
	@RequestMapping (value="/findAll" ,method=RequestMethod.GET)
	public String findAll(Model model) {
		
		List <BoardDTO> bList = bs.findAll();
		model.addAttribute("bList", bList);
		return "/board/findAll";
	}
	
	// 삭제
	@RequestMapping (value="/delete" ,method=RequestMethod.GET)
	public String delete(Model model, @RequestParam ("b_number")long b_number) {
		
		bs.delete(b_number);
		return "redirect:/board/findAll";
	}
	
	//수정
	@RequestMapping (value="/update" ,method=RequestMethod.GET)
	public String update(@RequestParam ("b_number") long b_number, Model model,@RequestParam(value="page", required=false, defaultValue="1")int page) {
		BoardDTO board =bs.detail(b_number);
		model.addAttribute("updateShow", board);
		model.addAttribute("page", page);
		return "/board/update";
	}
	
	//수정
	@RequestMapping (value="/update" ,method=RequestMethod.POST)
	public String updateBoard(@ModelAttribute BoardDTO board, @RequestParam(value="page", required=false, defaultValue="1")int page) {	
		bs.update(board);
		return "redirect:/board/view?b_number="+board.getB_number()+"&page="+page;
	}
	
	//조회
	@RequestMapping (value="/view" ,method=RequestMethod.GET)
	public String view(@RequestParam ("b_number") long b_number, Model model,@RequestParam(value="page", required=false, defaultValue="1")int page ) {
	
		BoardDTO board =bs.view(b_number);
		model.addAttribute("view", board);
		model.addAttribute("page", page); //deatil.jsp로 갈 때 page값을 가지고 감
		List <CommentDTO> commentList=cs.findAll(b_number);
		model.addAttribute("commentList", commentList);
		return "/board/view";
	}
	
	//페이징 처리
	@RequestMapping(value="paging", method=RequestMethod.GET)
	// value : 파라미터 이름, required 필수 여부(false이면 없어도됨), defaultValue 기본값
	public String paging(@RequestParam(value="page", required=false, defaultValue="1")int page, Model model) {
		List<BoardDTO> boardList = bs.pagingList(page);  // 선택한 페이지의 값만 가져옴
		PageDTO paging = bs.paging(page);
		model.addAttribute("bList", boardList);
		model.addAttribute("paging", paging);
		return "board/findAll";
	}
	
	@RequestMapping(value="search", method=RequestMethod.GET)
	public String search(@RequestParam ("searchtype") String searchtype,
						 @RequestParam ("keyword") String keyword ,Model model) {
		List <BoardDTO> boardList=bs.search(searchtype,keyword);
		System.out.println(boardList);
		model.addAttribute("bList", boardList);
		return "/board/findAll";
	}

}
