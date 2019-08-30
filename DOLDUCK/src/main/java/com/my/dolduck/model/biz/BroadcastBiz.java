package com.my.dolduck.model.biz;

import java.util.List;

import com.my.dolduck.model.dto.BroadcastDto;

public interface BroadcastBiz {

	public List<BroadcastDto> selectList();
	public List<BroadcastDto> selectListHavingVideo();
	public BroadcastDto selectOne(int broadcast_seq);
	public BroadcastDto selectOneByRoom(String room_number);
	public int insert(BroadcastDto dto);
	public int insertOnair(BroadcastDto dto);
	public int update(BroadcastDto dto);
	public int delete(int broadcast_seq);
	
	public int saveVideo(BroadcastDto dto);
}
