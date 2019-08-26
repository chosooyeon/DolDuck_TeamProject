package com.my.dolduck.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dolduck.model.dto.BroadcastDto;
import com.my.dolduck.model.dao.BroadcastDao;

@Service
public class BroadcastBizImpl implements BroadcastBiz {

	@Autowired
	private BroadcastDao dao;
	
	@Override
	public List<BroadcastDto> selectList() {
		return dao.selectList();
	}

	@Override
	public List<BroadcastDto> selectListHavingVideo(){
		return dao.selectListHavingVideo();
	}
	
	@Override
	public BroadcastDto selectOne(int broadcast_seq) {
		return dao.selectOne(broadcast_seq);
	}

	@Override
	public int insert(BroadcastDto dto) {
		return dao.insert(dto);
	}

	@Override
	public int update(BroadcastDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int broadcast_seq) {
		return dao.delete(broadcast_seq);
	}

	@Override
	public int saveVideo(BroadcastDto dto) {
		return dao.saveVideo(dto);
	}

}
