package Lv2;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/42588
 * 입력 : [6,9,5,7,4]	
 * 출력 : [0,0,2,2,4]
 */
public class Level_2_11 {

	public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        
        for(int i=heights.length-1; i>=0; i--) {
        	for(int j=i-1; j>=0; j--) {
        		if(heights[j]>heights[i]) {
        			answer[i] = j+1;
        			break;
        		}
        	}
        }
        return answer;
    }
	
}
