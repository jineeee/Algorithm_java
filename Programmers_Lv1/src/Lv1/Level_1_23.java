package Lv1;

import java.util.*;

/*
 * 배열에서 최소값 제거 후 출력
 * https://programmers.co.kr/learn/courses/30/lessons/12935
 */

public class Level_1_23 {
	
	static public int[] solution(int[] arr) {
		if(arr.length == 1) {
			int[] answer = {-1};
			return answer;
		}
		
		int[] answer = new int[arr.length-1];
	    ArrayList<Integer> lists = new ArrayList<Integer>();
	    int[] temp = Arrays.copyOf(arr, arr.length);
	    Arrays.sort(temp);
	    int min = temp[0];
	    
	    for(int i=0; i<arr.length; i++) {
	    	if(arr[i] != min)
	    		lists.add(arr[i]);
	    }
	    
	    for(int i=0; i<answer.length; i++) {
	    	answer[i] = lists.get(i);
	    }
	    return answer;
	  }

	public static void main(String[] args) {
		int [] t = {10};
		solution(t);
	}
}
