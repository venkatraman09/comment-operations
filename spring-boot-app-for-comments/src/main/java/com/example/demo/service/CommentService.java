package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.model.CommentTable;

public interface CommentService {

	List<CommentTable> getAllComments();

	void saveComments(CommentTable commentTable);

	 Optional<CommentTable>  getComment(Long id);

	void saveChildComments(CommentTable commentTable, long id);


}
