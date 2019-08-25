package com.my.dolduck.model.dto;

import java.sql.Date;

public class MarketCommentDto {

	private int market_num;
	private int market_comment_num;
	private String market_comment_content;
	private Date market_comment_regdate;
	private String market_id;
	
	public MarketCommentDto() {
		super();
	}
	public MarketCommentDto(int market_num, int market_comment_num, String market_comment_content,
			Date market_comment_regdate, String market_id) {
		super();
		this.market_num = market_num;
		this.market_comment_num = market_comment_num;
		this.market_comment_content = market_comment_content;
		this.market_comment_regdate = market_comment_regdate;
		this.market_id = market_id;
	}
	public int getMarket_num() {
		return market_num;
	}
	public void setMarket_num(int market_num) {
		this.market_num = market_num;
	}
	public int getMarket_comment_num() {
		return market_comment_num;
	}
	public void setMarket_comment_num(int market_comment_num) {
		this.market_comment_num = market_comment_num;
	}
	public String getMarket_comment_content() {
		return market_comment_content;
	}
	public void setMarket_comment_content(String market_comment_content) {
		this.market_comment_content = market_comment_content;
	}
	public Date getMarket_comment_regdate() {
		return market_comment_regdate;
	}
	public void setMarket_comment_regdate(Date market_comment_regdate) {
		this.market_comment_regdate = market_comment_regdate;
	}
	public String getMarket_id() {
		return market_id;
	}
	public void setMarket_id(String market_id) {
		this.market_id = market_id;
	}
	
}
