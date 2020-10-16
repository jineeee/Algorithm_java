

import java.util.Scanner;

/*
 * 기타레슨 - 이진탐색
 * https://www.acmicpc.net/problem/2343
 */

public class BOJ2343 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int M = scanner.nextInt();
		int[] arr = new int[N];
		int s = 0, e = 0, m = 0, ans = Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			arr[i] = scanner.nextInt();
			s = s<arr[i]? arr[i] : s; // 최소값은 가장 긴 레슨의 길이
			e += arr[i]; // 최대값은 모든 레슨 길이의 합
		}
		
		while(s<=e) {
			m = (s+e)/2;
			int sum = 0, cnt = 0;
			
			for(int i=0; i<N; i++) {
				if(sum+arr[i]>m) { // 기준 길이를 초과할 때 sum 값 초기화, 새로운 블루레이를 써야하므로 cnt 증가
					sum = 0;
					cnt++;
				}
				sum += arr[i]; // m은 항상 s값 이상이기 때문에 검사없이 더해줌
			}
			if(sum!=0) cnt++; // 배열 전체 탐색 후에 sum 값이 0이 아니라면 카운트되지 않은 블루레이가 쓰이고 있었으므로 cnt 증가
			
			if(cnt<=M) {
				ans = Math.min(ans, m);
				e = m-1;
			} else s = m+1;
		}
		
		System.out.print(ans);
	}
}
