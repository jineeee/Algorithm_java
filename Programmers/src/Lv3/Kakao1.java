package Lv3;

/*
 * 카카오 징검다리 - 정확도만 패스
 * https://programmers.co.kr/learn/courses/30/lessons/64062
 */

public class Kakao1 {

	public static void main(String[] args) {
		int[] arr = {2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
		solution(arr, 3);
	}
	
	static int solution(int[] stones, int k) {
        int answer = 0;
        boolean flag = true;
        
        while(flag) {
        	int cnt = 0;
        	for(int i=0; i<stones.length; i++) {
        		if(stones[i]!=0) {
        			stones[i]--;
        			cnt = 0;
        		}else {
        			if(cnt<k) cnt++;
        		}
        		if(cnt==k) {
        			System.out.println(answer);
        			return 0;
        		}
        	}
        	answer++;
        }
        return answer;
    }
}
