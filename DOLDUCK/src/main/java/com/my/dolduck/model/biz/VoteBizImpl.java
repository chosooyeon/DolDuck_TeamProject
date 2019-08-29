package com.my.dolduck.model.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dolduck.model.dao.VoteDao;
import com.my.dolduck.model.dto.VoteDto;

@Service
public class VoteBizImpl implements VoteBiz{
	@Autowired
	private VoteDao dao;
	
	@Override
	public int insertVote(VoteDto dto) {
		return dao.insertVote(dto);
	}
	@Override
	public String selectOneVote(String item, String starName) {
		return dao.selectOneVote(item, starName);
	}
	@Override
	public int updateVote(VoteDto dto) {
		return dao.updateVote(dto);
	}
	@Override
	public int selectMemberVote(String member_id) {
		return dao.selectMemberVote(member_id);
	}
	@Override
	public int updateMemberVote(String member_id, int voteNumber) {
		return dao.updateMemberVote(member_id, voteNumber);
	}
	@Override
	public int selectVoteNumber(String starName, String item) {
		return dao.selectVoteNumber(starName, item);
	}
}
