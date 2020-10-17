package week10;

import java.util.*;
import java.lang.*;
import java.io.*;

/*
 * dp - 부분합
 * https://www.acmicpc.net/problem/3020
 */

public class BOJ3020 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int h = Integer.parseInt(temp[1]);
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		solution(n, h, arr);
	}

	// N : 동굴의 길이 , H : 동굴의 높이
	static public void solution(int N, int H, int[] arr) {
		int[] top = new int[H + 1];
		int[] bottom = new int[H + 1];
		int[] topSum = new int[H + 1];
		int[] bottomSum = new int[H + 1];

		for (int i = 0; i < arr.length; i++) {
			if (i % 2 == 0)
				bottom[arr[i]]++;
			else
				top[arr[i]]++;
		}

		topSum[H] = top[H];
		bottomSum[H] = bottom[H];
		for (int i = H - 1; i >= 1; i--) {
			topSum[i] = topSum[i + 1] + top[i];
			bottomSum[i] = bottomSum[i + 1] + bottom[i];
		}

		int min = Integer.MAX_VALUE, cnt = 0;
		for (int i = 1; i <= H; i++) {
			min = Math.min(min, topSum[i] + bottomSum[H - i + 1]);
		}
		for (int i = 1; i <= H; i++) {
			if (min == topSum[i] + bottomSum[H - i + 1])
				cnt++;
		}
		System.out.println(min + " " + cnt);
	}

}
