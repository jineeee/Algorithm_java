package Lv3;

/*
 * 카카오 징검다리 - 이진탐색
 * https://programmers.co.kr/learn/courses/30/lessons/64062
 */

public class Kakao01_binarySearch {

	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		System.out.print(solution(arr, 3));
	}
	
	static int solution(int[] stones, int k) {
        int answer = 0;
	
		int s = 0;
		int e = 200000000;
		int m = 0;
		
		while (s<=e) {
			m = (s+e)/2;
			if(check(m, stones, k)) {
				answer = m;
				s = m+1;
			}else e = m-1;
		}
//		  System.out.println(s + " " + m + " " + e);
        return answer;
    }
	
	static boolean check(int m, int[] stones, int k) {
		int cnt = 0;
		for(int i=0; i<stones.length; i++) {
			if(stones[i]-m<0) {
				cnt++;
				if(cnt>=k) return false;
			} else cnt=0;
    	}
		return true;
	}
}
