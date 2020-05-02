package practice;

import java.util.Stack;

public class Level_2_08 {
	boolean solution(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        if(s.charAt(0) == ')') return false;
        	for(int i=0; i<s.length(); i++) {
            		if(s.charAt(i)=='(') {
            			stack.push(s.charAt(i));
            		} else 
            			if(stack.isEmpty()) return false;
            			else if (stack.pop()!='(') return false;
            }
        
        if(stack.isEmpty()) return true;
        else return false;
    }
}
