package Lv1;

import java.util.Arrays;

/*
 * 프로그래머스 Level 1
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 */

public class Level_1_07 {
	
	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i=0; i<completion.length; i++) {
        	if(participant[i].equals(completion[i])) {
        		continue;
        	} else {
        		answer = participant[i];
        		break;
        	}
        }
        if(answer == "") answer = participant[participant.length-1];
        return answer;
    }
	
//	public static String solution(String[] participant, String[] completion) {
//        String answer = "";
//        Arrays.parallelSort(participant);
//        Arrays.parallelSort(completion);
//        
//        for(int i=0; i<completion.length; i++) {
//        	if(!(participant[i].equals(completion[i]))) {
//        		return participant[i];
//        	}
//        }
//        return participant[participant.length-1];
//    }
	
	public static void main(String[] args) {
		String[] p = {"mislav", "stanko", "mislav", "ana"};
		String[] c = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(p,c));
	}
}
