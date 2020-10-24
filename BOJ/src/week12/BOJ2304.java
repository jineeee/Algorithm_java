package week12;

import java.util.*;

/*
 * 스택, 구현, 물채우기
 * https://www.acmicpc.net/problem/2304
 */

public class BOJ2304 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int[] arr = new int[1001];
		int left = 1000, right = 0;
		for(int i=0; i<n; i++) {
			int x = scanner.nextInt();
			int y = scanner.nextInt();
			arr[x] = y;
			left = Math.min(left, x); // 가장 왼쪽 값
			right = Math.max(right, x); // 가장 오른쪽 값
		}
		
		Stack<Integer> stack = new Stack<Integer>();
		
		// 가장 왼쪽부터 탐색
		int pivot = arr[left];
		for(int i=left+1; i<=right; i++) {
			if(arr[i]<pivot) stack.push(i); // 기준보다 높이가 낮은 기둥을 스택에 넣음
			else { // 높이가 더 높은 기둥이 나타났을 때
				while (!stack.isEmpty()) {
					int p = stack.pop();
					arr[p] = pivot; // 지금까지 나온 모든 칸을 기준 높이로 변경
				}
				pivot = arr[i]; // 새로 나타난 기둥을 기준으로 변경
			}
		}
		
		// 가장 오른쪽부터 탐색
		stack.clear();
		pivot = arr[right];
		for(int i=right-1; i>=left; i--) {
			if(arr[i]<pivot) stack.push(i);
			else {
				while (!stack.isEmpty()) {
					int p = stack.pop();
					arr[p] = pivot;
				}
				pivot = arr[i];
			}
		}
		
		// 시작과 끝점 사이의 높이를 모두 더함
		int ans = 0;
		for(int i=left; i<=right; i++) ans += arr[i];
		System.out.print(ans);
		
	}

}
