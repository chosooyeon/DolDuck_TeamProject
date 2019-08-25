package com.my.dolduck.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.my.dolduck.model.dto.BroadcastDto;

@Repository
public class BroadcastDaoImpl implements BroadcastDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BroadcastDto> selectList() {
		
		List<BroadcastDto> list = new ArrayList<BroadcastDto>();
		list = sqlSession.selectList(namespace+"selectList_broadcast");
		
		return list;
	}

	@Override
	public BroadcastDto selectOne(int broadcast_seq) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", broadcast_seq);
		BroadcastDto dto = new BroadcastDto();
		dto = sqlSession.selectOne(namespace+"selectOne_broadcast", map);
		return dto;
	}

	@Override
	public int insert(BroadcastDto dto) {
		return sqlSession.insert(namespace+"insert_broadcast", dto);
	}

	//일정변경
	@Override
	public int update(BroadcastDto dto) {
		return sqlSession.update(namespace+"update_broadcast_event", dto);
	}

	@Override
	public int delete(int broadcast_seq) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("seq", broadcast_seq);
		return sqlSession.delete(namespace + "delete_broadcast_event", map);
	}

	@Override
	public int saveVideo(BroadcastDto dto) {
		return sqlSession.update(namespace+"update_broadcast_saveVideo", dto);
	}

}
