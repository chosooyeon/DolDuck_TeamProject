package com.my.dolduck.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dolduck.model.dao.FreeboardDao;
import com.my.dolduck.model.dto.FreeboardDto;

@Service
public class FreeboardBizImpl implements FreeboardBiz {
	@Autowired
	private FreeboardDao dao;
	
	@Override
	public List<FreeboardDto> free_list() {
		System.out.println("FreeboardBizImpl");
		return dao.free_list();
	}

	@Override
	public FreeboardDto free_detail(int freeboard_num) {
		// TODO Auto-generated method stub
		return dao.free_detail(freeboard_num);
	}

	@Override
	public int free_insert(FreeboardDto dto) {
		// TODO Auto-generated method stub
		return dao.free_insert(dto);
	}

	@Override
	public int free_update(FreeboardDto dto) {
		// TODO Auto-generated method stub
		return dao.free_update(dto);
	}

	@Override
	public int free_delete(int num) {
		// TODO Auto-generated method stub
		return dao.free_delete(num);
	}

}
