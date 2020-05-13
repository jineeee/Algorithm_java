package Lv2;

import java.util.*;

/*
 * 소수 찾기 - 길이가 달라지는 순열
 * 
 */
public class Level_2_20 {
	static String[] num;
	static Set<Integer> set = new HashSet<Integer>();
	static int answer = 0;
	
	static public int solution(String numbers) {
        num = numbers.split("");
        for(int i=1; i<=num.length; i++) {
        	boolean[] visited = new boolean[numbers.length()];
        	String[] result = new String[i];
        	permutation(i, 0, result, visited);    
        }
        checkNum(set);
        System.out.print(answer);
        return answer;
    }
	
	
	static void permutation(int len, int current, String[] result, boolean[] visited) {
		if(len==current) {
//			System.out.println(Arrays.toString(result));
			String temp = "";
			for(String string : result) temp += string;
			set.add(Integer.parseInt(temp));
//			System.out.println(set);
		} else {
			for(int i=0; i<num.length; i++) { // len 길이만큼 전체 배열을 탐색하며 숫자를 만듬
				if (!visited[i]) {
					visited[i]=true;
					result[current] = num[i];
					permutation(len, current+1, result, visited);
					visited[i] = false;
				}
			}
		}
	}
	
	static void checkNum(Set<Integer> set) {
		for(int num : set) {
			if(num==1 || num==0) continue;
			boolean flag = true;
			for(int i=2; i*i<=num; i++) {
				if(num%i==0) {
					flag = false;
					break;
				}
			}
			if(flag) {
				System.out.println(num);
				answer++;
			}
		}
	}
	
	public static void main(String[] args) {
		int[] temp = {3, 0, 6, 1, 5};
		solution("011");
	}
}
