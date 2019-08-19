package com.my.dolduck.model.dao;

import java.util.List;

import com.my.dolduck.model.dto.BroadcastDto;

public interface BroadcastDao {
	
	String namespace = "broadcast.";
	
	public List<BroadcastDto> selectList();
	public BroadcastDto selectOne(int broadcast_seq);
	public int insert(BroadcastDto dto);
	public int update(BroadcastDto dto);
	public int delete(int broadcast_seq);
	
	public int saveVideo(BroadcastDto dto);

}
