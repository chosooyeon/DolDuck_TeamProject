package com.my.test.util;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MusicChart {
	
	public static void main(String[] args) {
		
		List<Music> list = new ArrayList<Music>();
		
		//현재시간 받아오기
		long time = System.currentTimeMillis();
		
		SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh_mm_ss")	;
		String str = dayTime.format(new Date(time));
		
		/*------------------------------	웹크롤링	-----------------------------*/
		try {
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
		
			
			Elements rows = doc.select("tr");
			System.err.println("ROWS SIZE : " + rows.size());
			int rank = 1;
		
			for(int i=0 ; i<rows.size() ; ++i) {
			
				Element ele = rows.get(i);
				Music song = new Music();
				
				System.out.println("=================================");
				
				if(ele.select(".rank").text().length() == 0) {
					continue; 
				}	
				
				System.out.println("["+ele.select(".rank").text()+"위] "+ ele.select(".rank02 a").text() + "-" + ele.select(".rank01 a").text());
				
				song.setRank(ele.select(".rank").text());
				song.setThumb(ele.select("img").attr("src"));
				song.setTitle(ele.select(".rank01 a").text());
				song.setSinger(ele.select(".rank02 a").text());
				song.setAlbum(ele.select(".rank03 a").text());

			}
		} catch (IOException e) {
			System.err.println("JSoup 크롤링 에러");
		}
		
	}
	
	public List<Music> getMusicChart(){
		
		List<Music> chart = new ArrayList<Music>();
		//String url = "https://www.melon.com/chart/index.htm";
		try {
			
			Document doc = Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements rows = doc.select("tr");
		
			for(int i=0 ; i<rows.size() ; ++i) {
				Element ele = rows.get(i);
				Music song = new Music();
				
				if(ele.select(".rank").text().length() == 0) {
					continue; 
				}	
				
				System.out.println("["+ele.select(".rank").text()+"위] "+ ele.select(".rank02 a").text() + "-" + ele.select(".rank01 a").text());
				
				song.setRank(ele.select(".rank").text());
				song.setThumb(ele.select("img").attr("src"));
				song.setTitle(ele.select(".rank01 a").text());
				song.setSinger(ele.select(".rank02 a").text());
				song.setAlbum(ele.select(".rank03 a").text());
						
				chart.add(song);
			}
		} catch (IOException e) {
			System.err.println("JSoup 크롤링 에러");
		}
		return chart;
	}

	
}
	
	
