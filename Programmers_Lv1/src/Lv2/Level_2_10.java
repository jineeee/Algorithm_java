package Lv2;

import java.util.*;

/*
 * 기능개발 = ArrayList 사용하기
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 */
public class Level_2_10 {
	
	static public int[] solution(int[] progresses, int[] speeds) {
		List<Integer> a = new ArrayList<Integer>();
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> s = new ArrayList<Integer>();
		List<Integer> temp = new ArrayList<Integer>();
		// list에 배열 값을 넣어줌
		for(int i: progresses)
			p.add(i);
		for(int i: speeds)
			s.add(i);
		
		while (p.size() != 0) { 
			int count = 0; // 배포 개수를 카운트할 변수 
			
			// 하루가 지난 상황, 진도율을 한번씩 더해줌
			for(int i=0; i<p.size(); i++) {
				p.set(i, p.get(i) + s.get(i));
			}
			
			while (p.size() != 0) { // remove 진행 후 다시 반복해주기 위해 while문 사용
				if(p.get(0) >= 100) { // 리스트의 첫번째 값이 100 이상일 경우 
					p.remove(0);
					s.remove(0);
					count++;
				} else {
					break;
				}	
			}
			
			if(count!=0) a.add(count);
		}
		
		int[] answer = new int[a.size()];
		for(int i=0; i<a.size(); i++) {
			answer[i] = a.get(i);
		}
		System.out.println(Arrays.toString(answer));
		return answer;
	}
	

	public static void main(String[] args) {
		int[] p = {93,30,55};
		int[] q = {1,30,5};
		solution(p,q);
		 
	}
}
