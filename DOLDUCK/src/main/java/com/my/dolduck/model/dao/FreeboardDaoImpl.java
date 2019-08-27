package com.my.dolduck.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.my.dolduck.model.dto.FreeboardDto;

@Repository
public class FreeboardDaoImpl implements FreeboardDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<FreeboardDto> free_list() {

		System.out.println("FreeboardDaoImpl : free_list");
		
		List<FreeboardDto> list = new ArrayList<FreeboardDto>();
		list = sqlSession.selectList(namespace + "selectList");

		return list;
	}

	@Override
	public FreeboardDto free_detail(int freeboard_num) {

		System.out.println("FreeboardDaoImpl : free_detail");
		
		FreeboardDto dto = sqlSession.selectOne(namespace + "selectOne", freeboard_num);

		return dto;
	}

	@Override
	public int free_insert(FreeboardDto dto) {

		System.out.println("FreeboardDaoImpl : free_insert");
		int res = 0;
		res = sqlSession.insert(namespace + "insert", dto);

		return res;
	}

	@Override
	public int free_update(FreeboardDto dto) {

		System.out.println("FreeboardDaoImpl : free_update");
		
		int res = 0;
		res = sqlSession.update(namespace + "update", dto);

		return res;
	}

	@Override
	public int free_delete(int num) {

		System.out.println("FreeboardDaoImpl : free_delete");

		int res = 0;
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("freeboard_num", num);
		res = sqlSession.delete(namespace + "delete", map);

		return res;
	}

}
