package practice;

import java.util.Arrays;

public class Level_1_15 {
	public String solution(String s) {
	      String answer = "";
	      
	      String[] string = s.split("");
	      Arrays.sort(string);
	      for(int i=string.length-1; i>=0; i--) {
	    	  answer += string[i];
	      }  
	      return answer;
	  }

}
