package com.hong.junk.crawlingController;

import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("finance")
public class financeController {

		
		@RequestMapping("result")
		public String result(Model model) {
			
			
			final String stockList = "https://finance.naver.com/item/main.naver?code=005930"; //삼성전자
			
			//Jsoup 연결
			Connection conn = Jsoup.connect(stockList);
			
			try {
				
				//stockList 주소의 HTML태그를 전부 가져와라
				Document document = conn.get();
				
				//stockList에서 가져온 주소에서 class=launch-list-item을 찾는다
				Elements e1 = document.getElementsByAttributeValue("class", "userestockalarm");
				
//				model.addAttribute("e1", e1);

				log.debug("====================================={}", e1);
			} 
			
			catch (IOException e) {
				
				e.printStackTrace();
			}
			
			return "crawling/result";
		}
}
