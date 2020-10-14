package week11;

import java.io.*;

public class BOJ14499 {
	
	static int n, m, x, y, k;
	static int[][] map;
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
	}

}
