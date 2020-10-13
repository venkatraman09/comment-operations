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

	/**
	 *  getAllComments is used to get all the comments from the database
	 * @return
	 */
	@Override
	public List<CommentTable> getAllComments() {
		List<CommentTable> commentList = new ArrayList<>();
		commentList= commentRepository.findAll();
		return commentList;
		
	}

	/**
	 * saveComments is used to save comment into database
	 * @param commentTable
	 */
	@Override
	public void saveComments(CommentTable commentTable) {
		
		CommentTable table =new  CommentTable();
		table.setId(commentTable.getId());
		table.setComments(commentTable.getComments());
		table.setParentComment(commentTable.getParentComment());
		commentRepository.save(table);
	}

	/**
	 * getComment method is used to get particular comment from the database.
	 * @param id
	 * @return Optional<CommentTable>
	 */
	@Override
	public Optional<CommentTable> getComment(Long id) {
		
		return commentRepository.findById(id);
		
	}

}
