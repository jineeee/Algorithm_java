package practice;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12919
 */

public class Level_1_17 {

	public String solution(String[] seoul) {
	      String answer = "";
	      
	      for(int i=0; i<seoul.length; i++) {
	    	  if(seoul[i]=="Kim") 
	    		  answer = "김서방은 " + (i+1) + "에 있";
	      }
	      return answer;
	  }
}
