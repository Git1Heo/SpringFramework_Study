package com.icia.board.service;

import java.util.List;

import com.icia.board.dto.CommentDTO;

public interface CommentServive {

	public void save(CommentDTO comment);

	public List<CommentDTO> findAll(long b_number);

	

}
