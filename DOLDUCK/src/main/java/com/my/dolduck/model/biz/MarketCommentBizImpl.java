package com.my.dolduck.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dolduck.model.dao.MarketCommentDao;
import com.my.dolduck.model.dto.MarketCommentDto;


@Service
public class MarketCommentBizImpl implements MarketCommentBiz {

	@Autowired
	private MarketCommentDao dao;
	
	@Override
	public List<MarketCommentDto> market_comment_list(int market_num) {
		System.out.println("MarketCommentBizImpl : market_comment_list");
		return dao.market_comment_list(market_num);
	}

	@Override
	public MarketCommentDto market_comment_detail(String id) {
		return null;
	}

	@Override
	public int market_comment_insert(MarketCommentDto dto) {
		System.out.println("marketCommentBizImpl : market_comment_insert");
		return dao.market_comment_insert(dto);
	}

	@Override
	public int market_comment_update(MarketCommentDto dto) {
		System.out.println("marketCommentBizImpl : market_comment_update");
		return dao.market_comment_update(dto);
	}

	@Override
	public int market_comment_delete(int market_comment_num) {
		System.out.println("marketCommentBizImpl : market_comment_delete");
		return dao.market_comment_delete(market_comment_num);
	}

}
