package Lv3;

import java.util.*;

/*
 * 카카오 경주로 건설 - bfs
 * https://programmers.co.kr/learn/courses/30/lessons/67259
 */

public class Kakao10_bfs {
	public static void main(String[] args) {
		int[][] arr1 = {{0,0,0},{0,0,0},{0,0,0}};
		int[][] arr2 = {{0,0,0,0,0,0,0,1},{0,0,0,0,0,0,0,0},{0,0,0,0,0,1,0,0},
		                {0,0,0,0,1,0,0,0},{0,0,0,1,0,0,0,1},{0,0,1,0,0,0,1,0},{0,1,0,0,0,1,0,0},{1,0,0,0,0,0,0,0}};
		int[][] arr3 = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		solution(arr1);
	}
	
	static class Car{
		int x, y, dir, cost;
		
		public Car(int x, int y, int dir, int cost) {
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.cost = cost;
		}
	}
	
	static int n, answer = Integer.MAX_VALUE;
	static Queue<Car> queue = new LinkedList<Car>();
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int[][][] visit;
	
	public static int solution(int[][] board) {
        n = board.length;
        visit = new int[n][n][4];
        
        bfs(board);
        return answer;
    }

//	static void bfs(int[][] board) {
//		queue.add(new Car(0, 0, -1, 0));
//		board[0][0] = 1;
//		
//		while (!queue.isEmpty()) {
//			Car car = queue.poll();
//			
//			if(car.x==n-1 && car.y==n-1) {
//				board[n-1][n-1] = Math.min(board[n-1][n-1], car.cost);
//				continue;
//			}
//			
//			for(int i=0; i<4; i++) {
//				int nx = car.x + dx[i];
//				int ny = car.y + dy[i];
//				
//				if(!isValid(nx, ny) || board[nx][ny]==1) continue; 
//				
//				int nowCost;
//				if (car.dir==-1 || car.dir ==i)  nowCost = car.cost+100;
//				else nowCost = car.cost+600;
//				
//				if(board[nx][ny]==0 || board[nx][ny]>=nowCost) {
//					queue.add(new Car(nx, ny, i, nowCost));
//					board[nx][ny] = nowCost;
//				}
//			}
//		}
//	}
	
	static void bfs(int[][] board) {
		queue.add(new Car(0, 0, -1, 0)); // 시작점의 경우 예외이므로 방향을 -1로 넣어 예외처리
		
		while (!queue.isEmpty()) {
			Car car = queue.poll();
			
			if(car.x==n-1 && car.y==n-1) {
				answer = Math.min(answer, car.cost);
				continue;
			}
			
			for(int i=0; i<4; i++) {
				int nx = car.x + dx[i];
				int ny = car.y + dy[i];
				
				if(!isValid(nx, ny) || board[nx][ny]==1) continue; 
				
				int tempCost = 0;
				if(car.dir==-1) tempCost = car.cost + 100;
				else if(car.dir==i) tempCost = car.cost + 100;
				else tempCost = car.cost + 600;
				
				 // 처음 가는 길이거나 총 가격이 더 적은 경우에만 방문
				if(visit[nx][ny][i]==0 || visit[nx][ny][i]>tempCost) {
					queue.add(new Car(nx, ny, i, tempCost));
					visit[nx][ny][i] = tempCost;
				}
			}
		}
	}
	
	static boolean isValid(int x, int y) {
		return x>=0 && y>=0 && x<n && y<n;
	}
	
}
