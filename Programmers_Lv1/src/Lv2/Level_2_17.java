package Lv2;

import java.util.*;
import java.util.regex.*;

public class Level_2_17 {
	
	static public int solution(String str1, String str2) {
	      List<String> list1 = new ArrayList<String>();
	      List<String> list2 = new ArrayList<String>();
	      
	      String temp = "";
	      String p = "^[A-Za-z]*$";
	      
	      // 두개의 배열의 문자열을 2개씩 분리하는 반복문
	      for(int i=0; i<str1.length()-1; i++) {
	    	  temp = str1.substring(i, i+2);
		      boolean b = Pattern.matches(p, temp);
		      if(b) 
		    	  	list1.add(temp.toLowerCase());
	      }
	      
	      for(int i=0; i<str2.length()-1; i++) {
	    	  temp = str2.substring(i, i+2);
		      boolean b = Pattern.matches(p, temp);
		      if(b)
		    	  	list2.add(temp.toLowerCase());
	      }
	      
	      // 두 개의 집합이 모두 공집합일 경우 1*65536을 리턴
	      if(list1.isEmpty() && list2.isEmpty()) return 65536;
	      
	      // 교집합 구하기 (중복을 허용하는 집합임을 유의)
	      List<String> tempList = new ArrayList<String>();
	      for(String s : list1) {
	    	  if(list2.contains(s)){
	    		  list2.remove(s);
	    		  tempList.add(s);
	    	  }
	      }
	      int intersection = tempList.size();
	      
	      // 합집합 구하기
	      list1.addAll(list2);
	      int union = list1.size();
	      
	      int answer = (int) (((double)intersection/union)*65536);
	      return answer;
	  }

	public static void main(String[] args) {
		solution("yyyjin", "yyjin");
	}
}
