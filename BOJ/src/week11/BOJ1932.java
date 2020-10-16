package week11;
import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * dp - 점화식
 * https://www.acmicpc.net/problem/1932
 */

public class BOJ1932 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    int n = Integer.parseInt(br.readLine());
	    int[][] arr = new int[n][n];
	    for(int i=0; i<n; i++){
	      String[] temp = br.readLine().split(" ");
	      for(int j=0; j<temp.length; j++){
	        arr[i][j] = Integer.parseInt(temp[j]);
	      }
	    }
	    // System.out.println(Arrays.toString(arr));
	    solution(n, arr);
	  }
	  
	  static public void solution(int n, int[][] arr){
	    int[][] dp = new int[n][n];
	    dp[0][0] = arr[0][0];
	    for(int i=1; i<n; i++){
	      for(int j=0; j<=i; j++){
	        if(j==0){
	          dp[i][j] = dp[i-1][j] + arr[i][j];
	        } else if(j==i){
	          dp[i][j] = dp[i-1][j-1] + arr[i][j];
	        }else{
	          dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + arr[i][j];
	        }
	      }
	    }

	    int ans = 0;
	    for(int i=0; i<n; i++){
	      ans = Math.max(ans, dp[n-1][i]);
	    }
	    System.out.print(ans);
	  }
}
