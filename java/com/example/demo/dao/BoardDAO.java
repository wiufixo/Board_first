package com.example.demo.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.demo.db.DBManager;
import com.example.demo.vo.BoardCommentVO;
import com.example.demo.vo.BoardFileVO;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.ListBoardCommentVO;
import com.example.demo.vo.ListBoardVO;

@Repository
public class BoardDAO {
	//게시글 관련 DAO
	public List<ListBoardVO> findAllBoard(){
		return DBManager.findAllBoard();
	}
	public ListBoardVO detailOfBoard(int no) {
		return DBManager.detailOfBoard(no);
	}
	public void updateHit(int no) {
		DBManager.updateHit(no);
	}
	public int getNextBoardNo() {
		return DBManager.getNextBoardNo();
	}
	public int insertBoard(BoardVO b) {
		return DBManager.insertBoard(b);
	}
	public int updateBoardStep(HashMap map) {
		return DBManager.updateBoardStep(map);
	}
	public int updateBoard(HashMap map) {
		return DBManager.updateBoard(map);
	}
	public int deleteBoard(int no) {
		return DBManager.deleteBoard(no);
	}
	
	//댓글 관련 DAO
	public int countBoardComment(int no) {
		return DBManager.countBoardComment(no);
	}
	public List<ListBoardCommentVO> findAllBoardCommentByBoardNo(int no){
		return DBManager.findAllBoardCommentByBoardNo(no);
	}
	public int getNextBoardCommentNo() {
		return DBManager.getNextBoardCommentNo();
	}
	public int insertBoardComment(BoardCommentVO bc) {
		return DBManager.insertBoardComment(bc);
	}
	public int updateBoardCommentStep(HashMap map) {
		return DBManager.updateBoardCommentStep(map);
	}
	public ListBoardCommentVO detailOfBoardComment(int no) {
		return DBManager.detailOfBoardComment(no);
	}
	public int updateBoardComment(HashMap map) {
		return DBManager.updateBoardComment(map);
	}
	public int deleteBoardComment(int no) {
		return DBManager.deleteBoardComment(no);
	}
	
	//게시글 첨부파일 관련 DAO
	public List<BoardFileVO> findAllBoardFileByBoardNo(int no){
		return DBManager.findAllBoardFileByBoardNo(no);
	}
	public int getNextBoardFileNo() {
		return DBManager.getNextBoardFileNo();
	}
	public int insertBoardFile(BoardFileVO f) {
		return DBManager.insertBoardFile(f);
	}
	public int updateBoardFile(HashMap map) {
		return DBManager.updateBoardFile(map);
	}
	public int deleteBoardFile(int no) {
		return DBManager.deleteBoardFile(no);
	}
	
}
