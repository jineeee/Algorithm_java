package practice;

import java.util.Arrays;

/*
 * 프로그래머스 Level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 */

public class Level_1_10 {
	static public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for(int i=0; i<commands.length; i++) {
				int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
				Arrays.sort(temp);
				answer[i] = temp[commands[i][2]-1];
        	
        }
        
        return answer;
    }
	
	
	public static void main(String[] args) {
		int[] a= {1, 5, 2, 6, 3, 7, 4};
		int[][] c= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		solution(a,c);
	}

}
