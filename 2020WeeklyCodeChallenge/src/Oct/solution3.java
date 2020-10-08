package Oct;

import java.util.*;

public class solution3 {
	
	public static void main(String[] args) {
		int[][] arr = {{1,2},{2,3},{3,4}};
		int[][] arr2 = {{1,5},{2,5},{3,5},{4,5}};
		solution(4, arr);
		solution(5, arr2);
	}
	
	static int[][] map;
	static int answer = 0, maxDist = 0;
	
	static public int solution(int n, int[][] edges) {
        map = new int[n+1][n+1];
        
        for(int i=1; i<=n; i++) {
        	for(int j=1; j<=n; j++) {
        		if(i==j) continue;
        		map[i][j] = 250000;
        	}
        }
        
        for(int i=0; i<edges.length; i++) map[edges[i][0]][edges[i][1]] = map[edges[i][1]][edges[i][0]] = 1;

        floyd(n);
//        combi(0, n, new int[3], 1);
//        for(int i=1; i<=n; i++)System.out.println(Arrays.toString(map[i]));
        
        LinkedList<Integer> list = new LinkedList<Integer>();
        for(int i=1; i<=n; i++) {
        	for(int j=i+1; j<=n; j++) {
        		list.add(map[i][j]);
        	}
        }
        Collections.sort(list, Comparator.reverseOrder());
        answer = list.get(1);
//        System.out.println(answer);
        return answer;
    }
	
	static boolean flag = false;
	static void combi(int current, int n, int[] result, int start) {
		if(flag) return;
		if (current == 3) {
			int[] temp = new int[3];
			temp[0] = map[result[0]][result[1]];
			temp[1] = map[result[1]][result[2]];
			temp[2] = map[result[0]][result[2]];
			if(temp[0]==maxDist && temp[1]==maxDist && temp[2]==maxDist) {
				answer = maxDist;
				flag = true;
				return;
			}
			Arrays.parallelSort(temp);
			answer = Math.max(answer, temp[1]);
		} else {
			for (int i = start; i <= n; i++) {
				result[current] = i;
				combi(current + 1, n, result, i + 1);
			}
		}
	}

	static void floyd(int N) {
		for(int k=1; k<=N; k++) {
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if(i==j) continue;
 					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					maxDist = Math.max(maxDist, map[i][j]);
				}
			}
		}
	}
}
