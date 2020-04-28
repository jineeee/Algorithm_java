package practice;

/*
 * 시저 암호 (아스키코드)
 * https://programmers.co.kr/learn/courses/30/lessons/12926
 */

public class Level_1_20 {
	
	static public String solution(String s, int n) {
	      byte[] bt = s.getBytes(); // 문자열을 아스키코드로 인코딩 후 배열에 저장
	      int temp = 0;
	      for(int i=0; i<bt.length; i++) {
	    	  if(s.charAt(i) == ' ') continue; // 공백일경우 다음 문자 탐색
	    	  else if((bt[i]>=65 && bt[i]<=90) ||(bt[i]>=97 && bt[i]<=122)) { // 영문의 범위일 경우
	    		  temp = (bt[i] + n); // n만큼 이동
	    		  
	    		  if(temp>122) { // z가 넘어갔을 때
	    			  temp = 97+(temp-122)-1; // a부터 다시 시작
		    			  bt[i] = (byte)temp; // int타입을 byte타입으로 변환
		    			  System.out.println(temp);
		    			  System.out.println(bt[i]);
	    		  } else if(bt[i]<=90 && temp>90) { // 원래 대문자였던 문자가 Z를 넘어갔을 때
	    			  temp = 65+(temp-90)-1; // A부터 다시 시작
		    			  bt[i] = (byte)temp;
	    		  }else if((temp>=65 && temp<=90) ||(temp>=97 && temp<=122)) { // 이동해도 정상범위일 떄
	    			  bt[i] = (byte)temp;
	    		  }
	    	  }
	      }
	      String string = new String(bt);
	      return string;
	  }

	public static void main(String[] args) {
		solution("AaZz", 25);
	}
}
