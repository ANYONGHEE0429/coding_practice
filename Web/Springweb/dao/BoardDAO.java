package com.test.web.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.web.vo.BoardVO;
import com.test.web.vo.ReplyVO;

@Repository
public class BoardDAO {
	
	@Autowired
	private SqlSession sqlSession;
	
	public ArrayList<BoardVO> boardList(HashMap<String, String> map, int startRecord, int countPerPage) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		RowBounds rb = new RowBounds(startRecord, countPerPage); //목록을 다 뽑아온다음에 핀포인트를 뽑아 보는 것
		return mapper.boardList(map , rb);
	}
	
	public BoardVO boardRead(int boardNum) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		mapper.hitCount(boardNum);
		return mapper.boardRead(boardNum);
	}
	
	public int boardDelete(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardDelete(vo);
	}
	
	public int boardUpdate(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardUpdate(vo);
	}
	
	public int boardWrite(BoardVO vo) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.boardWrite(vo);
	}

	public void replyWrite(ReplyVO vo) {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.replyWrite(vo);
	}

	public ArrayList<ReplyVO> replyList(int boardNum) {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		return mapper.replyList(boardNum);
	}

	public void replyUpdate(ReplyVO vo) {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.replyUpdate(vo);
	}

	public void replyDelete(ReplyVO vo) {
		ReplyMapper mapper = sqlSession.getMapper(ReplyMapper.class);
		mapper.replyDelete(vo);
	}

	public int getTotal(HashMap<String, String> map) {
		BoardMapper mapper = sqlSession.getMapper(BoardMapper.class);
		return mapper.getTotal(map);
	}

	public void boardDownload() {
		// TODO Auto-generated method stub
		
	}
}
