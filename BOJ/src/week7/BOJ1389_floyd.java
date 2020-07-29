package week7;

import java.io.*;
import java.util.*;

/*
 * 케빈 베이컨의 6단계 법칙 - 플로이드 와샬 (for문 순서에 유의)
 * https://www.acmicpc.net/problem/1389
 */

public class BOJ1389_floyd {
	static int n, m;
	static int[][] map;
	static boolean[] visit;
	static int[] res;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n+1][n+1];
		res = new int[n+1];
		
		for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                map[i][j] = (i==j) ? 0:9999999;
            }
        }
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			map[a][b] = map[b][a] = 1;
		}
		
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				if(map[i][k]==0) continue;
				for(int j=1; j<=n; j++) {
					if(map[k][j]==0) continue;
					map[i][j] = Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		for(int i=1; i<=n; i++) {
			int sum = 0;
			for(int j=1; j<=n; j++) {
				sum += map[i][j];
			}
			res[i] = sum;
			min = Math.min(min, sum);
		}
		
		for(int i=1; i<=n; i++) {
			if(res[i]==min) {
				System.out.print(i);
				break;
			}
		}
	}
}
