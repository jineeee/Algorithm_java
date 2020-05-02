package practice;

import java.util.Arrays;

/* 
 * 예산 계산하기
 * https://programmers.co.kr/learn/courses/30/lessons/12982
 */

public class Level_1_28 {
	
	public int solution(int[] d, int budget) {
        int sum = 0;
        
        Arrays.sort(d);
        int i = 0;
        for(i=0; i<d.length; i++) {
        	sum += d[i];
        	if(sum > budget)
        		break;
        }
        return i;
    }

}
