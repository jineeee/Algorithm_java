package week6;

import java.io.*;

/*
 * 백준 톱니바퀴 - dp
 * https://www.acmicpc.net/problem/14891
 */

public class BOJ14891 {
	static int k;
	static int[][] spin, wheel = new int[4][8];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<4; i++) {
			String[] st = br.readLine().split("");
			for(int j=0; j<8; j++)
				wheel[i][j] = Integer.parseInt(st[j]);
		}
		k = Integer.parseInt(br.readLine());
		spin = new int[k][2];
		for(int i=0; i<k; i++) {
			String[] st = br.readLine().split(" ");
			spin[i][0] = Integer.parseInt(st[0])-1;
			spin[i][1] = Integer.parseInt(st[1]);
		}
		spinW();
		int result=0;
		if(wheel[0][0]==1) result += 1;
		if(wheel[1][0]==1) result += 2;
		if(wheel[2][0]==1) result += 4;
		if(wheel[3][0]==1) result += 8;
		System.out.println(result);
	}
	
	static void spinW() {
		for(int i=0; i<k; i++) {
			int now = spin[i][0];
			int dir = spin[i][1];
			left(now-1, -dir);
			right(now+1, -dir);
			rotate(now, dir);
		}
	}
	
	static void left(int l, int d) {
		if(l<0) return;
		if(wheel[l][2]!=wheel[l+1][6]) { // 회전시켜야함
			left(l-1, -d);
			rotate(l, d);
		}
	}
	
	static void right(int r, int d) {
		if(r>3) return;
		if(wheel[r][6]!=wheel[r-1][2]) { // 회전시켜야함
			right(r+1, -d);
			rotate(r, d);
		}
	}
	
	static void rotate(int w, int dir) {
		if(dir==-1) {
			int temp = wheel[w][0];
			for(int i=0; i<7; i++)
				wheel[w][i] = wheel[w][i+1];
			wheel[w][7] = temp;
		}else {
			int temp = wheel[w][7];
			for(int i=7; i>0; i--)
				wheel[w][i] = wheel[w][i-1];
			wheel[w][0] = temp;
		}
	}
}
