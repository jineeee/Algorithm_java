package Lv3;

import java.util.*;

/*
 * 카카오 보석쇼핑 - 투포인터 알고리즘
 * https://programmers.co.kr/learn/courses/30/lessons/67258
 */

public class Kakao12 {
	
	public static void main(String[] args) {
		String[] arr = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		solution(arr);
	}

	static int[] solution(String[] gems) {
		int[] answer = new int[2];
		
		HashSet<String> set = new HashSet<String>();
		Map<String, Integer> map = new HashMap<String, Integer>();
		Queue<String> queue = new LinkedList<String>();
		
		for(String string : gems) set.add(string);

		int left = 0, len = Integer.MAX_VALUE;
		
		for(int i=0; i<gems.length; i++) {
			map.put(gems[i], map.getOrDefault(gems[i], 0)+1);
			queue.add(gems[i]); // 큐는 현재 영역의 보석을 담고있음
			
			while (true) {
				String temp = queue.peek(); // 맨 처음에 들어간 보석
				if(map.get(temp)>1) { // 해당 보석이 2개 이상 있다면 left를 이동시켜서 제외해줌
					map.put(temp, map.get(temp)-1);
					queue.poll();
					left++;
				}else break; // 해당 보석이 1개만 있다면 다음 보석을 추가해야함
			}
			
			if(map.size()==set.size() && queue.size()<len) { // map이 모든 보석을 포함하고, 최소길이일 때 정답 갱신
				len = queue.size();
				answer[0] = left+1;
				answer[0] = left+len;
			}
		}
		
		System.out.println(answer[0] + " " + answer[1]);
		return answer;
	}
}
