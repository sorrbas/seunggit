package com.traveler.web;

import java.sql.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.traveler.web.journal.dao.JournalDAO;
import com.traveler.web.journal.model.JournalVO;

@RunWith(SpringJUnit4ClassRunner.class)

@ContextConfiguration(locations = {
      "classpath:spring/root-context.xml",
      "classpath:spring/dataSource-context.xml"
})

public class JournalDAOTest {
   private static final Logger logger = LoggerFactory.getLogger(JournalDAOTest.class);

   @Inject
   private JournalDAO journalDAO;

//   @Test
//   public void testGetJournalList() throws Exception {
//      List<JournalVO> journalList = journalDAO.getJournalList();
//      logger.info("\n Journal List \n ");
//      
//      if(journalList.size() > 0) {
//         for(JournalVO list : journalList) {
//            logger.info(list.getTitle());
//         }
//      } else {
//         logger.info("데이터가 없습니다.");
//      }
//   }   

   @Test @Ignore
   public void testGetJournalContent() throws Exception {
      JournalVO journalVO = journalDAO.getJournalContent(1);
      logger.info("\n Journal List \n ");

      if(journalVO != null) {
         logger.info("글번호 : " + journalVO.getJournal_no() );
         logger.info("글제목 : " + journalVO.getTitle() );
         logger.info("출발일 : " + journalVO.getStart_dt() );
         logger.info("도착일 : " + journalVO.getEnd_dt() );
         logger.info("조회수 : " + journalVO.getView_cnt() );
         logger.info("작성자 : " + journalVO.getAuthor() );
         logger.info("좋아요 : " + journalVO.getThumbs() );
         logger.info("마커정보 : " + journalVO.getMarker() );
      } else {
         logger.info("데이터가 없습니다.");
      }
   }   

   @Test @Ignore
   public void testInsertJournal() throws Exception {
      JournalVO journalVO = new JournalVO();
      journalVO.setTitle("첫번째 게시물 입니다.");
      journalVO.setStart_dt(Date.valueOf("2021-02-24").toString());
      journalVO.setEnd_dt(Date.valueOf("2021-02-28").toString());
      journalVO.setAuthor("현재 로그인중 아이디");
      journalVO.setMarker("마커 데이터");

      int result = journalDAO.insertJournal(journalVO);
      logger.info("\n Insert Journal Result " +result);
      if(result == 1) {
         logger.info("\n 게시물 등록 성공 ");
      } else {
         logger.info("\n 게시물 등록 실패");
      }
   }

   @Test @Ignore
   public void testUpdateJournal() throws Exception {
      JournalVO journalVO = new JournalVO();
      journalVO.setJournal_no(1);
      journalVO.setTitle("첫번째 게시물 입니다.-수정됨");
      journalVO.setStart_dt(Date.valueOf("2021-02-25").toString());
      journalVO.setEnd_dt(Date.valueOf("2021-03-01").toString());
      journalVO.setMarker("마커 데이터-수정됨");
      
      int result = journalDAO.updateJournal(journalVO);
      logger.info("\n Update Journal Result \n ");
      if(result > 0) {
         logger.info("\n 게시물 수정 성공 ");
      } else {
         logger.info("\n 게시물 수정 실패");
      }
   }

   @Test @Ignore
   public void testDeleteJournal() throws Exception {
      int result = journalDAO.deleteJournal(1);
      logger.info("\n Delete Journal Result \n ");
      if(result > 0) {
         logger.info("\n 게시물 삭제 성공 ");
      } else {
         logger.info("\n 게시물 삭제 실패");
      }
   }

   @Test @Ignore
   public void testUpdateViewCnt() throws Exception {
      int result = journalDAO.updateViewCnt(1);
      logger.info("\n Update View Count Result \n ");
      if(result > 0) {
         logger.info("\n 게시물 조회수 업데이트 성공 ");
      } else {
         logger.info("\n 게시물 조회수 업데이트 실패");
      }
   }
}