package Lv2;

/*
 * JadenCase 문자열 만들기
 * https://programmers.co.kr/learn/courses/30/lessons/12951
 */

public class Level_2_33 {
	
	public static String solution(String s) {
        String answer = "";
        
        String[] arr = s.split(" ");
        for(int i=0; i<arr.length; i++) {
        	char[] characters = arr[i].toCharArray();
        	String tempString = "";
        	for(int j=0; j<characters.length; j++) {
        		if(j==0){
        			if(characters[j]>'0' && characters[j]<'9') tempString += characters[j];
        			else tempString += String.valueOf(characters[j]).toUpperCase();
        		}else tempString += String.valueOf(characters[j]).toLowerCase();
        	}
        	if (i==arr.length-1) answer += tempString;
        	else answer += tempString + " ";
        }
        
        if(s.endsWith(" ")) answer += " ";
        return answer;
    }

	public static void main(String[] args) {
		solution("3people unFollowed me");
	}
}
