package practice;

/*
 * 소수 개수 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/12921
 */

public class Level_1_18 {
	
	public int solution(int n) {
	      int answer = 0;

	      for(int i=2; i<=n; i++) {
	    	  int count = 0;
	    	  for(int j=1; j*j<=i; j++) { // 나누는 수는 제곱근 까지만 검사
	    		  if(i%j==0) count++;
	    		  if(count>1) break;
	    	  }
	    	  if(count==1) answer++;
	      }
	      return answer;
	}

}
