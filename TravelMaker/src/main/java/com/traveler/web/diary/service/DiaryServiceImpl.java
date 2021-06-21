package com.traveler.web.diary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.traveler.web.diary.mapper.DiaryMapper;
import com.traveler.web.diary.model.DiaryVO;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@ToString
public class DiaryServiceImpl implements DiaryService {

	private final DiaryMapper mapper;

	@Override
	public List<DiaryVO> getList(int journal_no) {
		return mapper.getList(journal_no);
	}

	@Override
	public int write(DiaryVO diary) {
		mapper.insert(diary);
		return diary.getDiary_no();
	}

	@Override
	public DiaryVO info(int diary_no) {
		return mapper.read(diary_no);
	}

	@Override
	public int delete(int diary_no) {
		return mapper.delete(diary_no);
	}

	@Override
	public int update(DiaryVO diary) {
		return mapper.update(diary);
	}

//	@Override
//	public List<BoardVO> getList(Criteria cri) {
//		return mapper.getListPaging(cri);
//	}

}
