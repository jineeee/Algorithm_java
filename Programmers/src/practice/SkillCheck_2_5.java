package practice;

import java.util.PriorityQueue;

/*
 * 프로그래머스 스킬체크 2단계
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 */


public class SkillCheck_2_5 {
	
	static public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
        
        for(int i=0; i<scoville.length; i++) {
        	queue.add(scoville[i]);
        }
        
        while (queue.peek() < K) {
			if(queue.size() == 1)
				return answer = -1;
			int food1 = queue.poll();
			int food2 = queue.poll();
			queue.add(food1+(food2*2));
			
			answer++;
		}
  
        return answer;
    }
	
	public static void main(String[] args) {
		int[] s = {1, 2, 3, 9, 10, 12};
		solution(s, 7);
	}
}
