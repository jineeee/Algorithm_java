package Lv2;

import java.util.Arrays;

/*
 * 전화번호 - 문자열에서 앞부분만 일치하는지 찾기 (접두어)
 * https://programmers.co.kr/learn/courses/30/lessons/42577
 */

public class Level_2_13 {
	
	static public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        for(int i=0; i<phone_book.length; i++) {
        	int len = phone_book[i].length();
        	for(int j=i+1; j<phone_book.length; j++) {
        		if(phone_book[i].equals(phone_book[j]))
        			return true;
        		else if(phone_book[j].length()<=len) 
        			continue;
        		if(phone_book[i].equals(phone_book[j].substring(0,len)))
        			return false;
        	}
        }
        return true;
    }

	public static void main(String[] args) {
		String[] temp = {"119", "97674223", "1195524421"};
		solution(temp);
		
	}
}
