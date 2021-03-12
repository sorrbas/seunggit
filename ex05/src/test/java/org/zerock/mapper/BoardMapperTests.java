package org.zerock.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
  
  @Setter(onMethod_ = @Autowired)
  private BoardMapper mapper;
  
  @Test
  public void testGetList() {
    mapper.getList().forEach(board -> log.info(board));
  }
  @Test
  public void testPaging() {
	  Criteria cri = new Criteria();
	  //10개씩 3페이지
	  cri.setPageNum(3);
	  cri.setAmount(10);
	  List<BoardVO> list = mapper.getListWithPaging(cri);
	  list.forEach(board->log.info(board));
  }
  @Test
  public void testInsert() {
	  BoardVO board = new BoardVO();
	  board.setTitle("새로작성하는글");
	  board.setContent("새로작성하는내용");
	  board.setWriter("newkh");
	  mapper.insert(board);
  }
  @Test
  public void testInsertSelectKey() {
	  BoardVO board = new BoardVO();
	  board.setTitle("새로작성하는글 select key");
	  board.setContent("새로작성하는내용 select key");
	  board.setWriter("newkh");
	  mapper.insertSelectKey(board);
	  log.info(board);
  }
  @Test
  public void testRead() {
	  //존재하는 게시물 번호로 테스트
	  BoardVO board = mapper.read(5L);
	  log.info(board);
  }
  @Test
  public void testDelete() {
	  log.info("DELETE COUNT:"+mapper.delete(3L));
  }
  @Test
  public void testUpdate() {
	  BoardVO board = new BoardVO();
	  //실행전 존재하는 번호인지 확인할것
	  board.setBno(5L);
	  board.setTitle("수정된제목");
	  board.setContent("수정된내용:");
	  board.setWriter("kh정보");
	  int count = mapper.update(board);
	  log.info("UPDATE COUNT:"+count);
  }
  @Test
  public void testSearch() {
	  Criteria cri =  new Criteria();
	  //cri.setKeyword("새로");
	  //cri.setType("TCW");
	  
	  List<BoardVO> list = mapper.getListWithPaging(cri);
	  log.info("-----------------------------");
	  list.forEach(board->log.info(board));
	  /*Map<String,String> map = new HashMap<>();
	  map.put("T", "TTT");
	  map.put("C", "CCC");
	  map.put("W", "WWW");
	  
	  Map<String, Map<String,String>> outer = new HashMap<>();
	  outer.put("map", map);
	  
	  List<BoardVO> list = mapper.searchTest(outer);
	  log.info(list);*/
	  
  }

}
