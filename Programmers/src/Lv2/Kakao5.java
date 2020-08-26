package Lv2;

/*
 * 카카오 2020 공채 괄호변환 
 * https://programmers.co.kr/learn/courses/30/lessons/60058
 */

import java.util.*;

public class Kakao5 {
	
	public static void main(String[] args) {
		solution("()))((()");
	}
	
	public static String solution(String p) {
        
        String answer = makeCorrect(p);
        return answer;
    }
	
	public static String makeCorrect(String p) {
		if(p.isEmpty() || isCorrect(p)) return p;
		
		String u="", v="";
		int left = 0, right=0;
		
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i)=='(') left++;
			else right++;
			
			if(left==right) {
				u = p.substring(0, i+1);
				v = p.substring(i+1);
				break;
			}
		}
		
        if(isCorrect(u)) return u + makeCorrect(v);
        else {
        	String temp = "(" + makeCorrect(v) + ")";
        	u = u.substring(1, u.length()-1);
        	return temp + reverse(u);
        }
    }
	
	static String reverse(String p) {
		String temp = "";
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i)=='(') temp += ")";
			else temp += "(";
		}
		return temp;
	}
	
	static boolean isBalance(String p) {
		int left = 0, right=0;
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i)=='(') left++;
			else right++;
		}
		if (left==right) return true;
		return false;
	}
	
	static boolean isCorrect(String p) {
		Stack<Character> stack = new Stack<Character>();
		
		for(int i=0; i<p.length(); i++) {
			char c = p.charAt(i);
			
			if(c=='(') stack.push(c);
			else{
				if(stack.isEmpty()) return false;
				else stack.pop();
			}
		}
		if(stack.isEmpty()) return true;
		return false;
	}
}
