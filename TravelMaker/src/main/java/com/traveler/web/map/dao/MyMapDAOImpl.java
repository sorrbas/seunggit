package com.traveler.web.map.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.traveler.web.diary.model.DiaryVO;
import com.traveler.web.journal.model.JournalVO;

@Repository
public class MyMapDAOImpl implements MyMapDAO{
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public List<JournalVO> getMyJournalList(String author) throws Exception{
		return sqlSession.selectList("com.traveler.web.map.myMapMapper.getMyMapJournal",author);
	}
	
	@Override
	public JournalVO getMyJournalTitle(int journal_no) throws Exception{
		return sqlSession.selectOne("com.traveler.web.map.myMapMapper.getMyMapJournalTitle",journal_no);
	}

	@Override
	public List<DiaryVO> getMyMapDiary(int journal_no) throws Exception {
		return sqlSession.selectList("com.traveler.web.map.myMapMapper.getMyMapDiaryList",journal_no);
	}
}
