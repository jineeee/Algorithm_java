package week05;

import java.util.*;

/*
 * 백준 다이얼 - 문자열 다루기
 * https://www.acmicpc.net/problem/5622
 */

public class BOJ5622 {
	static String temp;
	static int ans;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		temp = scanner.next();
		char[] arr = temp.toCharArray();
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>=65 && arr[i]<=67) {
				ans += 3;
			} else if(arr[i]>=68 && arr[i]<=70) {
				ans += 4;
			} else if(arr[i]>=71 && arr[i]<=73) {
				ans += 5;
			} else if(arr[i]>=74 && arr[i]<=76) {
				ans += 6;
			} else if(arr[i]>=77 && arr[i]<=79) {
				ans += 7;
			} else if(arr[i]>=80 && arr[i]<=83) {
				ans += 8;
			} else if(arr[i]>=84 && arr[i]<=86) {
				ans += 9;
			} else {
				ans += 10;
			}
		}
		System.out.println(ans);
	}
}
