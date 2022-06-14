package com.example.demo.vo;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class BoardFileVO {
	private int fileNo;
	private int boardNo;
	private String fname;
	private MultipartFile uploadFile;
	private Date created;
	private Date updated;
}
