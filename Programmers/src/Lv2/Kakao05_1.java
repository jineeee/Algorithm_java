package Lv2;

import java.util.*;

public class Kakao05_1 {
	
	public static void main(String[] args) {
		solution("()))((()");
	}
	
	static String answer = "";
	public static String solution(String p) {
        answer = makeCorrect(p);
//        System.out.print("ans" + answer);
        return answer;
    }
	
	static String makeCorrect(String p) {
		
		if(p.isEmpty() || isCorrect(p)) return p;
		
		int cnt1=0, cnt2=0;
		String u = "", v = "";
		for(int i=0; i<p.length(); i++) {
			if(p.charAt(i)=='(') cnt1++;
			else cnt2++;
			
			if(cnt1==cnt2) {
				u = p.substring(0,i+1);
				v = p.substring(i+1);
				break;
			}
		}

		if(isCorrect(u)) return u + makeCorrect(v);
		else {
			String temp = "(" + makeCorrect(v) + ")";
			return temp + reform(u);
		}
	}
	
	static String reform(String p) {
		String newP = "";
		for(int i=1; i<p.length()-1; i++) {
			if(p.charAt(i)=='(') newP += ")";
			else newP += "(";
		}
		return newP;
	}
	
	static boolean isCorrect(String string) {
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<string.length(); i++) {
			char now = string.charAt(i);
			if(now=='(') stack.push(now);
			else {
				if(stack.isEmpty()) return false;
				stack.pop();
			}
		}
		if(!stack.isEmpty()) return false;
		return true;
	}

}
