package com.my.dolduck.model.dao;

import java.util.List;

import com.my.dolduck.model.dto.MarketCommentDto;

public interface MarketCommentDao {
	
	String namespace="market_comment.";
	
	public List<MarketCommentDto> market_comment_list(int market_num);
	public MarketCommentDto market_comment_detail(String id);
	public int market_comment_insert(MarketCommentDto dto);
	public int market_comment_update(MarketCommentDto dto);
	public int market_comment_delete(int market_comment_num);
}
