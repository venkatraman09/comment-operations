package com.example.demo.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@GeneratedValue(strategy = GenerationType.AUTO)  
	@Column(name = "id",updatable = false)
	private long id;
	public Set<CommentTable> getChildrenComments() {
		return childrenComments;
	}

	public void setChildrenComments(Set<CommentTable> childrenComments) {
		this.childrenComments = childrenComments;
	}

	@Column(name = "comments")
	private String comments;

	@OneToMany(mappedBy="parentComment", cascade = CascadeType.ALL)
	
	@JsonManagedReference
	
	private Set<CommentTable> childrenComments;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parent_id")
	@JsonBackReference
	private CommentTable parentComment;

}
