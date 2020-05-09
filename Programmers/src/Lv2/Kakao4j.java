package Lv2;

import java.util.*;

/*
 * 카카오 - 캐시
 * https://programmers.co.kr/learn/courses/30/lessons/17680
 */

public class Kakao4j {
	
	static public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0) return 5*cities.length;
        
        ArrayList<String> list = new ArrayList<>();

        for(String city : cities) {
            String temp = city.toLowerCase();

            if(list.contains(temp)) { //hit
                answer += 1;

                int idx = list.indexOf(temp);
                list.remove(idx);
                list.add(temp);
            } else { //miss
                answer += 5;
                   if(list.size() >= cacheSize)
                       list.remove(0);
                   list.add(temp);                    
               
            }
        }
        return answer;
    }
	
	public static void main(String[] args) {
		String [] strings = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
		System.out.print(solution(3, strings));
	}
}
