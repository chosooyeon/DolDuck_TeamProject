package com.my.test.model.biz;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.test.dto.MemberDto;
import com.my.test.dto.MemberJoinDto;
import com.my.test.dto.SelectDto;
import com.my.test.model.dao.MemberDao;
import com.my.test.vote.VoteDto;

@Service
public class MemberBizImpl implements MemberBiz {

	@Autowired
	private MemberDao dao;
	
	@Override
	public List<SelectDto> selectList() {
		return dao.selectList();
	}

	@Override
	public int insertUser(Map<String, String> map) {
		return dao.insertUser(map);
	}

	@Override
	public Map<String, Object> selectUser(String user_id) {
		return dao.selectUser(user_id);
	}

	@Override
	public MemberDto loginDo(String id, String pw) {
		return dao.loginDo(id, pw);
	}

	@Override
	public MemberDto loginChk(String id, String pw) {
		return dao.loginChk(id, pw);
	}

	@Override
	public int register(Map<String, String> map) {
		return dao.register(map);
	}

	@Override
	public MemberJoinDto idCheck(String id) {
		return dao.idCheck(id);
	}

	@Override
	public int updateMember(MemberDto dto) {
		return dao.updateMember(dto);
	}

	@Override
	public int updateUserPw(MemberDto dto) {
		return dao.updateUserPw(dto);
	}

	@Override
	public SelectDto idSearch(String name, String email) {
		return dao.idSearch(name, email);
	}

	@Override
	public SelectDto pwSearch(String id, String email) {
		return dao.pwSearch(id, email);
	}

	@Override
	public int changePw(String pw, String id) {
		return dao.changePw(pw, id);
	}

	@Override
	public int purchaseHeart(int amount, String id) {
	
		return dao.purchaseHeart(amount, id);
	}

	@Override
	public int purchaseVote(int amount, String id) {
		return dao.purchaseVote(amount, id);
	}

	@Override
	public int insertVote(VoteDto dto) {
		return dao.insertVote(dto);
	}

	@Override
	public VoteDto selectOneVote(int page, String starName) {
		return dao.selectOneVote(page, starName);
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
	
//	@Override
//	public MemberDto login(String id, String pw) {
//		return dao.login(id, pw);
//	}
	public int updateRole(MemberDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}


	
}
