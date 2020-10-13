package com.example.demo.dto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.CommentTable;

@Repository
public interface CommentRepository extends JpaRepository<CommentTable,Long>{

	


}
