package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class ListBoardVO {
	private int boardNo;
	private String title;
	private String nickName;
	private int b_ref;
	private int b_step;
	private int b_level;
	private Date created;
	private Date updated;
	private int hit;
}
