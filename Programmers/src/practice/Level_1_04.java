package practice;

/*
 * 프로그래머스 Level 1
 * https://programmers.co.kr/learn/courses/30/lessons/12903
 */

public class Level_1_04 {
	public String solution(String s) {
	      String answer = "";
	      
	      if(s.length()%2 == 0) { // s가 짝수인 경우
	    	  int temp = s.length()/2;
	    	  answer = s.substring(temp-1, temp+1);
	      } else { // s가 홀수인 경우
	    	 int temp = s.length()/2;
	    	 answer = s.substring(temp, temp+1);
	      }
	      return answer;
	 }
}
