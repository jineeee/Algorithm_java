package Lv1;

/*
 * 시저 암호 (아스키코드)
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 */

public class Level_1_20 {
	
	static public String solution(String s, int n) {
		String answer = "";
	      for(int i=0; i<s.length(); i++) {
	    	  char ch = s.charAt(i);
	    	  if(ch == ' ') {
	    		  answer += Character.toString(ch);
	    		  continue; // 공백일경우 다음 문자 탐색
	    	  }
	    	  else if(Character.isLowerCase(ch)) { // 소문자일 경우
	    		  ch = (char) (ch+n); // n만큼 이동
	    		  if(ch>122) // z가 넘어갔을 때
	    			  ch = (char) (97+(ch-123)); // a부터 다시 시작
	    	  } else if(Character.isUpperCase(ch)) { // 대문자일 경우
	    		  ch = (char) (ch+n); // n만큼 이동
	    		  if(ch>90)  // Z를 넘어갔을 때
	    			  ch = (char) (65+(ch-91)); // A부터 다시 시작
	    	  }
	    	  answer += Character.toString(ch);
	      }
	      return answer;
	}

	public static void main(String[] args) {
		solution("AaZz", 25);
	}
}
