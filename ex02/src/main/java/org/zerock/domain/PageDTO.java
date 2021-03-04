package org.zerock.domain;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class PageDTO {
   private int startPage;
   private int endPage;
   private boolean prev,next;
   
   private int total;//게시글의전체글수
   private Criteria cri;
   
   public PageDTO(Criteria cri, int total) {
	   this.cri = cri;
	   this.total = total;
	   
	   this.endPage = (int)(Math.ceil(cri.getPageNum()/10.0))*10;
	   
	   this.startPage = this.endPage-9;
	   

	     // 70건이 있을 시    71.0 / 10 => 7.1 => 8페이지가 된다
		                    // 300건이 있을 시   300.0 / 10 => 30 => 30페이지가 된다.
	   int realEnd = (int) (Math.ceil((total*1.0)/cri.getAmount()));
	   
	   if(realEnd < this.endPage) {
		   this.endPage = realEnd;
	   }
	   this.prev = this.startPage > 1;
	   this.next = this.endPage < realEnd;
   }
}