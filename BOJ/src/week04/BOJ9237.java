package week04;

import java.util.*;

/*
 * 백준 이장님 초대 - 정렬
 * https://www.acmicpc.net/problem/9237
 */

public class BOJ9237 {
	static int n, max;
	static Integer[] tree;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		tree = new Integer[n];
		for(int i=0; i<n; i++) {
			tree[i] = scanner.nextInt();
		}
		Arrays.sort(tree, Collections.reverseOrder());
		for(int i=0; i<tree.length; i++) {
			tree[i] = tree[i] + i + 1;
			max = Math.max(tree[i], max);
		}
		System.out.println(max+1);
	}
}
