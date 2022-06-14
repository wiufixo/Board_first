package com.example.demo.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.dao.BoardDAO;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.ListBoardVO;

import lombok.Setter;

@Controller
@Setter
public class BoardController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/listBoard")
	public void findAllBoard(Model model) {
		model.addAttribute("list", dao.findAllBoard());
	}
	
	@RequestMapping("/detailBoard")
	public void detailOfBoard(Model model, int no) {
		model.addAttribute("b", dao.detailOfBoard(no));
	}
	@RequestMapping(value = "/insertBoard", method = RequestMethod.GET)
	public void insertBoardForm(Model model) {
		
	}
	@RequestMapping(value = "/insertBoard", method = RequestMethod.POST)
	public ModelAndView insertBoardSubmit(BoardVO b) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.insertBoard(b);
		if(re == -1) {
			mav.addObject("msg", "게시글 등록에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value = "/updateBoard", method = RequestMethod.GET)
	public void updateBoardForm(Model model, int no) {
		ListBoardVO b = dao.detailOfBoard(no);
		model.addAttribute("b", b);

	}
	@RequestMapping(value = "/updateBoard", method = RequestMethod.POST)
	public ModelAndView updateBoardSubmit(HashMap map) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.updateBoard(map);
		if(re == -1) {
			mav.addObject("msg", "게시글 수정에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping("/deleteBoard")
	public ModelAndView deleteBoard(int no) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		mav.setViewName("/listBoard");
		re = dao.deleteBoard(no);
		if(re == -1) {
			mav.addObject("msg", "게시글 삭제에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}
