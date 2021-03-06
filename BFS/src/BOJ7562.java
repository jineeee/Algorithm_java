

import java.io.*;
import java.util.*;

/*
 * 백준 나이트의 이동 - bfs
 * https://www.acmicpc.net/problem/7562
 */

class Night{
	int x,y;
	public Night(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class BOJ7562 {
	static int N, x, y;
	static int[][] map;
	static int[] dx = {-2,-1,1,2,2,1,-1,-2};
	static int[] dy = {-1,-2,-2,-1,1,2,2,1};
	static Night night, target;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        
		for(int i=0; i<tc; i++) {
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			StringTokenizer st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			night = new Night(x, y);
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			target = new Night(x, y);
			bfs();
		}
	}
	
	static void bfs() {
		Queue<Night> queue = new LinkedList<Night>();
		queue.offer(night);
		while (!queue.isEmpty()) {
			Night now = queue.poll();
			if(now.x==target.x && now.y==target.y) {
				System.out.println(map[now.x][now.y]);
				break;
			}
			for(int i=0; i<8; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || map[nx][ny]!=0) continue;
				
				queue.offer(new Night(nx, ny));
				map[nx][ny] = map[now.x][now.y] + 1;
			}
		}
	}
}
