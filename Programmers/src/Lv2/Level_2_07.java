package Lv2;

import java.util.Arrays;

/*
 * 프로그래머스 Level 2
 */

public class Level_2_07 {
	
	static public String solution(String s) {
	      String answer = "";
	      int [] string = new int[s.split(" ").length];
	      
	      for(int i=0; i<string.length; i++) {
	    	  string[i] = Integer.parseInt(s.split(" ")[i]);
	      }
	      Arrays.sort(string);
	      
	      for (int i=0; i<string.length-1; i++) {
	    	  answer = answer +  string[i] + " ";
	      } answer = answer + string[string.length-1];
	      System.out.println(answer);
	      return answer;
	  }
	
	public static void main(String[] args) {
		
		solution("20 -10 -3 4");
	}
}
