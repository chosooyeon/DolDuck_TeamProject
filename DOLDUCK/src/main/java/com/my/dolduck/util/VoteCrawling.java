package com.my.dolduck.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.my.dolduck.model.dto.VoteCrawlingDto;

public class VoteCrawling {
	public List<VoteCrawlingDto> getVoteChart(int page) {
		List<VoteCrawlingDto> voteChart = new ArrayList<VoteCrawlingDto>();
		// item -> page 변환 case
//		switch(item) {
//		case "girl-group": page = 0;
//		case "girl-idol": page = 1;
//		case "new-idol": page = 2;
//		case "star-star": page = 3;
//		case "boy-group": page = 4;
//		case "boy-idol": page = 5;
//		}
		
		try {
			Document doc = Jsoup.connect("http://idolpick.donga.com/poll.php?p="+page).get();
			Elements rows = doc.select("li");

			for (int i = 1; i < rows.size(); ++i) {
				Element ele = rows.get(i);
				VoteCrawlingDto voteCrawlingDto = new VoteCrawlingDto();

				if (ele.select("img").attr("src") != "" && ele.select("img").attr("alt") != "") {
					voteCrawlingDto.setName(ele.select("img").attr("alt"));
					voteCrawlingDto.setImg(ele.select("img").attr("src"));

					voteChart.add(voteCrawlingDto);
				}
			}
		} catch (IOException e) {
			System.err.println("JSoup 크롤링 에러 (VoteCrawling.java)");
		}
		return voteChart;
	}
}
