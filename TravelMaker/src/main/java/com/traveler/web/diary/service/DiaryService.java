package com.traveler.web.diary.service;

import java.util.List;

import com.traveler.web.diary.model.DiaryVO;




public interface DiaryService {
	
	List<DiaryVO> getList(int journal_no);
	
//	List<BoardVO> getList(Criteria cri);
	
	int write(DiaryVO diary);
	
	DiaryVO info(int diary_no);
	
	int delete(int diary_no);
	
	int update(DiaryVO diary);
	
	
	

}
