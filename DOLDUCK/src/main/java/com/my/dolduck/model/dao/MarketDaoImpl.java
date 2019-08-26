package com.my.dolduck.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.dolduck.model.dto.MarketDto;

@Repository
public class MarketDaoImpl implements MarketDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<MarketDto> market_list() {

		System.out.println("MarketDaoImpl : market_list");
		
		List<MarketDto> list = new ArrayList<MarketDto>();
		list = sqlSession.selectList(namespace + "selectList");

		return list;
	}

	@Override
	public MarketDto market_detail(int market_num) {

		System.out.println("MarketDaoImpl : market_detail");
		
		MarketDto dto = sqlSession.selectOne(namespace + "selectOne", market_num);

		return dto;
	}

	@Override
	public int market_insert(MarketDto dto) {

		System.out.println("MarketDaoImpl : market_insert");
		int res = 0;
		res = sqlSession.insert(namespace + "insert", dto);

		return res;
	}

	@Override
	public int market_update(MarketDto dto) {

		System.out.println("MarketDaoImpl : market_update");
		
		int res = 0;
		res = sqlSession.update(namespace + "update", dto);

		return res;
	}

	@Override
	public int market_delete(String id) {

		System.out.println("MarketDaoImpl : market_delete");

		int res = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("market_id", id);
		res = sqlSession.delete(namespace + "delete", map);

		return res;
	}

}
