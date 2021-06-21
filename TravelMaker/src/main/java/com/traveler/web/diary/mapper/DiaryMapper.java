package com.traveler.web.diary.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.traveler.web.diary.model.DiaryVO;



public interface DiaryMapper {
	
	public List<DiaryVO> getList(int journal_no);
	
//	public List<BoardVO> getListPaging(Criteria cri);
	
	public void insert(DiaryVO diary);
	
	public void insertSelectKey(DiaryVO diary);
	
	public DiaryVO read(int diary_no);
	
	public int delete(int diary_no);
	
	public int update(DiaryVO diary);
	

}
