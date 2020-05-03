package Lv2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 카카오 프렌즈 컬러링북
 * https://programmers.co.kr/skill_checks/123839
 */

public class Level_2_03 {
	
	static public int[] solution(int m, int n, int[][] picture) {
	      int numberOfArea = 0;
	      int maxSizeOfOneArea = 0;
	      int[] answer = new int[2];     
	      int[][] visit = new int[m][n];
	     
	      for(int i=0; i<m; i++) {
	    	  for(int j=0; j<n; j++) {
	    		  if(visit[i][j]==1 | picture[i][j]==0) continue;
	    		  // 가장 큰 영역의 count 값만 저장
	    		  maxSizeOfOneArea = Math.max(bfs(picture, visit, i,j,m, n), maxSizeOfOneArea);
	    		  // 함수를 한번 실행하면 하나의 영역을 찾은 것이므로 +1
	    		  numberOfArea++;
	    	  }
	      }
	      
	      answer[0] = numberOfArea;
	      answer[1] = maxSizeOfOneArea;
	      return answer;
	  }
	
	static int bfs(int[][] picture, int[][] visit, int x, int y, int m, int n) {
		Queue<int[]> queue = new LinkedList<int[]>();
		int[] dx = {0,0,-1,1};
		int[] dy = {-1,1,0,0};
		int count=1; // 매개변수로 들어온 좌표의 위치도 포함해야하므로 1로 초기화
		
		visit[x][y] = 1;
		queue.offer(new int[] {x,y});
		
		while (!queue.isEmpty()) {
			int[] now = queue.poll();
			
			for(int i=0; i<4; i++) {
				int nx = now[0] + dx[i];
				int ny = now[1] + dy[i];
				
				// 다음 탐색할 노드가 유효한 범위 이내에 있지 않거나 값이 0이라면 다음 노드 탐색
				if(nx<0 || nx>=m || ny<0 || ny>=n || visit[nx][ny]==1 || picture[nx][ny]==0) continue;
				// 색이 같은 노드만 탐색해야하므로 값을 비교
				if(picture[nx][ny] == picture[now[0]][now[1]]) {
					visit[nx][ny] =1;
					queue.offer(new int[] {nx,ny});
					count++;
				}
			}		
		}
		return count;
	}
}
