package week1;

import java.util.*;

public class BOJ2839 {
	static int[] arr = {3,5};
	static int maxLen;
	static int n;
	static int ans = 9999;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		int count = 0;
		while(true) {
			if(n%5==0) {
				System.out.print(n/5 + count);
				break;
			}
			if(n <0) {
				System.out.print(-1);
				break;
			}
			n -= 3;
			count++;
		}
	}
	
//	// 재귀 버전 
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		n = scanner.nextInt();
//		maxLen = n/3;
//		for(int i=1; i<=n/3; i++) {
//			int[] result = new int[i];
//			combi(i, 0, result);
//		}
//		if(ans == 9999) System.out.println(-1);
//		else System.out.println(ans);
//	}
//	
//	static void combi(int len, int current, int[] result) {
//		if(current == len) {
//			int sum = 0;
//			for(int i:result) sum+=i;
//			if(sum==n) ans = Math.min(ans, result.length);
//		}else {
//			for(int i=0; i<arr.length; i++) {
//				result[current] = arr[i];
//				combi(len, current+1, result);
//			}
//		}
//	}
}
