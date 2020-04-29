package practice;

/*
 * 대소문자 변환
 * https://programmers.co.kr/learn/courses/30/lessons/12930
 */

public class Level_1_21 {
	
	static public String solution(String s) {
	      String answer = "";
	      int count = 0;
	      
	      for(int i=0; i<s.length(); i++) {
	    	  if(s.charAt(i)==' ') {
	    		  answer += " ";
	    		  count = 0;
	    	  } else if (s.charAt(i) !=' ') {
	    		  if(count%2==0) {
	    			  answer += String.valueOf(s.charAt(i)).toUpperCase();
	    			  count++;
	    		  } else {
	    			  answer += String.valueOf(s.charAt(i)).toLowerCase();
	    			  count++;
	    		  }
	    	  }
	      }
	      System.out.println(answer);
	      return answer;
	  }
	
	public static void main(String[] args) {
		solution("try    hel lo world");
	}
}
