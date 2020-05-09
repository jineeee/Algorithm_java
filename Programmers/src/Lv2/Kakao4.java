package Lv2;

import java.util.ArrayList;
import java.util.List;

/*
 * 카카오 캐시 - LRU 알고리즘
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */

public class Kakao4 {
	
	static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0) return 5*cities.length;
        
        List<String> list = new ArrayList<String>();
        
        for(String temp : cities) {
        	String city = temp.toLowerCase();
        	
        	if(list.contains(city)) {
        		int idx = list.indexOf(city);
        		list.remove(idx);
        		list.add(city);
        		answer += 1;
        	} else {
        		if(list.size() >= cacheSize) 
        			list.remove(0);
        		list.add(city);
        		answer += 5;
        	}
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String [] strings = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.print(solution(3, strings));
	}
}
