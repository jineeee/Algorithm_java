package Lv2;

import java.util.Arrays;

/*
 * 구명보트
 * https://programmers.co.kr/learn/courses/30/lessons/42885
 */

public class Level_2_30 {
	
	public static int solution(int[] people, int limit) {
        int answer = 0;
        int idx = 0;
        Arrays.sort(people);
        
        for(int i=people.length-1; i>=idx; i--) {
        	if(people[i]+people[idx] > limit) answer++;
        	else {
				answer++;
				idx++;
			}
        }
        System.out.print(answer);
        return answer;
    }

	public static void main(String[] args) {
		int[] arr = {70, 50, 80, 50};
		solution(arr, 100);
	}
}
