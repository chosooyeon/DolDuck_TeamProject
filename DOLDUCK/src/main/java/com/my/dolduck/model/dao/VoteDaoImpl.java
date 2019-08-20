package com.my.dolduck.model.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.dolduck.model.dto.MemberVoteDto;
import com.my.dolduck.model.dto.VoteDto;

@Repository
public class VoteDaoImpl implements VoteDao{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	VoteDto dto = new VoteDto();

	// 투표게시판 db 저장
	@Override
	public int insertVote(VoteDto votedto) {
		int res = 0;
		try {
			res = sqlSession.insert(namespace + "insertVote", votedto);
		} catch (Exception e) {
			System.out.println("error2");
			e.printStackTrace();
		}

		return res;
	}

	@Override
	public VoteDto selectOneVote(String item, String starName) {
		Map<String, String> map = new HashMap<String, String>();
//		map.put("item", item + "");
//		map.put("starName", starName);
		dto.setItem(item);
		dto.setStarName(starName);

		try {
			dto = sqlSession.selectOne(namespace + "selectOneVote", dto);
		} catch (Exception e) {
			System.out.println("selectOneVote error");
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public int updateVote(VoteDto dto) {
		int res = 0;
		try {
			res = sqlSession.update(namespace + "updateVote", dto);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}

		return res;
	}

	// member 에서 투표권수 select
	@Override
	public int selectMemberVote(String member_id) {
		int res = 0;
		try {
			res = sqlSession.selectOne(namespace + "selectMemberVote", member_id);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return res;
	}

	// member 에서 투표권수 빼기
	@Override
	public int updateMemberVote(String member_id, int voteNumber) {
		int res = 0;

		MemberVoteDto memberVoteDto = new MemberVoteDto();
		memberVoteDto.setMember_id(member_id);
		memberVoteDto.setVoteNumber(voteNumber);

		try {
			res = sqlSession.update(namespace + "updateMemberVote", memberVoteDto);
			System.out.println("updateMemberVote:" + memberVoteDto);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		return res;
	}
}
