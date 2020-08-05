package Lv3;

import java.util.*;

/*
 * 카카오 보석쇼핑 - 투포인터 알고리즘 (주석은 맵이랑 큐 안써서 효율성 반만 맞는 부분)
 * https://programmers.co.kr/learn/courses/30/lessons/67258?language=java
 */

public class Kakao2 {
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		String[] gems = {"AA", "AB", "AC", "AA", "AC"};
		System.out.print(Arrays.toString(solution(gems)));
	}

	static int[] solution(String[] gems) {
		int[] answer = new int[2];
        int start = 0;
        int len = Integer.MAX_VALUE;
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> gemCnt = new HashSet<String>();
        Map<String, Integer> map = new HashMap<String, Integer>();
        
        // 보석을 하나씩 담는 set
        for(int i=0; i<gems.length; i++) gemCnt.add(gems[i]);

        for(int i=0; i<gems.length; i++) {
        	map.put(gems[i], map.getOrDefault(gems[i], 0) + 1);
        	System.out.println(map);
        	queue.add(gems[i]);
        	
        	while (true) {
				String temp = queue.peek();
				if(map.get(temp) > 1) { // 보석이 1개를 초과한다면
					map.put(temp, map.get(temp)-1); // map value 수정
					queue.poll(); // queue에서 제거
					start++;
				}else break;
			}
        	
        	// 모든 보석을 다 포함하고, 최소 길이일 때 답 갱신
        	if(map.size()==gemCnt.size() && len>queue.size()) {
        		len=queue.size();
        		answer[0] = start+1;
        		answer[1] = start+len;
         	}
        }
        
//        while(low<=high && high<gems.length) {
//        	Set<String> cnt = new HashSet<String>();
//        	for(int i=low; i<=high; i++) cnt.add(gems[i]);
//        	
//        	if(cnt.size()==gemCnt.size()) {
//        		if(high-low+1<min) {
//        			answer[0] = low+1;
//        			answer[1] = high+1;
//        			min = high-low+1;
//        		}
//        		low++;
//        		if(low>high) high=low;
//        	}else high++;
//        }
        return answer;
    }
}
