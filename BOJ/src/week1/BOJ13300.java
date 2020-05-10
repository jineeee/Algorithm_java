package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
 * 방 배정 - 이차원 배열 사용 
 * https://www.acmicpc.net/problem/13300
 */
public class BOJ13300 {
	static int N, K, S, count;
	static int[][] student = new int[2][7]; // 행은 성별, 열은 학년을 인덱스로 가지는 배열
	
	public static void getRoom() {
		for(int i=0; i<2; i++) {
			for(int j=1; j<7; j++) {
				if(student[i][j]==0) continue;
				else if(student[i][j]<=K) count++;
				else {
					while(student[i][j]>K) {
						student[i][j] -= K;
						count++;
					}
					if(student[i][j]!=0) count++;
				}	
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		while(N-->0) { //성별, 학년별 학생수를 배열에 저장
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			student[x][y] += 1;	
		}
		getRoom();
		System.out.print(count);
	}
}
