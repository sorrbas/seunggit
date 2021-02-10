package com.springbook.biz.board;

import java.util.List;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.spring.biz.board.BoardService;
import com.spring.biz.board.BoardVO;

public class BoardServiceClient {

	public static void main(String[] args) {
		
		//1.Spring으로부터 컨테이너를 구동한다.
		AbstractApplicationContext container = new GenericXmlApplicationContext("applicationContext.xml");
		
		//2.Spring 컨테이너로부터 BoardServiceImpl 객체를 찾는다.
		BoardService boardservice = (BoardService)container.getBean("boardService");
		
		//3. 글 등록 기능 테스트
		BoardVO vo = new BoardVO();
        vo.setTitle("임시제목");
        vo.setWriter("홍길동");
        vo.setContent("임시내용..........................");
        boardservice.insertBoard(vo);
        
        //4. 글 목록 검색 기능 테스트
        List<BoardVO> boardList = boardservice.getBoardList(vo);
        for(BoardVO board : boardList) {
        	System.out.println(board.toString());
        }
        
        //5.스프링 컨테이너 종료
        container.close();
	}

}
