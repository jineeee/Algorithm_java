

import java.io.*;
import java.util.*;

/*
 * 백준 맥주 마시면서 걸어가기 - 이차원 배열이 아닌 좌표로 bfs
 * https://www.acmicpc.net/problem/9205
 */

class Spot{
	int x,y;
	public Spot(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class BOJ9205 {
	static int t, n, dist;
	static Spot[] loc;
	static boolean[] check;

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		t = scanner.nextInt();
		for(int i=0; i<t; i++) {
			n = scanner.nextInt();
			loc = new Spot[n+2];
			check = new boolean[n+2];
			for(int j=0; j<n+2; j++) {
				loc[j] = new Spot(scanner.nextInt(), scanner.nextInt());
			}
			
			boolean flag = false;
			Spot home = loc[0];
			Spot rock = loc[n+1];
			Queue<Spot> queue = new LinkedList<Spot>();
			queue.offer(loc[0]);
			check[0] = true;
			
			while (!queue.isEmpty()) {
				Spot now = queue.poll();
				if(now.equals(rock)) {
					flag = true;
					break;
				}
				for(int j=1; j<n+2; j++) {
					if(!check[j] && Math.abs(loc[j].x-now.x) + Math.abs(loc[j].y-now.y)<=1000) {
						queue.offer(loc[j]);
						check[j] = true;
					}
				}
			}
			if(flag) System.out.println("happy");
			else System.out.println("sad");
		}
	}
}
