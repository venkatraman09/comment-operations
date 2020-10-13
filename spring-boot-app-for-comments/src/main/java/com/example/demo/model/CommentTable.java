package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_comments")
public class CommentTable {
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public CommentTable getParentComment() {
		return parentComment;
	}

	public void setParentComment(CommentTable parentComment) {
		this.parentComment = parentComment;
	}

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)  
	@Column(name = "id")
	private long id;
	@Column(name = "comments")
	private String comments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	private CommentTable parentComment;

}
