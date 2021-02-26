package org.zerock.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;
import org.zerock.mapper.BoardMapperTests;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {
	
	@Autowired
	private BoardService service;
	
	
	
	
	@Test
	public void testPrint() {
		
		log.info(service);
		
	}
	
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board ->log.info(board));
	}
	
	@Test
	public void testRegister() {
		
		BoardVO vo = new BoardVO();
		vo.setTitle("ㅇ아아아테스트");
		vo.setContent("d아아아아컨텍트테스트");
		vo.setWriter("아아아글쓴이테스ㅡ");
		
		long bno = service.register(vo);
		
		log.info(bno);
		
		
	}
	

}
