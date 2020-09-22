package week01;

import java.io.*;
import java.util.*;

/*
 * 개수 세기 - 배열 탐색
 * https://www.acmicpc.net/problem/10807
 */

public class BOJ10807 {
	static int N, target, count;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int[] arr = new int[N];
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		target = sc.nextInt();
		for(int i=0; i<arr.length; i++) {
			if(target == arr[i]) count++;
		}
		
		System.out.print(count);
	}
}
