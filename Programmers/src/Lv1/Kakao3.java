package Lv1;

/*
 * 카카오 - 다트게임
 * https://programmers.co.kr/learn/courses/30/lessons/17682
 */

public class Kakao3 {
	
	static public int solution(String dartResult) {
		char[] dart = dartResult.toCharArray();
		String tempNum = "";
		int[] score = new int[3]; // 기회는 세번이기 때문에 사이즈가 3인 배열로 만듬
		int scoreIdx = 0;
	      int answer = 0;
	      
	      for(int i=0; i<dart.length; i++) {
	    	  if(Character.isDigit(dart[i])) { // 숫자일 때 
	    		  tempNum += dart[i]; // 점수가 10일 경우 1과 0을 합쳐 하나의 문자로 만들어줘야함
	    	  } 
	    	  else if(Character.isUpperCase(dart[i])) { // 대문자일 때
	    		  int num = Integer.parseInt(tempNum);
	    		  tempNum = ""; // 다음 점수를 구할 때 써야하므로 초기화
	    		  switch(dart[i]) {
	    		  	case 'S':
	    		  		score[scoreIdx] = num;
	    		  		break;
	    		  	case 'D':
	    		  		score[scoreIdx] = (int) Math.pow(num, 2);
	    		  		break;
	    		  	case 'T':
	    		  		score[scoreIdx] = (int) Math.pow(num, 3);
	    		  		break;
	    		  }
	    		  scoreIdx++;
	    	  } 
	    	  else { // * 또는 #일 때
	    		  switch(dart[i]) {
	    		  	case '*':
	    		  		if(scoreIdx==1) {
	    		  			score[scoreIdx-1] = score[scoreIdx-1]*2;
	    		  			break;
	    		  		}else {
	    		  			score[scoreIdx-1] = score[scoreIdx-1]*2;
	    		  			score[scoreIdx-2] = score[scoreIdx-2]*2;
	    		  			break;
	    		  		}
	    		  	case '#':
	    		  		score[scoreIdx-1] = score[scoreIdx-1]*-1;
	    		  		break;
	    		  }
	    	  }
	      }
	      
	      for(int i=0; i<3; i++) {
	    	  answer += score[i];
	      }
	      
	      return answer;
	  }
	
	public static void main(String[] args) {
		solution("1S2D*3T");
	}

}
