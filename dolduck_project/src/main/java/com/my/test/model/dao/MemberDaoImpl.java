package com.my.test.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.my.test.dto.MemberDto;
import com.my.test.dto.MemberJoinDto;
import com.my.test.dto.SelectDto;
import com.my.test.vote.VoteDto;

@Repository
public class MemberDaoImpl implements MemberDao {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	@Override
	public List<SelectDto> selectList() {
		
		List<SelectDto> list = new ArrayList<SelectDto>();
		try {
			list = sqlSession.selectList(namespace+"selectList");
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public int insertUser(Map<String, String> map) {
		return sqlSession.insert(namespace+"insertUser", map);
	}

	@Override
	public Map<String, Object> selectUser(String user_id) {
		return sqlSession.selectOne(namespace+"selectUser", user_id);
	}

	@Override
	public MemberDto loginDo(String id, String pw) {
		MemberDto dto = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("pw", pw);

		try {
			dto = sqlSession.selectOne(namespace + "login", map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return dto;
	}

	@Override
	public MemberDto loginChk(String id, String pw) {
		MemberDto dto = null;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", id);
		map.put("userPw", pw);
		
		dto = sqlSession.selectOne(namespace + "loginChk", map);
		
		return dto;
	}

	@Override
	public int register(Map<String, String> map) {
		int res = 0;
		res = sqlSession.insert(namespace + "memberRegister", map); 
		return res;
	}

	@Override
	public MemberJoinDto idCheck(String id) {
		MemberJoinDto dto = null;
		
		System.out.println("아이디 유효성 검사중");
		
			dto = sqlSession.selectOne(namespace + "idChk", id);
				
		return dto;
	}
	
	@Override
	public int updateMember(MemberDto dto) {
		int res = 0;
		res = sqlSession.update(namespace + "updateMember", dto);
			
			if(res>0) {
				sqlSession.commit();
			}
		
		return res;
	}

	@Override
	public int updateUserPw(MemberDto dto) {
		int res = 0;
		res = sqlSession.update(namespace + "updateUserPw", dto);
			if(res>0) {
				sqlSession.commit();
			}
		
		return res;
	}


	public SelectDto idSearch(String name, String email) {

		Map<String, String> idSearch = new HashMap<String, String>();
		idSearch.put("name", name);
		idSearch.put("email", email);
		SelectDto dto = new SelectDto();

		dto = sqlSession.selectOne(namespace + "idSearch", idSearch);
		System.err.println(dto.getMember_id());
		
		return dto;
	}
	public SelectDto pwSearch(String id, String email) {

		Map<String, Object> pwSearch = new HashMap<String, Object>();
		pwSearch.put("id", id);
		pwSearch.put("email", email);
		SelectDto dto = new SelectDto();

		dto = sqlSession.selectOne(namespace + "pwSearch", pwSearch);
		
		return dto;
	}

	@Override
	public int changePw(String pw, String id) {
		int res = 1;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("pw", pw);
		map.put("id", id);
			
		res = sqlSession.insert(namespace + "changePw", map);
		
		return res;
	}

	public Object emailChk(String email) {
		return sqlSession.selectOne(namespace + "checkEmail", email);
	}
	
	@Override
	public int usersNameCheck(String name) {
		return 0;
	}

	
	//하트 구매 
	@Override
	public int purchaseHeart(int amount, String id) {
		
		int res = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("heart", amount);
		map.put("member_id", id);
		
		res = sqlSession.update(namespace + "purchaseHeart", map);
		
		return res;
	}

	//투표권 구매
	@Override
	public int purchaseVote(int amount, String id) {
		int heart = 0;
		int res = 0;
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("vote", amount);
		map.put("member_id", id);
		
		//투표권1개(♥5)	투표권 11개(♥50)	투표권 55개(♥250) 투표권 120개(♥500)
		switch(amount){
			case 1:
				heart = 5;
				break;
			case 11: 
				heart = 50;
				break;
			case 55:
				heart = 250;
				break;
			case 120:
				heart = 500;
				break;
			default : break;
		}
		map.put("heart", heart);
		res = sqlSession.update(namespace + "purchaseVote", map);

		return res;
	}

	@Override
	public int updateRole(MemberDto dto) {
		return sqlSession.update(namespace+"updateRole",dto);
	}
	
	@Override
	public int insertVote(VoteDto votedto) {
		int res = 0;
		try {
			res = sqlSession.insert(namespace+"insertVote",votedto);
		} catch (Exception e) {
			System.out.println("error2");
			e.printStackTrace();
		}
		
		return res;
	}
	
	@Override
	public VoteDto selectOneVote(int page, String starName) {
		VoteDto dto = new VoteDto();
		dto = null;
		
		System.out.println("page:"+page+"starName:"+starName);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("page", page+"");
		map.put("starName", starName);
		
		try {
			dto = sqlSession.selectOne(namespace+"selectOneVote",new VoteDto(page,starName));
			System.out.println("dtouu:"+dto);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		return dto;
	}

	@Override
	public int updateVote(VoteDto dto) {
		int res = 0;
		try {
			res = sqlSession.update(namespace+"updateVote",dto);
		} catch (Exception e) {
			System.out.println("error");
			e.printStackTrace();
		}
		
		return res;
	}
}
