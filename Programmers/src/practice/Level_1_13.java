package practice;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12912
 */

public class Level_1_13 {
	static public long solution(int a, int b) {
	      long answer = 0;

	      int min = Math.min(a, b);
	      int max = Math.max(a, b);
	      System.out.print(min + "+" + max);
	      
	      if(min==max) {
	    	  return a;
	      } else {
	    	  for(int i=min; i<=max; i++) {
	    		  answer +=i;
	    	  }
	      }
	      return answer;
	  }
	
	public static void main(String[] args) {
		System.out.println(solution(5,3));
	}
}
