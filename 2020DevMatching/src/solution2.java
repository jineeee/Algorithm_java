import java.util.*;

public class solution2 {
	static boolean flag = false;
	static int[] dx = {0,0,-1,1};
	static int[] dy = {1,-1,0,0};
	static int len = 15, garo=0, sero=0;
	static boolean[][] visit = new boolean[15][15];
	static Queue<int[]> queue = new LinkedList<int[]>();
	
	static public int solution(int[][] board) {
        int answer = -1;
        for(int i=0; i<len; i++) {
        	for(int j=0; j<len; j++) {
        		if((board[i][j]==1 || board[i][j]==2)&&!flag) {
        			queue.offer(new int[] {i,j});
        			answer = bfs(board);
        		}
        	}
        }
        System.out.println(answer);
        if(answer==1) return 1;
        if(answer==2) return 2;
        else return 0;
    }
	
	static int bfs(int[][] board) {
		if(flag) System.exit(0);
		garo=0; sero=0;
		int color = 0;
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
//			System.out.println(now[0] + " now " + now[1]);
			color = board[now[0]][now[1]];
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				if(nx<0 || ny<0 || nx>=len || ny>=len || visit[nx][ny]) 
					continue;
				if(board[now[0]][now[1]] == board[nx][ny]) {
					if(i==0||i==1) {
						garo++;
						queue.offer(new int[] {nx,ny});
						visit[nx][ny] = true;
						System.out.println(nx + " garo " + ny);
					}else {
						sero++;
						queue.offer(new int[] {nx,ny});
						visit[nx][ny] = true;
						System.out.println(nx + " sero " + ny);
					}
				}
			}
			System.out.println("garo "+garo);
			System.out.println("sero "+sero);
			if(garo==5 || sero==5) {
				System.out.println("가로 " + color);
				flag=true;
				return color;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[][] map = {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 2, 1, 1, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 2, 2, 2, 2, 2, 0, 0, 0, 0, 0, 0},
		               {0, 0, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
		               {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
		solution(map);
	}
}
