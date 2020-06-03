

import java.io.*;
import java.util.*;

/*
 * 백준 입국심사 - 이분탐색, long 다루기
 * https://www.acmicpc.net/problem/3079
 */

public class BOJ3079 {
	static long n, m, max;
	static long[] time;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Long.parseLong(st.nextToken());
		m = Long.parseLong(st.nextToken());
		time = new long[(int)n];
		for(int i=0; i<n; i++) {
			time[i] = Long.parseLong(br.readLine());
			max = Math.max(max, time[i]); // 가장 긴 시간을 찾음
		}
		System.out.println(binarySearch());
	}
	
	static long binarySearch() {
		long left = 1;
		long right = max*m; // 최대값 -> 가장 긴 시간 * 사람 수
		long result = right; // min 값을 찾기 위해 초기값은 최대값으로 초기화
		while (left<=right) {
			long mid = (left+right)/2;
			
			if(check(mid)){ // 입국 심사 가능한 사람이 m보다 크거나 같으면
				result = Math.min(result, mid); // 답일 가능성이 있으므로 min 초기화
				right = mid-1; // mid를 기준으로 왼쪽을 탐색
			}else {
				left = mid+1; // mid를 기준으로 오른쪽을 탐색
			}
		}
		return result;
	}
	
	static boolean check(long mid) {
		long count=0;
		for(int i=0; i<n; i++) // 입국심사 가능한 사람 수를 세는 반복문
			count += mid/time[i]; // 가능한 사람 수 -> 전체시간 / 입국심사대마다 걸리는 시간
		return count >= m; 
	}
}
