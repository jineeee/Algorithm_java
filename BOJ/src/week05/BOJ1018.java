package week05;

import java.util.*;

/*
 * 백준 체스판 다시 칠하기 - 문자열 비교
 * https://www.acmicpc.net/problem/1018
 */

public class BOJ1018 {
	static int N,M;
	static char[][] map;
	static char[][] wb = new char[2][8];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		M = scanner.nextInt();
		scanner.nextLine();
		map = new char[N][M];
		
		for(int i=0; i<N; i++)
			map[i] = scanner.nextLine().toCharArray();
		
		int min = Integer.MAX_VALUE;
		for(int i=0; i<N-7; i++) {
		    for(int j=0; j<M-7; j++) {
		        min = Math.min(min, draw(i, j));
		    }
		}
		System.out.println(min);
	}
	
	static int draw(int a, int b) {
		int count = 0;
		char temp = 'B';
		for(int i=a; i<a+8; i++) {
			if(map[i][b] != temp) count++; // 0번 열 검사
			for(int j=b+1; j<b+8; j++) {
				if(map[i][j] == temp) { // 1번 열부터 검사
					count++;
					if(temp=='B') temp = 'W';
					else temp = 'B';
				}else temp = map[i][j];
			}
		}
		
		int count2 = 0;
		temp = 'W';
		for(int i=a; i<a+8; i++) {
			if(map[i][b] != temp) count2++;
			for(int j=b+1; j<b+8; j++) {
				if(map[i][j] == temp) {
					count2++;
					if(temp=='B') temp = 'W';
					else temp = 'B';
				}else temp = map[i][j];
			}
		}
		return Math.min(count, count2);
	}
	
	
}
