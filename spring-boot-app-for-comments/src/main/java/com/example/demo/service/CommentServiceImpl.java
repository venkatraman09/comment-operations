package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.demo.dto.CommentRepository;
import com.example.demo.model.CommentTable;

@Component
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepository;

	@Override
	public List<CommentTable> getAllComments() {
		List<CommentTable> commentList = new ArrayList<>();
		commentList= commentRepository.findAll();
		return commentList;
	}

	@Override
	public void saveComments(CommentTable commentTable) {
		commentRepository.save(commentTable);
		
	}

	@Override
	public Optional<CommentTable> getComment(Long id) {
		return commentRepository.findById(id);
	}

	@Override
	public void saveChildComments(CommentTable commentTable, long id) {
		CommentTable comment = new CommentTable();
		CommentTable ct = new CommentTable();
		Optional<CommentTable> table = commentRepository.findById(id);
		comment = table.get();
		ct.setId(comment.getId());
		ct.setComments(comment.getComments());
		commentTable.setParentComment(ct);
		commentRepository.save(commentTable);
		
	}}
