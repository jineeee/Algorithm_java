package Lv3;

import java.util.*;

public class Kakao13 {
	
	static class Page{
		String url = "";
		int baseScore=0, linkCnt=0;
		Double linkScore= 0D, matchScore=0D;
		ArrayList<Integer> links = new ArrayList<Integer>();
	}
	
	public static void main(String[] args) {
		
		String[] arr1= {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://a.com\"/>\n</head>  \n<body>\nBlind Lorem Blind ipsum dolor Blind test sit amet, consectetur adipiscing elit. \n<a href=\"https://b.com\"> Link to b </a>\n</body>\n</html>", 
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://b.com\"/>\n</head>  \n<body>\nSuspendisse potenti. Vivamus venenatis tellus non turpis bibendum, \n<a href=\"https://a.com\"> Link to a </a>\nblind sed congue urna varius. Suspendisse feugiat nisl ligula, quis malesuada felis hendrerit ut.\n<a href=\"https://c.com\"> Link to c </a>\n</body>\n</html>", 
				"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://c.com\"/>\n</head>  \n<body>\nUt condimentum urna at felis sodales rutrum. Sed dapibus cursus diam, non interdum nulla tempor nec. Phasellus rutrum enim at orci consectetu blind\n<a href=\"https://a.com\"> Link to a </a>\n</body>\n</html>"};
		String[] arr2 = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
		solution("blind", arr1);
	}

	static HashMap<String, Integer> map = new HashMap<String, Integer>();
	static Page[] pages2;
	
	static int solution(String word, String[] pages) {
        pages2 = new Page[pages.length];
        
        for(int i=0 ;i<pages2.length; i++) {
        	map.put(findUrl(pages[i]), i);
        }
        System.out.println(map);
        
        // 각 페이지의 url을 map에 저장
        for(int i=0; i<pages.length; i++) {
        	Page nowPage = new Page();
        	pages2[i] = nowPage;
//        	map.put(findUrl(pages[i]), i);
        	pages2[i].baseScore = getBaseScore(word.toLowerCase(), pages[i].toLowerCase());
        	pages2[i].linkCnt = getLinkCnt(pages[i], i);
        }
        
        for(Page page : pages2) System.out.println(page.links);
        
        for(int i=0; i<pages2.length; i++) {
        	ArrayList<Integer> link = pages2[i].links;
        	for(int j=0; j<link.size(); j++) {
        		if(map.containsKey(link.get(j)))
        		pages2[i].linkScore += Double.valueOf(pages2[map.get(link.get(j))].baseScore) / Double.valueOf(pages2[map.get(link.get(j))].linkCnt);
        	}
        	pages2[i].matchScore = pages2[i].baseScore + pages2[i].linkScore;
        }
        
        for(Page page : pages2) System.out.println(page.matchScore);
        
        int answer = 0;
        Double max = Double.MIN_VALUE;
        for(int i=0; i<pages2.length; i++) {
        	if(max<pages2[i].matchScore) {
        		max = pages2[i].matchScore;
        		answer = i;
        	}
        }
//        System.out.println(answer);
        return answer;
    }
	
	static String findUrl(String html) {
		String meta = "<meta property=\"og:url\" content=\"";
		int start = html.indexOf(meta) + meta.length();
		int end = html.indexOf("\"", start);
		
		return html.substring(start, end);
	}
	
	static int getBaseScore(String word, String html) {
		int index = html.indexOf(word);
		int baseScore=0;
		
		while (index!=-1) {
			char pre = html.charAt(index-1);
			char post = html.charAt(index+word.length());
			
			if(!Character.isLowerCase(pre) && !Character.isLowerCase(post)) 
				baseScore++;
			
			index = html.indexOf(word, index+1);
		}
		
		return baseScore;
	}
	
	static int getLinkCnt(String html, int i){
		String tag = "<a href=\"";
//		ArrayList<String> arrayList = new ArrayList<String>();
		String tempHtml = html;
		int cnt = 0;
		
		while(tempHtml.contains(tag)) {
			int start = tempHtml.indexOf(tag) + tag.length();
			int end = tempHtml.indexOf("\"", start);
			String url = tempHtml.substring(start, end);
			System.out.println(url);
			if (map.containsKey(url)) {
				pages2[map.get(url)].links.add(i);
				System.out.println(pages2[map.get(url)].links);
			}
//			arrayList.add(url);
			cnt++;
			tempHtml = tempHtml.substring(end);
		}
//		return arrayList.toArray(new String[arrayList.size()]);
		return cnt;
	}
}
