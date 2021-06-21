package com.traveler.web.map.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.traveler.web.diary.model.DiaryVO;
import com.traveler.web.journal.model.JournalVO;
import com.traveler.web.map.dao.MyMapDAO;

@Service
public class MyMapServiceImpl implements MyMapService{
	@Inject
	private MyMapDAO mymapDAO;
	
	@Override
	public List<JournalVO> getMyJournalList(String author) throws Exception{
		return mymapDAO.getMyJournalList(author);
	}
	
	@Override 
	public JournalVO getMyJournalTitle(int journal_no) throws Exception{
		return mymapDAO.getMyJournalTitle(journal_no);
	}

	@Override
	public List<DiaryVO> getMyMapDiary(int journal_no) throws Exception {
		return mymapDAO.getMyMapDiary(journal_no);
	}
}
