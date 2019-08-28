package com.my.dolduck.model.biz;

import com.my.dolduck.model.dto.VoteDto;

public interface VoteBiz {
	public int insertVote(VoteDto dto);
	public String selectOneVote(String item, String starName);
	public int updateVote(VoteDto voteDto);
	public int selectMemberVote(String member_id);
	public int updateMemberVote(String member_id, int voteNumber);
	public int selectVoteNumber(String starName);
<<<<<<< HEAD
=======

>>>>>>> 260eec08e3a61ad27e0ef902b99968753b70e8c9
}
