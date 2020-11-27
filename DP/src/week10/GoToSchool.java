package week10;

/*
 * dp - 등굣길
 * https://programmers.co.kr/learn/courses/30/lessons/42898
 */

public class GoToSchool {
	public static void main(String[] args) {
		solution(4, 3, new int[][] {{2,2}});
	}
	
	static public int solution(int m, int n, int[][] puddles) {
        int[][] dp = new int[n+1][m+1];
        for(int k=0; k<puddles.length; k++){
            dp[puddles[k][1]][puddles[k][0]] = -1;
        }
        
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                if(dp[i][j]==-1) continue;
                else if((i==1&&j==2) || (i==2&&j==1)){
                    dp[i][j] = 1;
                    continue;
                }else{
                    dp[i][j] = ((dp[i][j-1]==-1?0:dp[i][j-1]) + (dp[i-1][j]==-1?0:dp[i-1][j]))%1000000007;
                }
            }
        }
        return dp[n][m];
    }

}
