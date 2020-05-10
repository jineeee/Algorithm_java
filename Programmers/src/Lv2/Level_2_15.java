package Lv2;

import java.util.*;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

public class Level_2_15 {
	static List<String> symboList  = new ArrayList<String>();
	static List<String> result = new ArrayList<String>();
	
	static public int solution(int[] numbers, int target) {
        int answer = 0;
        int len = numbers.length;
        symboList.add("+");
        symboList.add("-");
        
        permutation(symboList, result, len);
        return answer;
    }

	static void permutation(List<String> sym, List<String> result, int len) {
		if(len==0) {
			System.out.print(result);
		}
		for (int i = 0; i < len; i++) {
			result.add(sym.remove(i));
			permutation(sym, result, len - 1);
			sym.add(i, result.remove(result.size() - 1));
		}
	}
	
	public static void main(String[] args) {
		int[] num = {1, 1, 1, 1, 1};
		solution(num, 3);
	}
}
