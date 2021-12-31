package com.icia.board.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icia.board.dto.CommentDTO;
import com.icia.board.service.CommentServive;

@Controller
public class CommentController {

	@Autowired
	private CommentServive cs;
		
	@RequestMapping (value ="/board/comment/save", method=RequestMethod.POST)
	public  @ResponseBody List<CommentDTO> save (@ModelAttribute CommentDTO comment){
		System.out.println("commentController.save() : " + comment);
		cs.save(comment);
		
		List<CommentDTO> commentList = cs.findAll(comment.getB_number());
		return commentList;
		}
	
}
