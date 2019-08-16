package com.my.test.freeboard.dao;

import java.util.List;

import com.my.test.freeboard.dto.FreeboardDto;

public interface FreeboardDao {

	String namespace="freeboard.";
	
	public List<FreeboardDto> free_list();
	public FreeboardDto free_detail(int freeboard_num);
	public int free_insert(FreeboardDto dto);
	public int free_update(FreeboardDto dto);
	public int free_delete(String id);
}
