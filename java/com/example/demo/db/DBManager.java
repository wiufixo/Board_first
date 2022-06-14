package com.example.demo.db;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.example.demo.vo.BoardCommentVO;
import com.example.demo.vo.BoardFileVO;
import com.example.demo.vo.BoardVO;
import com.example.demo.vo.ListBoardCommentVO;
import com.example.demo.vo.ListBoardVO;

public class DBManager {
	public static SqlSessionFactory sqlSessionFactory;
	static {
		try {
			String resource = "com/example/demo/db/sqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch (Exception e) {
			System.out.println("예외발생: "+e.getMessage());
		}
	}
	
	//게시글 관련
	static public List<ListBoardVO> findAllBoard(){
		List<ListBoardVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("board.findAllBoard");
		return list;
	}
	static public ListBoardVO detailOfBoard(int no) {
		ListBoardVO b = null;
		SqlSession session = sqlSessionFactory.openSession();
		b = session.selectOne("board.detailOfBoard", no);
		return b;
	}
	static public void updateHit(int no) {
		SqlSession session = sqlSessionFactory.openSession();
		session.update("board.updateHit", no);
	}
	static public int getNextBoardNo() {
		int no = 0;
		SqlSession session = sqlSessionFactory.openSession();
		no = session.selectOne("board.getNextBoardNo");
		return no;
	}
	static public int insertBoard(BoardVO b) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("board.insertBoard", b);
		return re;
	}
	static public int updateBoardStep(HashMap map) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("board.updateBoardStep", map);
		return re;
	}
	static public int updateBoard(HashMap map) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("board.updateBoard", map);
		return re;
	}
	static public int deleteBoard(int no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("board.deleteBoard", no);
		return re;
	}
	
	//댓글 관련
	static public int countBoardComment(int no) {
		int cnt = 0;
		SqlSession session = sqlSessionFactory.openSession();
		cnt = session.selectOne("boardComment.countBoardComment", no);
		return cnt;
	}
	static public List<ListBoardCommentVO> findAllBoardCommentByBoardNo(int no){
		List<ListBoardCommentVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("boardComment.findAllBoardCommentByBoardNo", no);
		return list;
	}
	static public ListBoardCommentVO detailOfBoardComment(int no) {
		ListBoardCommentVO bc = null;
		SqlSession session = sqlSessionFactory.openSession();
		bc = session.selectOne("board.insertBoard", no);
		return bc;
	}
	static public int getNextBoardCommentNo() {
		int no = 0;
		SqlSession session = sqlSessionFactory.openSession();
		no = session.selectOne("boardComment.getNextBoardCommentNo");
		return no;
	}
	static public int insertBoardComment(BoardCommentVO bc) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("boardComment.insertBoardComment", bc);
		return re;
	}
	static public int updateBoardCommentStep(HashMap map) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("boardComment.updateBoardCommentStep", map);
		return re;
	}
	static public int updateBoardComment(HashMap map) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("boardComment.updateBoardComment", map);
		return re;
	}
	static public int deleteBoardComment(int no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("boardComment.deleteBoardComment", no);
		return re;
	}
	
	//첨부파일 관련
	static public List<BoardFileVO> findAllBoardFileByBoardNo(int no){
		List<BoardFileVO> list = null;
		SqlSession session = sqlSessionFactory.openSession();
		list = session.selectList("boardFile.findAllBoardFileByBoardNo", no);
		return list;
	}
	static public int getNextBoardFileNo() {
		int no = 0;
		SqlSession session = sqlSessionFactory.openSession();
		no = session.selectOne("boardFile.getNextBoardFileNo");
		return no;
	}
	static public int insertBoardFile(BoardFileVO f) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("boardFile.insertBoardFile", f);
		return re;
	}
	static public int updateBoardFile(HashMap map) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.update("board.updateBoardFile", map);
		return re;
	}
	static public int deleteBoardFile(int no) {
		int re = -1;
		SqlSession session = sqlSessionFactory.openSession(true);
		re = session.insert("board.deleteBoardFile", no);
		return re;
	}
}
