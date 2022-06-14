package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ListBoardCommentVO {
	private int boardNo;
	private int commentNo;
	private String nickName;
	private String content;
	private int c_ref;
	private int c_step;
	private int c_level;
	private Date created;
}
