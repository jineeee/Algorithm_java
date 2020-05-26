package week2;

import java.util.*;

/*
 * 백준 치킨배달 - 배열, 리스트 다루기
 * https://www.acmicpc.net/problem/15686
 */

class Point{
	int x,y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
}
public class BOJ15686 {
	static int n, m, result=9999;
	static int[][] map;
	static List<Point> home = new LinkedList<Point>();
	static List<Point> chickenList = new ArrayList<Point>();
	static Point[] chickenChoice;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		map = new int[n][n];
		chickenChoice = new Point[m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = scanner.nextInt();
				if(map[i][j]==1) home.add(new Point(i, j));
				if(map[i][j]==2) chickenList.add(new Point(i, j));
			}
		}
		combi(0, 0);
		System.out.print(result);
	}
	
	static void combi(int current, int start) {
		if(m==current) {
			result = Math.min(getDist(chickenChoice), result);
		}else {
			for(int i=start; i<chickenList.size(); i++) {
				chickenChoice[current] = chickenList.get(i);
				combi(current+1, i+1);
			}
		}
	}
	
	static int getDist(Point[] chicken) {
		int cityChickDist = 0;
		for(int i=0; i<home.size(); i++) {
			int minChickDist = 9999;
			for(int j=0; j<m; j++) {
				int temp = Math.abs(home.get(i).x - chicken[j].x) + Math.abs(home.get(i).y - chicken[j].y);
				minChickDist = Math.min(temp, minChickDist);
			}
			cityChickDist += minChickDist;
		}
		return cityChickDist;
	}
}
