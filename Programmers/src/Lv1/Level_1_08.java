package Lv1;

import java.util.Arrays;

/*
 * 프로그래머스 Level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42584#
 */

public class Level_1_08 {
	
	static public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        for(int i=0; i<prices.length; i++) {
        	for(int j=i+1; j<prices.length; j++) {
        		if(prices[i]<=prices[j])
        			answer[i]++;
        		else if(prices[i]>prices[j]) {
        			answer[i]++;
        			break;
        		}
        	}
        }
        
        System.out.println(Arrays.toString(answer));
        
        return answer;
    }

	public static void main(String[] args) {
		int[] p= {1, 2, 3, 2, 3};
		solution(p);
	}
}
