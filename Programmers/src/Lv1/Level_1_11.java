package Lv1;
import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12906
 */

public class Level_1_11 {
	static public int[] solution(int []arr) {
        Stack <Integer> s = new Stack<Integer>();
        
        s.push(arr[0]);
        for(int i=1; i<arr.length; i++) {
        	if(s.peek()==arr[i]) {
        		continue;
        	} else {
        		s.push(arr[i]);
        	}
        }
        
        int[] answer = new int[s.size()];
        for(int i=answer.length-1; i>=0; i--) {
        	answer[i]=s.pop();
        }

        return answer;
    }
	
	public static void main(String[] args) {
		int[] a= {1,1,3,3,0,1,1};
		solution(a);	
	}
}
