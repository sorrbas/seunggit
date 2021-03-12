package org.zerock.mapper;

import java.util.List;
import java.util.Map;

import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

public interface BoardMapper {

	
	public abstract List<BoardVO> getList();
	
	public abstract List<BoardVO> getListWithPaging(Criteria cri);
	
	public abstract void insert(BoardVO board);
	
	public abstract void insertSelectKey(BoardVO board);
	
	public abstract BoardVO read(Long bno);
	
	public abstract int delete(Long bno);
	
	public abstract int update(BoardVO board);
	
	public abstract int getTotalCount(Criteria cri);
	
	public abstract List<BoardVO> searchTest(Map<String,Map<String,String>> map);
}