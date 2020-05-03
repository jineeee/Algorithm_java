package Lv2;

/*
 * 프로그래머스 Level 2
 * https://programmers.co.kr/skill_checks/123820
 * 두 수의 최소공배수(Least Common Multiple)란 입력된 두 수의 배수 중 공통이 되는 가장 작은 숫자를 의미합니다. 
 * 예를 들어 2와 7의 최소공배수는 14가 됩니다. 
 * 정의를 확장해서, n개의 수의 최소공배수는 n 개의 수들의 배수 중 공통이 되는 가장 작은 숫자가 됩니다. 
 * n개의 숫자를 담은 배열 arr이 입력되었을 때 이 수들의 최소공배수를 반환하는 함수, solution을 완성해 주세요.
 */

public class Level_2_01 {

	static public int gcd(int a, int b) { // 최대공약수를 구하는 함수
		while(b !=0 ) {
			int r = a%b; // 두 수를 나눈 나머지
			a = b;
			b = r;
		}
		return a;
	}
	
	static public int lcm(int a, int b) { // 최소공배수를 구하는 함수
		return (int)a*b/gcd(a, b); // 두 수를 곱한 값을 최대공약수로 나눈 값이 최소공배수
	}
	
	public int solution(int[] arr) {
	      int answer = 0; 
	      int temp = arr[0]; // 임시변수
	      
	      for (int i=1; i<arr.length; i++) {
	    	  temp = lcm(temp, arr[i]); // 앞에서 이미 구한 최소공배수와 값을 비교하면 최종 최소공배수가 나옴
	      }
	      
	      answer = temp;
	      return answer;
	      
	}
}
