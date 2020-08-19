package Lv2;

/*
 * 타겟넘버 - dfs
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 */

public class Level_2_28 {
	static int answer = 0;
	
	static public int solution(int[] numbers, int target) {
//		answer = dfs(numbers, target, 0, 0);
		dfs(numbers, target, 0);
		System.out.println(answer);
        return answer;
    }
	
//	static int dfs(int[] numbers, int target, int idx, int sum) {
//		if(idx == numbers.length) {
//			if (sum==target) return 1;
//			return 0;
//		}else return dfs(numbers, target, idx+1, sum+numbers[idx]) 
//					+ dfs(numbers, target, idx+1, sum-numbers[idx]);
//	}
	
	static void dfs(int[] numbers, int target, int idx) {
		if(idx == numbers.length) {
			int sum = 0;
			for(int i : numbers) sum += i;
			if(sum==target) answer++;
			
			return;
		}else {
			numbers[idx] *= 1;
			dfs(numbers, target, idx+1);
			
			numbers[idx] *= -1;
			dfs(numbers, target, idx+1);
		}
	}

	public static void main(String[] args) {
		int[] arr = {2,4,1,1,1};
		solution(arr, 3);
	}
}
