package Lv1;

import java.util.*;


public class Level_1_12 {

	static public int[] solution(int[] arr, int divisor) {
	      int count = 0;
	      int[] answer;
	      ArrayList<Integer> list = new ArrayList<Integer>();
	      Arrays.sort(arr);
	      
	      for(int i=0; i<arr.length; i++) {
	    	  if(arr[i]%divisor == 0) {
	    		  list.add(arr[i]);
	    		  count++;
	    	  }
	      }
	      
	      if(count==0) { // 나눠지는 수가 없는 경우
	    	  answer = new int[1];
	    	  answer[0] = -1;
	      } else { 
	    	  answer = new int[list.size()];
	    	  for(int i=0; i<answer.length; i++) {
	    		  answer[i] = list.get(i);
	    	  }
	      }
		return answer;
	  }
	
	public static void main(String[] args) {
		int[] a= {5, 9, 7, 10};
		solution(a, 5);
	}
}
