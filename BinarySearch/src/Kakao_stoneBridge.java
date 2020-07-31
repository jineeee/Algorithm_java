
/*
 * 카카오 징검다리 - 이진 탐색 (숫자 하나 찾기)
 * https://programmers.co.kr/learn/courses/30/lessons/64062
 */

public class Kakao_stoneBridge {

	public static void main(String[] args) {
		int[] arr = {6, 4, 5, 10, 200, 1111, 4, 209, 5, 1};
		System.out.print(solution(arr, 3));
	}
	
	static int solution(int[] stones, int k) {
        int answer = 0;
		
		int s = 1;
		int e = 200000000;
		int m = (s+e)/2;
		
		while (s<=e) {
			if(check(m, stones, k)==1) {
				e=m-1;
			}else if(check(m, stones, k)==0){
				s=m+1;
			}
			m = (s+e)/2;
			answer = e;
		}
		 System.out.println(s + " " + m + " " + e);
        return answer;
    }
	
	static int check(int m, int[] stones, int k) {
		int cnt = 0;
		for(int i=0; i<stones.length; i++) {
			if(stones[i]-m<0) cnt++;
			else cnt=0;
    		if(cnt==k) return 1;
    	}
		return 0;
	}
}
