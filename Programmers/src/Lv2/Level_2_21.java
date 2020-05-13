package Lv2;

import java.util.Stack;

/*
 * 숫자 야구 - 조합, 배열 탐색, 완전 탐색 
 * https://programmers.co.kr/learn/courses/30/lessons/42841
 */

public class Level_2_21 {
	static int[] numbers = {1,2,3,4,5,6,7,8,9};
	static int[] result = new int[3];
	static boolean[] check = new boolean[9];
	static Stack<String> stack = new Stack<String>();
	static int answer = 0;
	
	static public int solution(int[][] baseball) {
        permutation(0);
        while (!stack.isEmpty()) {
			String numStr = stack.pop();
			check(numStr, baseball);
		}
        System.out.print(answer);
        return answer;
    }
	
	static void permutation(int current) {
		if(current == 3) {
			String temp = "";
			for(int i : result) temp += String.valueOf(i);
			stack.add(temp);
		}else {
			for(int i=0; i<numbers.length; i++) {
				if(!check[i]) {
					result[current] = numbers[i];
					check[i] = true;
					permutation(current+1);
					check[i] = false;
				}
			}
		}
	}
	
	static void check(String num, int[][] baseball) {
		int count = 0;
		String baseballStr = ""; 
		for(int i=0; i<baseball.length; i++) {
			int strike = 0;
			int ball = 0;
			baseballStr = String.valueOf(baseball[i][0]);
			for(int j=0; j<3; j++) {
				if(num.charAt(j)==baseballStr.charAt(j)) strike++;
				else if(baseballStr.contains(String.valueOf(num.charAt(j)))) ball++;
			}
			if(strike!=baseball[i][1] || ball!=baseball[i][2]) return; // 배열값과 하나라도 다르면 return
			count++;
		}
		if(count == baseball.length) answer++;
	}
	
	public static void main(String[] args) {
		int[][] temp = {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}};
		solution(temp);
	}
}
