package week09;

import java.util.*;

/*
 * 공유기 - 이진탐색(통과)
 * https://www.acmicpc.net/problem/2110
 */

public class BOJ2110_bs {
	static int n, c, ans;
	static int[] home;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		c = scanner.nextInt();
		home = new int[n];
		for(int i=0; i<n; i++) home[i] = scanner.nextInt();
		Arrays.sort(home);
		
		int s = 1;
		int e = home[n-1]-home[0];
		int dist = 0;
		
		while (s<=e) {
			int mid = (s+e)/2;
			int start = home[0]; // 첫번째 집에 공유기 설치
			int cnt = 1; // 첫번째 집에 설치됐으므로 1
			
			for(int i=1; i<n; i++) {
				dist = home[i] - start; // 공유기가 설치된 집과의 거리 계산
				if(mid<=dist) { // 기준 거리 이상일 때만 공유기 설치
					cnt++;
					start = home[i];
				}
			}
			
			if(cnt>=c) { // 공유기가 더 여러개 설치된 경우 -> 간격을 넓힘
				s = mid+1;
				ans = mid;
			}else { // 공유기가 더 적게 설치된 경우 -> 간격을 좁힘
				e = mid-1;
			}
		}
		
		System.out.print(ans);
	}
}
