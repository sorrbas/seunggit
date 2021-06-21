package com.traveler.web.diary.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.traveler.web.diary.mapper.DiaryMapper;
import com.traveler.web.diary.mapper.ReplyMapper;
import com.traveler.web.diary.model.ReplyVO;

@Service
public class ReplyServiceImpl implements ReplyService {

	
	
	@Inject
	private ReplyMapper mapper;
	
	
	
	@Override
	public List<ReplyVO> viewReply(int diary_no) {
		return mapper.viewReply(diary_no);
		
		
	}



	@Override
	public void writeReply(ReplyVO vo) {
		mapper.writeReply(vo);
		
		
	}



	
	@Override
	public void updateReply(ReplyVO vo) {
		 mapper.updateReply(vo);
		
	}



	@Override
	public void deleteReply(ReplyVO vo) {
		mapper.deleteReply(vo);
		
	}



	@Override
	public ReplyVO selectReply(int reply) {
		return mapper.selectReply(reply);
	}

}
