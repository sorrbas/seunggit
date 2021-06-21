package com.traveler.web.diary.model;



import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	
	
	private int diary_no;
	private int reply;
	private String content;
    private String writer;
    private Date regdate;
    
}
