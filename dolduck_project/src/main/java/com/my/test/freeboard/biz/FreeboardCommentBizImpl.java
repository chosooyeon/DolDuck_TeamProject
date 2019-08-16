package com.my.test.freeboard.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.test.freeboard.dao.FreeboardCommentDao;
import com.my.test.freeboard.dto.FreeboardCommentDto;


@Service
public class FreeboardCommentBizImpl implements FreeboardCommentBiz {

	@Autowired
	private FreeboardCommentDao dao;
	
	@Override
	public List<FreeboardCommentDto> freeboard_comment_list(int freeboard_num) {
		System.out.println("CommentBizImpl : comment_list");
		return dao.freeboard_comment_list(freeboard_num);
	}

	@Override
	public FreeboardCommentDto freeboard_comment_detail(String id) {
		
		return null;
	}

	@Override
	public int freeboard_comment_insert(FreeboardCommentDto dto) {
		System.out.println("CommentBizImpl : comment_insert");
		return dao.freeboard_comment_insert(dto);
	}

	@Override
	public int freeboard_comment_update(FreeboardCommentDto dto) {
		System.out.println("CommentBizImpl : comment_update");
		return dao.freeboard_comment_update(dto);
	}

	@Override
	public int freeboard_comment_delete(int Comment_num) {
		System.out.println("CommentBizImpl : comment_delete");
		return dao.freeboard_comment_delete(Comment_num);
	}

}
