import java.io.*;
import java.util.*;

/*
 * 백준 - 투포인터 알고리즘
 * https://www.acmicpc.net/problem/2470
 */

public class BOJ2470 {
	
	static int n, ans1, ans2;
	static int arr[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
		n = Integer.parseInt(st.nextToken());
		arr = new int[n];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		solution();
		System.out.println(ans1 + " " + ans2);
	}
	
	static void solution() {
		int start = 0, end = n-1, max = Integer.MAX_VALUE;
		
		while(start<end) {
			int sum = arr[start] + arr[end];
			
			if(Math.abs(sum)<=max) {
				ans1 = arr[start];
				ans2 = arr[end];
				max = Math.abs(sum);
			}
			
			if(sum<0) start++;
			else if(sum>0) end--;
			else break;
		}
	}

}
