package com.my.test.vote;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class StarScrap {
	public List<Star> getStarChart(int page) {

		List<Star> starChart = new ArrayList<Star>();
		// String url = "https://www.melon.com/chart/index.htm";
		try {
			// boyGroup
			Document doc = Jsoup.connect("http://idolpick.donga.com/poll.php?p="+page).get();
			Elements rows = doc.select("li");

			for (int i = 1; i < rows.size(); ++i) {
				Element ele = rows.get(i);
				Star star = new Star();

//				System.out.println("========================================");
//				System.out.println(ele.select("img").attr("src"));
//				System.out.println(ele.select("img").attr("alt"));

				if (ele.select("img").attr("src") != "" && ele.select("img").attr("alt") != "") {
					star.setName(ele.select("img").attr("alt"));
					star.setImg(ele.select("img").attr("src"));

					starChart.add(star);
				}
			}

		} catch (IOException e) {
			System.err.println("JSoup 크롤링 에러");
		}
		return starChart;
	}

}
