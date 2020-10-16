package week11;

import java.util.Scanner;
import java.util.Stack;

/*
 * 문자열
 * https://www.acmicpc.net/problem/9935
 */

public class BOJ9935 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String string1 = sc.next();
		String string2 = sc.next();
		solution(string1, string2);
	}

	static public void solution(String input, String bomb) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		int len = bomb.length();

		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
			if (stack.size() >= bomb.length()) {
				check(stack, bomb, len);
			}
		}
		if (stack.empty()) {
			System.out.print("FRULA");
			return;
		} else {
			for (int i = 0; i < stack.size(); i++) {
				sb.append(stack.get(i));
			}
		}
		System.out.print(sb);
	}

	static void check(Stack<Character> stack, String bomb, int len){
	    boolean flag = true;
	    for(int i=0; i<len; i++){
	      if(stack.get(stack.size()-len+i)!=bomb.charAt(i)) {
	        flag = false;
	        break;
	      }
	    }
	    if(flag) {
	      for(int i=0; i<len; i++) stack.pop();
	    }
	  }
}