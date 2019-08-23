package com.my.dolduck.model.biz;

import java.util.List;

import com.my.dolduck.model.dto.MarketCommentDto;

public interface MarketCommentBiz {

	public List<MarketCommentDto> market_comment_list(int market_num);
	public MarketCommentDto freeboard_comment_detail(String id);
	public int market_comment_insert(MarketCommentDto dto);
	public int market_comment_update(MarketCommentDto dto);
	public int market_comment_delete(int market_comment_num);
}
