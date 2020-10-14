package week11;
import java.io.*;

/*
 * 삼성 기출 - 문제 구현
 * https://www.acmicpc.net/problem/14499
 */
public class BOJ14499 {
	
	static int n, m, x, y, k;
	static int[][] map; 
	static int[] dice = new int[7];
	static int[] dx = {0,0,0,-1,1};
	static int[] dy = {0,1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strings = br.readLine().split(" ");
		n = Integer.parseInt(strings[0]); // 지도의 세로 크기
		m = Integer.parseInt(strings[1]); // 지도의 가로 크기
		x = Integer.parseInt(strings[2]); // 주사위의 좌표
		y = Integer.parseInt(strings[3]); // 주사위의 좌표
		k = Integer.parseInt(strings[4]); // 명령의 개수
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			strings = br.readLine().split(" ");
			for(int j=0; j<strings.length; j++) 
				map[i][j] = Integer.parseInt(strings[j]);
		}
		strings = br.readLine().split(" ");
		
		for(int i=0; i<k; i++) {
			int order = Integer.parseInt(strings[i]);
			int nx = x + dx[order];
			int ny = y + dy[order];
			if(!isValid(nx, ny)) continue; // 지도의 범위를 벗어나는 경우
			roll(order);
			if(map[nx][ny]==0) map[nx][ny] = dice[6];
			else {
				dice[6] = map[nx][ny];
				map[nx][ny] = 0;
			}
			
			System.out.println(dice[1]);
			x = nx; y = ny;
		}
		
		
	}
	
	static void roll(int order) {
		int[] temp = dice.clone();
		
		switch (order) {
		case 1:
			dice[1] = temp[4];
			dice[3] = temp[1];
			dice[4] = temp[6];
			dice[6] = temp[3];
			break;
		case 2:
			dice[1] = temp[3];
			dice[3] = temp[6];
			dice[4] = temp[1];
			dice[6] = temp[4];
			break;
		case 3:
			dice[1] = temp[5];
			dice[2] = temp[1];
			dice[5] = temp[6];
			dice[6] = temp[2];
			break;
		case 4:
			dice[1] = temp[2];
			dice[2] = temp[6];
			dice[5] = temp[1];
			dice[6] = temp[5];
			break;
		}
	}

	static boolean isValid(int x, int y) {
		return x>=0 && x<n && y>=0 && y<m;
	}
}
