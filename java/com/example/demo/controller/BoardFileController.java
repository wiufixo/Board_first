package com.example.demo.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardCommentVO;
import com.example.demo.vo.BoardFileVO;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.ListBoardCommentVO;

import lombok.Setter;

@Controller
@Setter
public class BoardFileController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/listBoardFile")
	@ResponseBody //첨부파일 뷰가 따로 없다
	public List<BoardFileVO> findAllBoardFileByBoardNo(int no) {
		return dao.findAllBoardFileByBoardNo(no);
	}
	@RequestMapping(value = "/insertBoardFile", method = RequestMethod.GET)
	public void insertBoardFileForm() {
		
	}
	@RequestMapping(value = "/insertBoardFile", method = RequestMethod.POST)
	public ModelAndView insertBoardFileSubmit(BoardFileVO f) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.insertBoardFile(f);
		if(re == -1) {
			mav.addObject("msg", "파일 등록에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value = "/updateBoardFile", method = RequestMethod.POST)
	public ModelAndView updateBoardFileSubmit(HashMap map) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.updateBoardFile(map);
		if(re == -1) {
			mav.addObject("msg", "파일 수정에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping("/deleteBoardFile")
	public ModelAndView deleteBoardFile(int no) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.deleteBoardFile(no);
		if(re == -1) {
			mav.addObject("msg", "파일 삭제에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}
