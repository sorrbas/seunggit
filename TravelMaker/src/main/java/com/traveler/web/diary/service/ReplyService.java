package com.traveler.web.diary.service;

import java.util.List;

import com.traveler.web.diary.model.ReplyVO;

public interface ReplyService {
	
	
	public List<ReplyVO> viewReply(int diary_no);
	
	public void writeReply(ReplyVO vo);
	
	public void updateReply(ReplyVO vo);
	
	public ReplyVO selectReply(int reply);

	public void deleteReply(ReplyVO vo);
	

}
