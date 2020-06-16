package week6;


import java.util.*;

/*
 * 백준 스타트와 링크 - 조합, 배열 탐색
 * https://www.acmicpc.net/problem/14889
 */

public class BOJ14889 {
	static int n, len, ans = Integer.MAX_VALUE;
	static int[][] map;
	static int[] arr, result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		len = n/2;
		result = new int[len];
		map = new int[n][n];
		arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = i;
			for(int j=0; j<n; j++) map[i][j] = scanner.nextInt();
		}
		combi(0, 0);
		System.out.print(ans);
	}
	
	static void combi(int current, int start) {
		if(current==len) {
			getResult(result);
		}else {
			for(int i=start; i<arr.length; i++) {
				result[current] = arr[i];
				combi(current+1, i+1);
			}
		}
	}
	
	static void getResult(int[] result) {
		List<Integer> list = new LinkedList<>();
		List<Integer> list2 = new LinkedList<>();
		for(int i:result) list.add(i);
		for(int i=0; i<n; i++) if(!list.contains(i)) list2.add(i);
		int team1=0, team2=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(list.contains(i) && list.contains(j))
					team1 += map[i][j];
				else if(list2.contains(i) && list2.contains(j))
					team2 += map[i][j];
			}
		}
		ans = Math.min(Math.abs(team1-team2), ans);
	}
}
