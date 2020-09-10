package Lv3;

import java.util.*;
import java.util.regex.*;

/*
 * 카카오 매칭점수 - 문자열 다루기
 * https://programmers.co.kr/learn/courses/30/lessons/42893
 */

public class Kakao13 {
	
	public static void main(String[] args) {
		
		String[] arr1= {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", 
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", 
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		String[] arr2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		solution("blind", arr1);
	}
	
	static class Page{
		String url, html;
		int idx, baseScore=0, linkCnt=0;
		Double linkScore= 0D, matchScore=0D;
		ArrayList<String> exLinks = new ArrayList<String>(), inLinks = new ArrayList<String>();
		
		public Page(String html, String url, int baseScore, int idx) {
			this.html = html;
			this.url = url;
			this.baseScore = baseScore;
			this.idx = idx;
		}
		
		// 해당 웹에 걸린 외부 링크와 해당 웹으로 들어오는 링크를 세팅
		public void setLinks() {
			String url = "";
			Matcher matcher = EXTERNAL_URL.matcher(this.html);
			while (matcher.find()) {
				url = matcher.group(1);
				this.exLinks.add(url);
				if(map.containsKey(url)) {
					map.get(url).inLinks.add(this.url);
				}
			}
		}
		
		// 매칭점수를 계산
		public void setMatchScore() {
			Double totalScore = Double.valueOf(this.baseScore);
			for(String string : inLinks) {
				if(map.containsKey(string)) {
					totalScore += Double.valueOf(map.get(string).baseScore) / map.get(string).exLinks.size();
				}
			}
			this.matchScore = totalScore;
		}
	}

    static Pattern CURRENT_URL  = Pattern.compile("<meta property=\"og:url\" content=\"https://(.+?)\"/>");
    static Pattern EXTERNAL_URL = Pattern.compile("<a href=\"https://(.+?)\">");
	static HashMap<String, Page> map = new HashMap<String, Page>();
	
	static int solution(String word, String[] pages) {
        // 페이지와 페이지 배열 생성
        for(int i=0; i<pages.length; i++) {
        	String url = findUrl(pages[i]);
        	int baseScore = getBaseScore(word.toLowerCase(), pages[i].toLowerCase());
        	Page page = new Page(pages[i].toLowerCase(), url, baseScore, i);
        	map.put(url, page);
        }
        
        for(Page page : map.values()) page.setLinks();
        
        int answer=0;
        Double maxScore = Double.MIN_VALUE;
        for(Page page : map.values()) {
        	page.setMatchScore();
        	if(page.matchScore > maxScore) {
        		maxScore = page.matchScore;
        		answer = page.idx;
        	}
        }
        return answer;
    }
	
	// 웹페이지의 url을 찾는 함수
	static String findUrl(String html) {
		String url = "";
		Matcher matcher = CURRENT_URL.matcher(html);
		while (matcher.find()) {
			url =  matcher.group(1);
		}
		return url;
	}
	
	// 기본 점수 계산하는 함수
	static int getBaseScore(String word, String html) {
		int index = html.indexOf(word);
		int baseScore=0;
		
		while (index!=-1) {
			char pre = html.charAt(index-1);
			char post = html.charAt(index+word.length());
			
			if((pre < 'a' || pre > 'z') && (post < 'a' || post > 'z')) 
				baseScore++;
			
			index = html.indexOf(word, index+1);
		}
		return baseScore;
	}
}
