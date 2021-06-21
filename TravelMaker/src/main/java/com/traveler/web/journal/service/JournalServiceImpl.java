package com.traveler.web.journal.service;

import java.sql.Date;
import java.util.List;
import javax.inject.Inject;
import org.springframework.stereotype.Service;

import com.traveler.web.journal.dao.JournalDAO;
import com.traveler.web.journal.model.JournalVO;

@Service
public class JournalServiceImpl implements JournalService{
	@Inject
	private JournalDAO journalDAO;
	
	@Override
	public List<JournalVO> getJournalList(String author) throws Exception{
		return journalDAO.getJournalList(author);
	}
	
	@Override
	public void insertJournal(JournalVO journalVO) throws Exception {
		journalDAO.insertJournal(journalVO);
	}
	@Override
	public JournalVO getJournalContent(int journal_no) throws Exception{
	      journalDAO.updateViewCnt(journal_no);
	      return journalDAO.getJournalContent(journal_no);
	}
	
	@Override
	public void updateJournal(JournalVO journalVO) throws Exception{
		journalDAO.updateJournal(journalVO);
	}
	
	@Override
	public void deleteJournal(int journal_no) throws Exception{
		journalDAO.deleteJournal(journal_no);
	}

	@Override
	public List<JournalVO> searchListTitle(String title) throws Exception {
		return journalDAO.searchListTitle(title);
	}

	@Override
	public List<JournalVO> searchListDate(String searchDate) throws Exception {
		return journalDAO.searchListDate(searchDate);

	}

	@Override
	public List<JournalVO> searchListAuthor(String author) throws Exception {
		return journalDAO.searchListAuthor(author);
	}
	
	
	
}
