package com.my.dolduck.model.dao;

import java.util.List;

import com.my.dolduck.model.dto.FreeboardDto;

public interface FreeboardDao {

	String namespace="freeboard.";
	
	public List<FreeboardDto> free_list();
	public FreeboardDto free_detail(int freeboard_num);
	public int free_insert(FreeboardDto dto);
	public int free_update(FreeboardDto dto);
	public List<FreeboardDto> find_list(String Searchtext);
	public int free_delete(int num);
	public String free_idChk(int freeboard_num);
}
