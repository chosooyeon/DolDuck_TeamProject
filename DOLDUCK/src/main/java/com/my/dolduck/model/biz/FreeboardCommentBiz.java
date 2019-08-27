package com.my.dolduck.model.biz;

import java.util.List;

import com.my.dolduck.model.dto.FreeboardCommentDto;
import com.my.dolduck.model.dto.FreeboardDto;

public interface FreeboardCommentBiz {

	public List<FreeboardCommentDto> freeboard_comment_list(int freeboard_num);
	public FreeboardCommentDto freeboard_comment_detail(String id);
	public int freeboard_comment_insert(FreeboardCommentDto dto);
	public int freeboard_comment_update(FreeboardCommentDto dto);
	public int freeboard_comment_delete(int Comment_num);
	
	//대댓글
	public int freeboard_co_comment_insert(FreeboardCommentDto dto);
	
}
