package com.traveler.web.journal.model;

import lombok.Data;

@Data
public class JournalVO {
	private int journal_no;
	private String title;
	private String start_dt;
	private String end_dt;
	private String marker;
	private String author;
	private int thumbs;
	private int view_cnt;
}
