package Lv3;

/*
 * 카카오 보행자천국 - DP
 * https://programmers.co.kr/learn/courses/30/lessons/1832
 */

public class Kakao03_dp {
	
	public static void main(String[] args) {
		int[][] arr = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
		int[][] arr2 = 	{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}};
		solution(3, 6, arr2);
	}

	static int MOD = 20170805;
	
    public static int solution(int m, int n, int[][] cityMap) {

    	int[][] right = new int[m+1][n+1];
    	int[][] bottom = new int[m+1][n+1];
    	
    	for(int i=1; i<=m; i++) {
    		for(int j=1; j<=n; j++) {
    			if(i==1 && j==1) {
    				right[1][1] = bottom[1][1] = 1;
    				continue;
    			}
    			if(cityMap[i-1][j-1]==0) {
    				right[i][j] = (right[i][j-1] + bottom[i-1][j]) % MOD;
    				bottom[i][j] = (right[i][j-1] + bottom[i-1][j]) % MOD;
    			}else if(cityMap[i-1][j-1]==1) {
    				right[i][j] = 0;
    				bottom[i][j] = 0;
    			}else {
    				right[i][j] = right[i][j-1] % MOD;
    				bottom[i][j] = bottom[i-1][j] % MOD;
    			}
    		}
    	}
    	
        return right[m][n];
    }
}
