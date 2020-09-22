package week03;

import java.util.*;

/* 백준 나무재테크 - linkedList
 * https://www.acmicpc.net/problem/16235
 */

class Tree implements Comparable<Tree>{
	int x, y, age, death;
	public Tree(int x, int y, int age, int death) {
		this.x = x;
		this.y = y;
		this.age = age;
		this.death = death; // 1은 산거, 0은 죽은거
	}
	@Override
	public int compareTo(Tree o) {
		return Integer.compare(age, o.age);
	}
}

public class BOJ16235 {
	static int n, m, k;
	static int[][] map, yang;
	static List<Tree> trees = new LinkedList<Tree>();
	static List<Tree> newTrees = new LinkedList<Tree>();
	static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		m = scanner.nextInt();
		k = scanner.nextInt();
		map = new int[n][n];
		yang = new int[n][n];
		for(int i=0; i<n; i++)
			for(int j=0; j<n; j++) {
				map[i][j] = 5;
				yang[i][j]=scanner.nextInt();
			}
		for(int i=0; i<m; i++) {
			int x = scanner.nextInt()-1;
			int y = scanner.nextInt()-1;
			trees.add(new Tree(x, y, scanner.nextInt(), 1));
		}
		
		for(int i=0; i<k; i++) {
			trees.sort(null);
			
			// 봄
			for(Tree t : trees) {
				if(map[t.x][t.y]>=t.age) {
					map[t.x][t.y] -= t.age;
					t.age++;
				}else t.death = 0;
			}
			
			//여름
			Iterator<Tree> it = trees.iterator();
			while(it.hasNext()) {
				Tree t = it.next();
				if(t.death==0) {
					map[t.x][t.y] += t.age/2;
					it.remove();
				}
			}

			//가을
			for(Tree t : trees) {
				if(t.age%5==0) {
					for(int j=0; j<8; j++) {
						int nx = t.x + dx[j];
						int ny = t.y + dy[j];
						if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
						newTrees.add(new Tree(nx, ny, 1, 1));
					}
				}
			}
			trees.addAll(0,newTrees);
			newTrees.clear();
			
			if(i==k-1) {
				System.out.print(trees.size());
				break;
			}
			
			//겨울
			for(int p=0; p<n; p++) {
				for(int q=0; q<n; q++) {
					map[p][q] += yang[p][q];
				}
			}
		}
	}
}
