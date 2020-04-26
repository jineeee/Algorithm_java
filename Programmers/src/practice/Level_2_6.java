package practice;

/*
 * 프로그래머스 Level 2
 * https://programmers.co.kr/learn/courses/30/lessons/12977
 */

public class Level_2_6 {
	
	static public int solution(int[] nums) {
        int answer = 0;

        // 배열에서 3개의 값을 뽑아 만들 수 있는 모든 경우를 검사
        for(int i=0; i<nums.length; i++) {
        	for(int j=i+1; j<nums.length; j++) {
        		for(int k=j+1; k<nums.length; k++) {
        			System.out.println(nums[i]+nums[j]+nums[k]);
        			if(isPrime(nums[i]+nums[j]+nums[k])) answer++;
        		}
        	}
        }        
        System.out.print(answer);
        return answer;
    }
	
	// 소수인지 판별하는 함수
	static boolean isPrime(int n) {
		for (int i=2; i*i<=n; i++) { // 나누는 값은 최대로 루트값까지만 검사하면 됨
			if(n%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		int [] nums = {1,2,7,6,4};
		solution(nums);
		
	}

}
