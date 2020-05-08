package Lv1;


/*
 * 프로그래머스 Level 1
 * 1부터 입력받은 숫자 n 사이에 있는 소수의 개수를 반환하는 함수, solution을 만들어 보세요.
 * 소수는 1과 자기 자신으로만 나누어지는 수를 의미합니다.(1은 소수가 아닙니다.)
 */

public class Level_1_02 {
	
	static public int solution(int n) {
	      int answer = 0;
	      
	      for(int i=2; i<=n; i++) {
	    	  int count = 0;
	    	  for(int j=1; j<=i; j++) {
	    		  if(i%j==0) // 나머지가 0인 경우 
	    			  count++;
	    		  if(count>2) break; // 2개 이상의 수로 나눠질경우 다음 수 탐색
	    	  }
	    	  if(count == 2) answer++; // 약수가 2개(1과 자기자신)일 경우 +1
	      }
	      return answer;
	}
	
	public static void main(String[] args) {
		solution(10);
	}

}
