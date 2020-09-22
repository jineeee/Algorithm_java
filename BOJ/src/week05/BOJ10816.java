package week05;

import java.util.Scanner;

/* 
 * 백준 숫자카드2 - 배열, StringBuilder
 * https://www.acmicpc.net/problem/10816
 */

public class BOJ10816 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int N = scanner.nextInt();
		int[] card = new int[20000001]; // 숫자 범위가 -10000000~10000000
		for(int i=0; i<N; i++)
			card[scanner.nextInt()+10000000]++;
		int M = scanner.nextInt();
		for(int i=0; i<M; i++)
			sb.append(card[scanner.nextInt()+10000000] + " ");
		System.out.print(sb);
	}
}
