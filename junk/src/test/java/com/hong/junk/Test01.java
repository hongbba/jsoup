package com.hong.junk;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test01 {
	
	final String stockList = "https://www.nike.com/kr/launch/?type=feed";
	
	@Test
	public void test() {
		//Jsoup 연결
		Connection conn = Jsoup.connect(stockList);
		
		try {
			
			//stockList 주소의 HTML태그를 전부 가져와라
			Document document = conn.get();
			
			//stockList에서 가져온 주소에서 class=launch-list-item을 찾는다
			Elements e1 = document.getElementsByAttributeValue("class", "headline-5");
			Elements e2 = document.getElementsByAttributeValue("class", "headline-3");
//			Elements e3 = document.getElementsByAttributeValue("class", "ncss-btn-primary-dark");
	//		Elements coming = document.getElementsByAttributeValue("data-iscomingsoon", false);
			
			log.debug("e1", e1);
			log.debug("e2", e2);
//			log.debug("e3", e3);
	//		model.addAttribute("coming", coming);
		} 
		
		catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
