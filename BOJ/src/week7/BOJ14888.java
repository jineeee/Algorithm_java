package week7;

import java.util.*;

/*
 * 백준 연산자 끼워넣기 - dfs
 * 입력받은 연산자를 숫자로 치환해 새 배열에 넣고 하나씩 꺼내가며 계산 수행
 * https://www.acmicpc.net/problem/14888
 */

public class BOJ14888 {
	static int n, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr, op = new int[10];
	static boolean[] visit = new boolean[10];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int idx = 0;
		arr = new int[n];
		for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
		for (int i = 0; i < 4; i++) { // 입력받은 연산자를 숫자로 치환해서 저장
		    int cnt = scanner.nextInt();
		    for (int j = 0; j < cnt; j++) {
		        op[idx++] = i + 1;
		    }
		}
		dfs(0, 1, 0, arr[0]);
		System.out.println(max);
	    System.out.println(min);
	}
	
	// v : 연산자 배열의 인덱스
	// idx : 숫자 배열의 인덱스
	static void dfs(int v, int idx, int len, int num) {
		int result = 0; // 이번 재귀 함수에서 계산한 값을 담을 변수
		if(len == n-1) {
			max = Math.max(max, num);
			min = Math.min(min, num);
		}else {
			for(int i=0; i<n-1; i++) { // i는 연산자 배열의 인덱스이므로 n-1을 넘지 않음
				if(visit[i]) continue;
				switch (op[i]) {
				case 1:
					result = num + arr[idx];
					break;
				case 2:
					result = num - arr[idx];
					break;
				case 3:
					result = num * arr[idx];
					break;
				case 4:
					result = num / arr[idx];
					break;
				}
				visit[i] = true;
				dfs(i, idx+1, len+1, result);
			}
		}
		visit[v] = false;
	}
}
