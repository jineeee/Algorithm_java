package Lv3;

import java.util.*;

/*
 * 카카오 블록이동하기 - bfs
 * https://programmers.co.kr/learn/courses/30/lessons/60063
 */

public class Kakao08_bfs {
	
	public static void main(String[] args) {
		int[][] arr = {{0, 0, 0, 1, 1},{0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
		solution(arr);
	}
	
	static class Robot{
		int x, y, dir, time;
		
		Robot(int x, int y, int dir, int time){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.time = time;
		}
		
		public int nextX() {
			return x + dx[dir];
		}
		
		public int nextY() {
			return y + dy[dir];
		}
		
	}
	
	static boolean[][][] visit;
	static Queue<Robot> queue = new LinkedList<Robot>();
	static int n;
	
	private final static int[] dx = { 0, 1, 0, -1 };
	private final static int[] dy = { 1, 0, -1, 0 };
	private final static int[] rdx = { -1, 1, 1, -1 };
	private final static int[] rdy = { 1, 1, -1, -1 };
	
	public static int solution(int[][] board) {
        n = board.length;
        visit = new boolean[n][n][4];
        
        int answer = bfs(board);
        return answer;
    }
	
	static int bfs(int[][] board) {
		queue.add(new Robot(0, 0, 0, 0));
		visit[0][0][0] = true;
		
		while (!queue.isEmpty()) {
			Robot robot = queue.poll();
//			
			if(isFinish(robot.x, robot.y) || isFinish(robot.nextX(), robot.nextY()))
				return robot.time;
			
			// 상하좌우로 이동
			for(int i=0; i<4; i++) {
				int nx = robot.x + dx[i];
				int ny = robot.y + dy[i];
				int bx = robot.nextX() + dx[i];
				int by = robot.nextY() + dy[i];
				
				if(!isValid(nx, ny) || !isValid(bx, by) || visit[nx][ny][robot.dir]) continue;
				if(board[nx][ny]==1 || board[bx][by]==1) continue;
				
				queue.add(new Robot(nx, ny, robot.dir, robot.time+1));
				visit[nx][ny][robot.dir] = true;
			}
			
			for(int i=1; i<4; i+=2) {
				// 다음 방향
				int nDir = (robot.dir+i)%4;
				// 이동한 후 좌표
				int bx = robot.x + dx[nDir];
				int by = robot.y + dy[nDir];
				
				int tempDir;
				if(i==1) // 시계 방향 회전
					tempDir = nDir;
				else  // 반시계 방향 회전
					tempDir = robot.dir;
				
				// 대각선 좌표
				int dgx = robot.x + rdx[tempDir];
				int dgy = robot.y + rdy[tempDir];
				
				if(!isValid(bx, by) || !isValid(dgx, dgy) || board[dgx][dgy]==1 || board[bx][by]==1) continue;
				if(visit[robot.x][robot.y][nDir]) continue;
				
				queue.add(new Robot(robot.x, robot.y, nDir, robot.time+1));
				visit[robot.x][robot.y][nDir] = true;
			}
			
			int dir = (robot.dir + 2) % 4;
			for(int i=1; i<4; i+=2) {
				// 다음 방향
				int nDir = (dir + i) % 4;
				// 이동한 후 좌표
				int nx = robot.nextX() + dx[nDir];
				int ny = robot.nextY() + dy[nDir];
				
				int tempDir = (i == 1) ? nDir : dir;
				// 대각선 좌표
				int dgx = robot.nextX() + rdx[tempDir];
				int dgy = robot.nextY() + rdy[tempDir];
				
				nDir = (nDir+2)%4;
				if(!isValid(nx, ny) || !isValid(dgx, dgy) || board[dgx][dgy]==1 || board[nx][ny]==1) continue;
				if(visit[nx][ny][nDir]) continue;
				
				queue.add(new Robot(nx, ny, nDir, robot.time+1));
				visit[nx][ny][nDir] = true;
			}
		}
		return -1;
	}
	
	static boolean isValid(int x, int y) {
		return x >= 0 && y >= 0 && x < n && y < n;
	}

	static boolean isFinish(int x, int y) {
		return x == n - 1 && y == n - 1;
	}
}



