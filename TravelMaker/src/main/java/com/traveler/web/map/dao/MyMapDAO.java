package com.traveler.web.map.dao;

import java.util.List;

import com.traveler.web.diary.model.DiaryVO;
import com.traveler.web.journal.model.JournalVO;

public interface MyMapDAO {
	public List<JournalVO> getMyJournalList(String author) throws Exception;
	
	public JournalVO getMyJournalTitle(int journal_no) throws Exception;
	
	public List<DiaryVO> getMyMapDiary(int journal_no) throws Exception;
}
