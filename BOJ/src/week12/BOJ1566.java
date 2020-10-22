package week12;

import java.util.*;

public class BOJ1566 {

	static int n, m, ans = 987654321;
	static int[][] map, temp;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		temp = new int[n][m];
		map = new int[n][m];
		int sum = 0;
		for(int i=0; i<n; i++) 
			for(int j=0; j<m; j++) {
				map[i][j] = scanner.nextInt();
				sum += map[i][j];
			}
		
//		if(sum==0) {
//			System.out.print(-1);
//			return;
//		}
		
		dfs(map, 0);
		System.out.print(ans);
	}
	
	static void dfs(int[][] map, int cnt) {
		if(cnt>Math.pow(2, 18)*Math.pow(18, 2)) {
			ans = -1;
			return;
		}
		if(check(map)) {
			ans = Math.min(ans, cnt);
			return;
		}else {
			int sum = 0;
			
			for(int i=0; i<n; i++) {
				sum = 0;
				for(int j=0; j<m; j++) sum+=map[i][j];	
				if(sum<=0) {
					temp = changeRow(map, i);
					dfs(temp, cnt+1);
				}
			}
			
			for(int i=0; i<m; i++) {
				sum = 0;
				for(int j=0; j<n; j++) sum+=map[j][i];
				if(sum<=0) {
					temp = changeCol(map, i);
					dfs(temp, cnt+1);
				}
			}
		}
		
	}
	
	static int[][] changeRow(int[][] map, int row){
		for(int i=0; i<m; i++) map[row][i] *= -1;
		return map;
	}
	
	static int[][] changeCol(int[][] map, int col){
		for(int i=0; i<n; i++) map[i][col] *= -1;
		return map;
	}
	
	static boolean check(int[][] map) {
		int[] col = new int[m];
		int sum = 0;
		for(int i=0; i<n; i++) {
			sum = 0;
			for(int j=0; j<m; j++) {
				sum += map[i][j];
				col[j] += map[i][j];
			}
			if(sum<=0) return false;
		}
		for(int c : col) if(c<=0) return false;
		
		return true;
	}
}

