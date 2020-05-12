package Lv2;

import java.util.Arrays;

/*
 * 소수 만들기 - 조합, 소수 확인
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 */

public class Level_2_17 {
	static int[] result = new int[3];
	static int answer = 0;

	static public int solution(int[] nums) {

		combi(0, 0, nums);
		System.out.print(answer);
		return answer;
	}

	static void combi(int current, int start, int[] nums) {
		if(current==3) {
			System.out.println(Arrays.toString(result));
			int num = 0;
			boolean flag = true;
			for(int n : result) num += n;
			
			for(int i=2; i*i<=num; i++) {
				if(num%i==0) flag = false;
			}
			if(flag) answer++;
		}else {
			for(int i=start; i<nums.length; i++) {
				result[current] = nums[i];
				combi(current+1, i+1, nums);
			}
		}
	}

	public static void main(String[] args) {
		int[] temp = { 1,2,7,6,4};
		solution(temp);
	}
}
