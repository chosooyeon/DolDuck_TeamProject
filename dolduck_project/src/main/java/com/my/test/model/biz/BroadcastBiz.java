package com.my.test.model.biz;

import java.util.List;

import com.my.test.dto.BroadcastDto;

public interface BroadcastBiz {

	public List<BroadcastDto> selectList();
	public BroadcastDto selectOne(int broadcast_seq);
	public int insert(BroadcastDto dto);
	public int update(BroadcastDto dto);
	public int delete(int broadcast_seq);
	
	public int saveVideo(BroadcastDto dto);
}
