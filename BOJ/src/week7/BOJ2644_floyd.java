package week7;

import java.util.*;

/*
 * 촌수계산 - 플로이드 알고리즘
 * https://www.acmicpc.net/problem/2644
 */

public class BOJ2644_floyd {
	static int n, m, t1, t2;
	static int[][] map;
	static int[] res;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		t1 = scanner.nextInt();
		t2 = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n+1][n+1];
		res = new int[n+1];
		
		for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = (i==j) ? 0:9999999;
            }
        }
		
		for(int i=0; i<m; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			map[a][b] = map[b][a] = 1;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(map[i][k]==0) continue; 
				for(int j=1; j<=n; j++) {
					if (map[k][j]==0) continue;
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}
		
		if (t1==t2) System.out.print(0);
		else if(map[t1][t2]==9999999) System.out.print(-1);
		else System.out.print(map[t1][t2]);
		
	}
}
