package Lv1;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12918
 */

public class Level_1_16 {
	public boolean solution(String s) {
		
	      if(s.length()==4 || s.length()==6) { // 문자열의 길이가 4또는 6이면 if문 실행
	    	 for(int i=0; i<s.length(); i++) { // 문자열의 모든 문자를 탐색
	    	  if((byte)s.charAt(i)<48 || (byte)s.charAt(i)>57) // 숫자가 아닌 값이 나온다면 
	    		  return false;
	    	 }  
	      } else { // 문자열의 길이가 4또는 6이 아니면 
	    	  return false;
	      }
	      return true;
	  }
	
	public static void main(String[] args) {
		String s="1";
		System.out.println(s.charAt(0));
	}
}
