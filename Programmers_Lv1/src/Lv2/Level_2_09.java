package Lv2;

import java.util.*;

/*
 * 프린터 - 우선수위큐
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */

public class Level_2_09 {
	
	static public int solution(int[] priorities, int location) {
        int answer = 1;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        
        for(int i:priorities) {
        	queue.offer(i);
        }
        
        while (!queue.isEmpty()) {
			for(int i=0; i<priorities.length; i++) {
				if(priorities[i] == queue.peek()) {
					if(i==location)
						return answer;
					queue.poll();
					answer++;
				}
			}
		}
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] temp = {2, 1, 3, 2};
		solution(temp, 1);
	}

}
