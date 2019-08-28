package com.my.dolduck.model.dao;

import java.util.List;

import com.my.dolduck.model.dto.FreeboardCommentDto;

public interface FreeboardCommentDao {
	
	String namespace="freeboard_comment.";
	
	public List<FreeboardCommentDto> freeboard_comment_list(int freeboard_num);
	public FreeboardCommentDto freeboard_comment_detail(String id);
	public int freeboard_comment_insert(FreeboardCommentDto dto);
	public int freeboard_comment_update(FreeboardCommentDto dto);
	public int freeboard_comment_delete(int Comment_num);
	
	//대댓글
	public int freeboard_co_comment_insert(FreeboardCommentDto dto);
}
