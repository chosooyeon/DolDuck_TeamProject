package com.my.dolduck.model.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.my.dolduck.model.dao.MarketDao;
import com.my.dolduck.model.dto.MarketDto;

@Service
public class MarketBizImpl implements MarketBiz {
	@Autowired
	private MarketDao dao;
	
	@Override
	public List<MarketDto> market_list() {
		System.out.println("MarketBizImpl");
		return dao.market_list();
	}

	@Override
	public MarketDto market_detail(int market_num) {
		return dao.market_detail(market_num);
	}

	@Override
	public int market_insert(MarketDto dto) {
		return dao.market_insert(dto);
	}

	@Override
	public int market_update(MarketDto dto) {
		// TODO Auto-generated method stub
		return dao.market_update(dto);
	}

	@Override
	public int market_delete(String id) {
		// TODO Auto-generated method stub
		return dao.market_delete(id);
	}

}
