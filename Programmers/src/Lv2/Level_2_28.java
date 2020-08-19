package Lv2;

public class Level_2_28 {
	static public int solution(int[] numbers, int target) {
		int answer = 0;
		answer = dfs(numbers, target, 0, 0);
		System.out.println(answer);
        return answer;
    }
	
	static int dfs(int[] numbers, int target, int idx, int sum) {
		if(idx == numbers.length) {
			if (sum==target) {
				System.out.println(sum);
				return 1;
			}
			return 0;
		}else {
			return dfs(numbers, target, idx+1, sum+numbers[idx]) 
					+ dfs(numbers, target, idx+1, sum-numbers[idx]);
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,1,1};
		solution(arr, 3);
	}
}
