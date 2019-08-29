package com.my.dolduck.model.dao;

import com.my.dolduck.model.dto.VoteDto;

public interface VoteDao {
	String namespace = "vote.";
	
	public int insertVote(VoteDto votedto);
	public String selectOneVote(String item, String starName);
	public int updateVote(VoteDto dto);
	public int selectMemberVote(String member_id);
	public int updateMemberVote(String member_id, int voteNumber);
	public int selectVoteNumber(String starName, String item);
}
