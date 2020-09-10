import java.util.*;

/*
 * 백준 - 순열
 * https://www.acmicpc.net/problem/10819
 */

public class BOJ10819 {

	static int[] arr;
	static boolean[] visit;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		arr = new int[n];
		visit = new boolean[n];
		for(int i=0; i<n; i++) arr[i] = scanner.nextInt();
		
		permu(n, new int[n], 0);
		System.out.print(max);
	}
	
	static void permu(int n, int[] result, int current) {
		if(current==n) {
			sum(result);
		}else {
			for(int i=0; i<arr.length; i++) {
				if(visit[i]) continue;
				
				result[current] = arr[i];
				visit[i] = true;
				permu(n, result, current+1);
				visit[i] = false;
			}
		}
	}
	
	static void sum(int[] result) {
		int sum = 0;
		for(int i=1; i<result.length; i++) {
			sum += Math.abs(result[i]-result[i-1]);
		}
		max = Math.max(sum, max);
	}
}
