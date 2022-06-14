package com.example.demo.vo;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	private int boardNo;
	private int custNo;
	private String title;
	private String content;
	private int b_ref;
	private int b_step;
	private int b_level;
	private Date created;
	private Date updated;
	int hit;
}
