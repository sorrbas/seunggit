package com.traveler.web.diary.model;

import lombok.Data;

@Data
public class DiaryVO {
	private int diary_no;
	private String title;
	private String diary;
	private String writer;

	private String regdate;
	private String marker;
	private String imglocs;
	private int journal_no;
}
