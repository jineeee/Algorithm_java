package week11;

import java.util.Scanner;

/*
 * 문자열, 소수 구하기
 * https://www.acmicpc.net/problem/1747
 */

public class BOJ1747 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		solution(num);
	}

	static public void solution(int num) {
		while (true) {
			if (isPrime(num) && isSame(num)) {
				System.out.print(num);
				return;
			}
			num++;
		}
	}

	static boolean isPrime(int n) {
		if (n == 1)
			return false;
		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}

	static boolean isSame(int n) {
		char[] c = String.valueOf(n).toCharArray();
		int s = 0, e = c.length - 1;
		while (s < e) {
			if (c[s] != c[e])
				return false;
			s++;
			e--;
		}
		return true;
	}
}
