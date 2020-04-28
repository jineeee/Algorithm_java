package practice;

import java.util.Arrays;

/*
 * 프로그래머스 Level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */

public class Level_1_7 {
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.parallelSort(participant);
        System.out.println(Arrays.toString(participant));
        Arrays.parallelSort(completion);
        System.out.println(Arrays.toString(completion));
        
        for(int i=0; i<completion.length; i++) {
        	if(!(participant[i].equals(completion[i]))) {
        		return participant[i];
        	}
        }
        return participant[participant.length-1];
    }
	
	public static void main(String[] args) {
		String[] p = {"mislav", "stanko", "mislav", "ana"};
		String[] c = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(p,c));
	}
}
