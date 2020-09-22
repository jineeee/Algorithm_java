package week01;

import java.util.*;

/*
 * 백준 치킨쿠폰 - EOF
 * https://www.acmicpc.net/problem/1673
 */

public class BOJ1673 {

	public static void main(String[] args) {
		List<Integer> ans = new ArrayList<Integer>();
		
		Scanner sc = new Scanner(System.in);
		while (sc.hasNextInt()) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int count = n;
			while (n/k > 0) {
				count += n/k;
				n = n/k + n%k;
			}
			ans.add(count);
			System.out.println(count);
		}
	}
}
