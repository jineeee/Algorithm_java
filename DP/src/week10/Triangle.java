package week10;

/*
 * 프로그래머스 삼각형 DP
 * https://programmers.co.kr/learn/courses/30/lessons/43105
 */

public class Triangle {
	
	public static void main(String[] args) {
		int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		solution(arr);
	}
	
	static public int solution(int[][] triangle) {
        int answer = 0;
        int len = triangle.length;
        int[][] dp = new int[len][len];
        dp[0][0] = triangle[0][0];
        
        for(int i=1; i<len; i++){
            for(int j=0; j<=i; j++){
                if(j==0) dp[i][j] = dp[i-1][j] + triangle[i][j];
                else if(j==i) dp[i][j] = dp[i-1][j-1] + triangle[i][j];
                else{
                    dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
                }
            }
        }
        for(int i=0; i<len; i++) answer = Math.max(dp[len-1][i], answer);
        return answer;
    }

}
