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
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.ListBoardCommentVO;

import lombok.Setter;

@Controller
@Setter
public class BoardCommentController {
	@Autowired
	private BoardDAO dao;
	
	@RequestMapping("/listBoardComment")
	@ResponseBody //댓글 뷰가 따로 없다
	public List<ListBoardCommentVO> findAllBoardCommentByBoardNo(int no) {
		return dao.findAllBoardCommentByBoardNo(no);
	}
	@RequestMapping("/countBoardComment") //게시글의 총댓글수
	@ResponseBody
	public int countBoardComment(int no) {
		return dao.countBoardComment(no);
	}
	@RequestMapping(value = "/insertBoardComment", method = RequestMethod.GET)
	public void insertBoardCommentForm(Model model) {
		
	}
	@RequestMapping(value = "/insertBoardComment", method = RequestMethod.POST)
	public ModelAndView insertBoardCommentSubmit(BoardCommentVO bc) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.insertBoardComment(bc);
		if(re == -1) {
			mav.addObject("msg", "댓글 등록에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping(value = "/updateBoardComment", method = RequestMethod.GET)
	public void updateBoardCommentForm(Model model, int no) {
		ListBoardCommentVO bc =  dao.detailOfBoardComment(no);
		model.addAttribute("bc", bc);

	}
	@RequestMapping(value = "/updateBoardComment", method = RequestMethod.POST)
	public ModelAndView updateBoardCommentSubmit(HashMap map) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.updateBoardComment(map);
		if(re == -1) {
			mav.addObject("msg", "댓글 수정에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
	@RequestMapping("/updateBoardComment")
	public ModelAndView deleteBoard(int no) {
		ModelAndView mav = new ModelAndView("redirect:/listBoard");
		int re = 1;
		re = dao.deleteBoardComment(no);
		if(re == -1) {
			mav.addObject("msg", "댓글 삭제에 실패하였습니다");
			mav.setViewName("error");
		}
		return mav;
	}
}
