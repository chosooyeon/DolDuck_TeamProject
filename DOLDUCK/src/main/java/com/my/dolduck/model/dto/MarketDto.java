package com.my.dolduck.model.dto;

import java.sql.Clob;
import java.sql.Date;


public class MarketDto {

	
	private int market_num;
	private String market_id;
	private String market_title;
	private String market_content;
	private Date market_regdate;
	
	public MarketDto() {
		super();
	}
	public MarketDto(int market_num, String market_id, String market_title, String market_content,
			Date market_regdate) {
		super();
		this.market_num = market_num;
		this.market_id = market_id;
		this.market_title = market_title;
		this.market_content = market_content;
		this.market_regdate = market_regdate;
	}
	public int getMarket_num() {
		return market_num;
	}
	public void setMarket_num(int market_num) {
		this.market_num = market_num;
	}
	public String getMarket_id() {
		return market_id;
	}
	public void setMarket_id(String market_id) {
		this.market_id = market_id;
	}
	public String getMarket_title() {
		return market_title;
	}
	public void setMarket_title(String market_title) {
		this.market_title = market_title;
	}
	public String getMarket_content() {
		return market_content;
	}
	public void setMarket_content(String market_content) {
		this.market_content = market_content;
	}
	public Date getMarket_regdate() {
		return market_regdate;
	}
	public void setMarket_regdate(Date market_regdate) {
		this.market_regdate = market_regdate;
	}

	
}
