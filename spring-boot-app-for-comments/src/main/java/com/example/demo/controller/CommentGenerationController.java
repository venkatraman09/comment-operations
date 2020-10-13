package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.CommentTable;
import com.example.demo.service.CommentService;

/**
 * @author Venkatraman Athmanathan
 *
 */
@RestController
@RequestMapping("/comments")
public class CommentGenerationController {
	
	@Autowired
	private CommentService commentService;
	
	/**
	 *  getAllComments is used to get all the comments from the database
	 * @return
	 */
	@RequestMapping("/getAllComments")
	public List<CommentTable> getAllComments() {
		return commentService.getAllComments();
		
	}
	
	/**
	 * saveComments is used to save comment into database
	 * @param commentTable
	 */
	@RequestMapping(value = "/saveComments",method = RequestMethod.POST)
	public void saveComments(@RequestBody CommentTable commentTable) {
		commentService.saveComments(commentTable);
	}

	/**
	 * getComment method is used to get particular comment from the database.
	 * @param id
	 * @return Optional<CommentTable>
	 */
	@RequestMapping("/getComment/{id}")
	public Optional<CommentTable> getComments(@PathVariable long id){
		return commentService.getComment(id);
	}

}
