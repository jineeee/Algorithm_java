package Lv3;

import java.util.*;

/*
 * 카카오 보석쇼핑 - 효율성 반만맞음
 * https://programmers.co.kr/learn/courses/30/lessons/67258?language=java
 */

public class Kakao2 {
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		System.out.print(Arrays.toString(solution(gems)));
	}

	static int[] solution(String[] gems) {
		int[] answer = new int[2];
        int low = 0;
        int high = 0;
        Set<String> gemCnt = new HashSet<String>();
        for(int i=0; i<gems.length; i++) {
        	gemCnt.add(gems[i]);
        }
        
        while(low<=high && high<gems.length) {
        	Set<String> cnt = new HashSet<String>();
        	for(int i=low; i<=high; i++) cnt.add(gems[i]);
        	if(cnt.size()==gemCnt.size()) {
        		if(high-low+1<min) {
        			answer[0] = low+1;
        			answer[1] = high+1;
        			min = high-low+1;
        		}
        		low++;
        		if(low>high) high=low;
        	}else high++;
        }
        return answer;
    }
}
