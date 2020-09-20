import java.io.*;

/*
 * 외판원2 - dfs 기본
 * https://www.acmicpc.net/problem/10971
 */

public class BOJ10971 {
	
	static int N, ans = Integer.MAX_VALUE;
	static int[][] map;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visit = new boolean[N];
		
		for(int i=0; i<N; i++) {
			String[] arr = br.readLine().split(" ");
			for(int j=0; j<N; j++) map[i][j] = Integer.parseInt(arr[j]);
		}
		
		for(int i=0; i<N; i++) dfs(i, i, 0, 0);
		
		System.out.print(ans);
	}

	static void dfs(int start, int idx, int cnt, int sum) {
		if(cnt==N && idx==start) {
			ans = Math.min(sum, ans);
			return;
		}
		else {
			for(int i=0; i<N; i++) {
				if(map[idx][i]==0 || visit[i]) continue;
				visit[i] = true;
				sum += map[idx][i];
				dfs(start, i, cnt+1, sum);
				visit[i] = false;
				sum -= map[idx][i];
			}
		}
	}
}
