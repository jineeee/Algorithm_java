package practice;

import java.util.*;

/*
 * 배열 완전탐색
 * https://programmers.co.kr/learn/courses/30/lessons/42840
 */

public class Level_1_26 {

	public int[] solution(int[] answers) {
        int[] s1 = {1, 2, 3, 4, 5};
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] count = new int[3];
        List<Integer> list = new ArrayList<Integer>();
        
        for (int i=0; i<answers.length; i++) {
        	if(answers[i]==s1[i%5]) count[0]++;
        	if(answers[i]==s2[i%8]) count[1]++;
        	if(answers[i]==s3[i%10]) count[2]++;
        }
        
        int grade = Math.max(count[0], Math.max(count[1], count[2]));
        
        for (int i=0; i<3; i++) {
        	if(count[i]==grade) list.add(i+1);
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++) {
        	answer[i] = list.get(i);
        }
        
        return answer;
    }

}
