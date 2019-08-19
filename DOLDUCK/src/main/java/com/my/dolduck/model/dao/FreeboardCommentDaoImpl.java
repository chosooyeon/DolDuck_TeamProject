package com.my.dolduck.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.dolduck.model.dto.FreeboardCommentDto;

@Repository
public class FreeboardCommentDaoImpl implements FreeboardCommentDao {

	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<FreeboardCommentDto> freeboard_comment_list(int freeboard_num) {

		System.out.println("CommDaoImpl : comment_list");

		List<FreeboardCommentDto> list = new ArrayList<FreeboardCommentDto>();
		list = sqlSession.selectList(namespace + "freeboard_comment_list", freeboard_num);

		return list;
	}

	@Override
	public FreeboardCommentDto freeboard_comment_detail(String id) {

		return null;
	}

	@Override
	public int freeboard_comment_insert(FreeboardCommentDto dto) {

		System.out.println("CommDaoImpl : comment_insert");
		System.out.println("게시글 번호 : " + dto.getFreeboard_num());
		
		int res = 0;
		
		res = sqlSession.insert(namespace + "freeboard_comment_insert", dto);
		
		return res;
	}

	@Override
	public int freeboard_comment_update(FreeboardCommentDto dto) {

		System.out.println("CommDaoImpl : comment_update");
		System.out.println("댓글 번호 : " + dto.getFreeboard_comment_num());
		System.out.println(dto.getFreeboard_comment_content());
		
		int res = 0;
		
		res = sqlSession.update(namespace + "freeboard_comment_update", dto);

		return res;
	}
	
	@Override
	public int freeboard_comment_delete(int Comment_num) {
		
		FreeboardCommentDto dto = new FreeboardCommentDto();
		
		System.out.println("CommDaoImpl : comment_delete");
		System.out.println("댓글 번호 : " + Comment_num);
		
		int res = 0;
		
		Map<String,Integer> map = new HashMap<String, Integer>();
		map.put("freeboard_comment_num", Comment_num);
		res = sqlSession.delete(namespace + "freeboard_comment_delete",map);
		
		return 0;
	}
	
}
