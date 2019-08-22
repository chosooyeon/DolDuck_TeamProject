package com.my.dolduck.model.biz;

import com.my.dolduck.model.dto.VoteDto;

public interface VoteBiz {
	public int insertVote(VoteDto dto);
	public VoteDto selectOneVote(String item, String starName);
	public int updateVote(VoteDto voteDto);
	public int selectMemberVote(String member_id);
	public int updateMemberVote(String member_id, int voteNumber);
}
