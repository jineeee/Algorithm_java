import java.io.*;

/* 파티 - 플로이드 와샬
 * https://www.acmicpc.net/problem/1238
 */

public class BOJ1238_floyd {
	
	static int N, M, X, INF = 987654321;
	static int[][] dist;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		M = Integer.parseInt(arr[1]);
		X = Integer.parseInt(arr[2]);
		dist = new int[N+1][N+1];
		
		for(int i=1; i<=N; i++) 
			for(int j=1; j<=N; j++) {
				if(i==j) continue;
				dist[i][j] = INF;
			}
		
		for(int i=0; i<M; i++) {
			arr = br.readLine().split(" ");
			int start = Integer.parseInt(arr[0]);
			int end = Integer.parseInt(arr[1]);
			int weight = Integer.parseInt(arr[2]);
			dist[start][end] = weight;
		}
		
		floyd();
		
		int answer = 0;
		for(int i=1; i<=N; i++) {
			answer = Math.max(answer, dist[i][X] + dist[X][i]);
		}
		System.out.print(answer);
	}
	
	static void floyd() {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
				}
			}
		}
	}

}
