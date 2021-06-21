package com.traveler.web.diary.mapper;

import java.util.List;

import com.traveler.web.diary.model.ReplyVO;

public interface ReplyMapper {
	
	public List<ReplyVO> viewReply(int diary_no);
	
	public void writeReply(ReplyVO vo);
	
	public void updateReply(ReplyVO vo);
	
	public void deleteReply(ReplyVO vo);
	
	public ReplyVO selectReply(int reply);

}
