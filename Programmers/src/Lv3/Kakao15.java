package Lv3;

import java.util.*;

/*
 * 프렌즈 사천성 - bfs 이용해서 푼 버전, 테스트케이스만 다 통과..
 * https://programmers.co.kr/learn/courses/30/lessons/1836
 */

public class Kakao15 {
	
	public static void main(String[] args) {
		String[] arr = {"DBA", "C*A", "CDB"};
		String[] arr2 = {"NRYN", "ARYA"};
		String[] arr3 = {".ZI.", "M.**", "MZU.", ".IU."};
		String[] arr4 = {"AB", "BA"};
		solution(4, 4, arr3);
	}

	static String[][] map;
	static ArrayList<String> alph = new ArrayList<String>();
	static int len, M, N;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	
	static String solution(int m, int n, String[] board) {
        String answer = "";
        map = new String[m][n];
        M = m;
        N = n;
        for(int i=0; i<m; i++) {
        	String[] temp = board[i].split("");
        	for(int j=0; j<n; j++) {
        		map[i][j] = temp[j];
        		if(map[i][j].equals(".") || map[i][j].equals("*") || alph.contains(map[i][j])) continue;
        		alph.add(map[i][j]);
        	}
        }
//        for(int i=0; i<m; i++) {
//        	for(int j=0; j<n; j++) {
//        		System.out.print(map[i][j] + " ");
//        	}System.out.println();
//        }System.out.println();
        
        len = alph.size();
        
        // 첫번째 for문, 타일의 종류만큼 진행
        for(int i=0; i<len; i++) {
        	Collections.sort(alph);
        	// 두번째 for문, 현재 남은 타일을 순회하며 진행
        	for(int j=0; j<alph.size(); j++) {
        		String target = alph.get(j);
        		
        		if(bfs(alph.get(j))) {
        			answer += alph.get(j);
        			alph.remove(j);
        			copyMap(target);
        			break;
        		}
        	}
        }
        
        if(answer.length()!=len) answer = "IMPOSSIBLE";
//        System.out.print(answer);
        return answer;
    }
	
	static boolean bfs(String target) {
		Queue<Tile> queue = new LinkedList<Tile>();
		boolean[][] visit = new boolean[M][N];
		
		// 타겟 알파벳의 좌표 하나를 찾아 담음
		outerLoop:
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++)
				if(map[i][j].equals(target)) {
					queue.offer(new Tile(i, j, -1, 0));
					visit[i][j] = true;
					break outerLoop;
				}
		}
		
		while(!queue.isEmpty()) {
			Tile nowTile = queue.poll();
//			System.out.println("nowTile -> "+nowTile.x + " " + nowTile.y + " " + nowTile.dir + " " + nowTile.curve);
			
			if(map[nowTile.x][nowTile.y].equals(target)
					&& nowTile.dir!=-1 && nowTile.curve<=1) return true;
			
			for(int i=0; i<4; i++) {
				int nx = nowTile.x + dx[i];
				int ny = nowTile.y + dy[i];
				
				if(!isValid(nx, ny) || visit[nx][ny]) continue;
				if(!map[nx][ny].equals(target) && map[nx][ny].matches("[A-Z||*]")) continue;
				
				if(nowTile.dir==-1) queue.offer(new Tile(nx, ny, i%2, 0));
				else if(nowTile.dir==i%2) queue.offer(new Tile(nx, ny, i%2, nowTile.curve));
				else queue.offer(new Tile(nx, ny, i%2, nowTile.curve+1));
				visit[nx][ny] = true;
			}
		}
		return false;
	}
	
	static boolean isValid(int x, int y) {
		return x>=0 && x<M && y>=0 && y<N;
	}
	
	static void copyMap(String target) {
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].equals(target)) map[i][j] = ".";
			}
		}
	}
	
	static class Tile{
		int x, y, dir, curve;
		
		Tile(int x, int y, int dir, int curve){
			this.x = x;
			this.y = y;
			this.dir = dir;
			this.curve = curve;
		}	
	}
}
