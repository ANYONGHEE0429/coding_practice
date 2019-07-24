package com.test.web.dao;

import java.util.ArrayList;

import com.test.web.vo.ReplyVO;

public interface ReplyMapper {

	public void replyWrite(ReplyVO vo);
	public ArrayList<ReplyVO> replyList(int boardNum);
	public void replyUpdate(ReplyVO vo);
	public void replyDelete(ReplyVO vo);
}
