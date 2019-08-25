package com.my.dolduck.model.dao;

import java.util.List;

import com.my.dolduck.model.dto.MarketDto;

public interface MarketDao {

	String namespace="market.";
	
	public List<MarketDto> market_list();
	public MarketDto market_detail(int market_num);
	public int market_insert(MarketDto dto);
	public int market_update(MarketDto dto);
	public int market_delete(String id);
}
