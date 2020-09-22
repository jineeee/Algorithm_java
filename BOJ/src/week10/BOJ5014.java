package week10;

import java.io.*;
import java.util.*;

/*
 * 스타트링크 - bfs
 * https://www.acmicpc.net/problem/5014
 */

public class BOJ5014 {

	static class Floor{
		int f, cnt;
		public Floor(int f, int cnt){
			this.f = f;
			this.cnt = cnt;
		}
	}
	
	static int F, S, G, U, D, ans = Integer.MAX_VALUE;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = br.readLine().split(" ");

		F = Integer.parseInt(arr[0]);
		S = Integer.parseInt(arr[1]);
		G = Integer.parseInt(arr[2]);
		U = Integer.parseInt(arr[3]);
		D = Integer.parseInt(arr[4]);
		
		visit = new boolean[F+1];
		
		bfs();
		
		if(ans==Integer.MAX_VALUE) System.out.print("use the stairs");
		else System.out.print(ans);
	}
	
	static void bfs() {
		Queue<Floor> queue = new LinkedList<Floor>();
		queue.offer(new Floor(S, 0));
		visit[S] = true;
		
		while (!queue.isEmpty()) {
			Floor nowFloor = queue.poll();
			
			if(nowFloor.f==G) ans = Math.min(ans, nowFloor.cnt);
		
			int nextU = nowFloor.f + U;
			int nextD = nowFloor.f - D;

			if(nextU<=F && nextU>0 && !visit[nextU]) {
				queue.offer(new Floor(nextU, nowFloor.cnt+1));
				visit[nextU] = true;
			}
			if(nextD<=F && nextD>0 && !visit[nextD]) {
				queue.offer(new Floor(nextD, nowFloor.cnt+1));
				visit[nextD] = true;
			}
		}
	}
}
