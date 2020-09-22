package week04;

import java.util.*;

/* 백준 결혼식 - 그래프
 * https://www.acmicpc.net/problem/5567
 */

public class BOJ5567 {
	static int n, m, a, b, answer=0;
	static int[][] map;
	static boolean[] check;
	static List<Integer> friend = new ArrayList();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		check = new boolean[n+1];
		map = new int[n+1][n+1];
		for(int i=0; i<m; i++) {
			a = scanner.nextInt();
			b = scanner.nextInt();
			map[a][b] = map[b][a] = 1;
			if(a==1) {
				answer++;
				check[b] = true;
			}
		}
		bfs();
		System.out.print(answer);
	}
	
	static void bfs() {
		for(int i=2; i<=n; i++) {
			for(int j=2; j<=n; j++) {
				if(map[1][i]==1 && map[i][j]==1 && !check[j]) {
					answer++;
					check[j]=true;
				}
			}
		}
	}
}
