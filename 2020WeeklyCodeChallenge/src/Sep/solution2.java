package Sep;

import java.util.*;

public class solution2 {
	
	public static void main(String[] args) {
		solution(4);
	}
	
	static ArrayList<int[]> list = new ArrayList<int[]>();

	static int[] solution(int n) {
        
        int limit = n;
        for(int i=1; i<=n; i++) list.add(new int[i]);
        
        int num = 1, dir = 1, col=-1, row=0;
        
        while (limit>=0) {
        	
        	// 세로 아래
			for(int i=0; i<limit; i++) {
				col += dir;
				if(list.get(col)[row]==0) {
					list.get(col)[row] = num++;
				}
			}
			limit--;
			
			// 오른쪽 가로
			for(int i=0; i<limit; i++) {
				row += dir;
				if(list.get(col)[row]==0) {
					list.get(col)[row] = num++;
				}
			}
			
			limit--;
			dir*=-1;
			
			// 세로 위
			for(int i=0; i<limit; i++) {
				col += dir;
				row += dir;
				if(col<0 || row<0 || col>=n || row>=n) break;
				if(list.get(col)[row]==0) {
					list.get(col)[row] = num++;
				}
			}
			
			limit--;
			dir *= -1;
		}
        
        int len = 0;
        for(int i=1; i<=n; i++) len += i;
        int[] answer = new int[len];
        
        int idx = 0;
        for(int i=0; i<list.size(); i++) {
        	for(int j=0; j<list.get(i).length; j++) {
        		answer[idx++] = list.get(i)[j];
        	}
        }
        return answer;
    }
	
}
