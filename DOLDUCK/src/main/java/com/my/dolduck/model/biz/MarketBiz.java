package com.my.dolduck.model.biz;

import java.util.List;

import com.my.dolduck.model.dto.MarketDto;

public interface MarketBiz {
	public List<MarketDto> market_list();
	public MarketDto market_detail(int market_num);
	public int market_insert(MarketDto dto);
	public int market_update(MarketDto dto);
	public int market_delete(String id);
}
