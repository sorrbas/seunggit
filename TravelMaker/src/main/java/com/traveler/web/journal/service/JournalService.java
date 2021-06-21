package com.traveler.web.journal.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.traveler.web.journal.model.JournalVO;

public interface JournalService {
	public List<JournalVO> getJournalList(String author) throws Exception;
	public void insertJournal(JournalVO journalVO) throws Exception;
	public JournalVO getJournalContent(int journal_no) throws Exception;
	public void updateJournal(JournalVO journalVO) throws Exception;
	public void deleteJournal(int journal_no) throws Exception;
	public List<JournalVO> searchListTitle(String title) throws Exception;//첫번째 매개변수 = 무엇으로 검색할것인지(제목,날짜,작성자) 두번째 매개변수 = (검색값들) 
	public List<JournalVO> searchListDate(String searchDate) throws Exception;//첫번째 매개변수 = 무엇으로 검색할것인지(제목,날짜,작성자) 두번째 매개변수 = (검색값들) 
	public List<JournalVO> searchListAuthor(String author) throws Exception;//첫번째 매개변수 = 무엇으로 검색할것인지(제목,날짜,작성자) 두번째 매개변수 = (검색값들) 

}
