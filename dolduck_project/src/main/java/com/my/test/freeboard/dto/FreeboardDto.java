package com.my.test.freeboard.dto;

import java.sql.Clob;
import java.sql.Date;


public class FreeboardDto {

	
	private int freeboard_num;
	private String freeboard_id;
	private String freeboard_title;
	private String freeboard_content;
	private Date freeboard_regdate;

	public FreeboardDto() {

	}

	public FreeboardDto(String freeboard_id, String freeboard_title, String freeboard_content,int freeboard_num,Date freeboard_regdate) {
		this.freeboard_num = freeboard_num;
		this.freeboard_id = freeboard_id;
		this.freeboard_title = freeboard_title;
		this.freeboard_content = freeboard_content;
		this.freeboard_regdate = freeboard_regdate;
	}

	public String getFreeboard_id() {
		return freeboard_id;
	}

	public void setFreeboard_id(String freeboard_id) {
		this.freeboard_id = freeboard_id;
	}

	public String getFreeboard_title() {
		return freeboard_title;
	}

	public void setFreeboard_title(String freeboard_title) {
		this.freeboard_title = freeboard_title;
	}

	public String getFreeboard_content() {
		return freeboard_content;
	}

	public void setFreeboard_content(String freeboard_content) {
		this.freeboard_content = freeboard_content;
	}

	public int getFreeboard_num() {
		return freeboard_num;
	}

	public void setFreeboard_num(int freeboard_num) {
		this.freeboard_num = freeboard_num;
	}

	public Date getFreeboard_regdate() {
		return freeboard_regdate;
	}

	public void setFreeboard_regdate(Date freeboard_regdate) {
		this.freeboard_regdate = freeboard_regdate;
	}

}
