package com.my.test.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WebScrap{
	public List<Music> getMusicChart(){
		
		List<Music> chart = new ArrayList<Music>();
		//String url = "https://www.melon.com/chart/index.htm";
		try {
			
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements rows = doc.select("tr");
		
			for(int i=1 ; i<rows.size() ; ++i) {
				Element ele = rows.get(i);
				Music song = new Music();
				
				if(ele.select(".rank").text().length() == 0) {
					continue; 
				}	
				//System.out.println("["+ele.select(".rank").text()+"위] "+ ele.select(".rank02 a").text() + "-" + ele.select(".rank01 a").text());
				song.setRank(ele.select(".rank").text());
				song.setThumb(ele.select("img").attr("src"));
				song.setTitle(ele.select(".rank01 a").text());
				song.setSinger(ele.select(".rank02 .checkEllipsis a").text());
				song.setAlbum(ele.select(".rank03 a").text());
						
				chart.add(song);
			}
			
		} catch (IOException e) {
			System.err.println("JSoup 크롤링 에러");
		}
		return chart;
	}

}
	
	
