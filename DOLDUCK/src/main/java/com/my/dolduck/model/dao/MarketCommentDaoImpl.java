package com.my.dolduck.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.dolduck.model.dto.MarketCommentDto;


@Repository
public class MarketCommentDaoImpl implements MarketCommentDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MarketCommentDto> market_comment_list(int market_num) {

		System.out.println("marketCommDaoImpl : market_comment_list");

		List<MarketCommentDto> list = new ArrayList<MarketCommentDto>();
		list = sqlSession.selectList(namespace + "market_comment_list", market_num);

		return list;
	}

	@Override
	public MarketCommentDto market_comment_detail(String id) {

		return null;
	}

	@Override
	public int market_comment_insert(MarketCommentDto dto) {

		System.out.println("CommDaoImpl : comment_insert");
		System.out.println("게시글 번호 : " + dto.getMarket_num());
		
		int res = 0;
		
		res = sqlSession.insert(namespace + "market_comment_insert", dto);
		
		return res;
	}

	@Override
	public int market_comment_update(MarketCommentDto dto) {

		System.out.println("CommDaoImpl : comment_update");
		System.out.println("댓글 번호 : " + dto.getMarket_comment_num());
		System.out.println(dto.getMarket_comment_content());
		
		int res = 0;
		
		res = sqlSession.update(namespace + "market_comment_update", dto);

		return res;
	}
	
	@Override
	public int market_comment_delete(int market_comment_num) {
		
		MarketCommentDto dto = new MarketCommentDto();
		
		System.out.println("MarketCommDaoImpl : market_comment_delete");
		System.out.println("댓글 번호 : " + market_comment_num);
		
		int res = 0;
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("market_comment_num", market_comment_num);
		res = sqlSession.delete(namespace + "market_comment_delete",map);
		
		return 0;
	}
	
}
