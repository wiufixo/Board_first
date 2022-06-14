package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardCommentVO {
	private int commentNo;
	private int custNo;
	private int boardNo;
	private String content;
	private int bc_ref;
	private int bc_step;
	private int bc_level;
	private Date created;
	private Date updated;
}
