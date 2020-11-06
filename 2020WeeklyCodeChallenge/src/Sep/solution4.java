package Sep;

import java.util.ArrayList;

public class solution4 {
	
	public static void main(String[] args) {
		int[][] arr = {{0,1,0},{1,1,1},{1,1,0},{0,1,1}};
		solution(arr);
	}
	
	static int[][] b;
	
	static int solution(int[][] a) {
        int answer = -1;
        b = new int[a.length][a[0].length];
        
        ArrayList<Integer> oneCnt = new ArrayList<Integer>();
        for(int j=0; j<a[0].length; j++) {
        	int rowOneCnt = 0;
        	for(int i=0; i<a.length; i++) {
        		if(a[i][j]==1) rowOneCnt++;
        	}
        	oneCnt.add(rowOneCnt);
        }
        
        System.out.println(oneCnt);
        return answer;
    }

}
