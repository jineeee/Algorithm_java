package Lv2;

/*
 * h-index
 * https://programmers.co.kr/learn/courses/30/lessons/42747
 */

public class Level_2_26 {
	
	public static int solution(int[] citations) {
        int answer = 0;
        int num = 0;
        
        int n = citations.length;
        while (true) {
			num++;
			int cnt = 0;
			for(int i=0; i<n; i++) {
				if(num <= citations[i]) cnt++;
			}
			if(cnt>=num) answer = Math.max(answer, num);
			else break;
		}
        return answer;
    }

	public static void main(String[] args) {
		int[] arr = {3, 0, 6, 1, 5};
		solution(arr);
	}
}
