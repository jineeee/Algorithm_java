package Lv1;

import java.util.Calendar;

/*
 * 프로그래머스 Level 1
 * https://programmers.co.kr/learn/courses/30/lessons/12901
 */

public class Level_1_09 {
	
	static public String solution(int a, int b) {
	      String answer = "";
	      
	      Calendar calendar = Calendar.getInstance();
	      calendar.set(Calendar.YEAR, 2016);
	      calendar.set(Calendar.MONTH, a-1); // 월은 0-11까지이므로 -1해서 넣어줘야함
	      calendar.set(Calendar.DAY_OF_MONTH, b);
	      
	      int yo = calendar.get(Calendar.DAY_OF_WEEK);
	      switch (yo) {
		case 1:
			answer = "SUN";
			break;
		case 2:
			answer = "MON";
			break;
		case 3:
			answer = "TUE";
			break;
		case 4:
			answer = "WED";
			break;
		case 5:
			answer = "THU";
			break;
		case 6:
			answer = "FRI";
			break;
		case 7:
			answer = "SAT";
			break;
		}
	      
	      return answer;
	  }
}
