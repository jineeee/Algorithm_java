package Lv1;

/*
 * 배열 뒤집기, long < - > string
 * https://programmers.co.kr/learn/courses/30/lessons/12932#
 */

public class Level_1_22 {
	public int[] solution(long n) {
	      String[] strings = String.valueOf(n).split("");
	      int[] answer = new int[strings.length];
	      int left = 0;
	      int right = strings.length-1;
	      
	      for(int i=0; i<strings.length/2; i++) {
	    	  String temp = strings[left];
	    	  strings[left] = strings[right];
	    	  strings[right] = temp;
	    	  
	    	  left++;
	    	  right--;
	      }
	      
	      for(int i=0; i<answer.length; i++) {
	    	  answer[i] = Integer.parseInt(strings[i]);
	      }
	      
	      return answer;
	  }

	public static void main(String[] args) {
		
	}
}
