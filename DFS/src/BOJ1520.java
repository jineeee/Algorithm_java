import java.io.*;
import java.util.*;

/*
 * 높이가 더 낮은 길로만 이동하기 - dfs,dp 
 * https://www.acmicpc.net/problem/1520
 */

public class BOJ1520 {

	static int M, N, ans;
	static int[][] map, dist;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strings = br.readLine().split(" ");
		M = Integer.parseInt(strings[0]);
		N = Integer.parseInt(strings[1]);
		map = new int[M][N];
		dist = new int[M][N];
		for(int i=0; i<M; i++) Arrays.fill(dist[i], -1);
		
		for(int i=0; i<M; i++) {
			strings = br.readLine().split(" ");
			for(int j=0; j<N; j++)
				map[i][j] = Integer.parseInt(strings[j]);
		}
		
		System.out.println(dfs(0, 0));
		
	}
	
	static int dfs(int x, int y) {
		if(x==M-1 && y==N-1) return 1;
		if(dist[x][y]==-1) { // 처음 오는 길
			dist[x][y] = 0;
			for(int i=0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx>=M || ny >=N) continue;
				if(map[nx][ny]<map[x][y]) dist[x][y] += dfs(nx, ny);
			}
		}
		return dist[x][y];
	}
}
