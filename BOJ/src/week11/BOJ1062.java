package week11;

import java.util.*;

/*
 * 문자열
 * https://www.acmicpc.net/problem/1062
 */

public class BOJ1062 {
	static String[] words;
	static boolean[] visit = new boolean[26];
	static int N, K, ans = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();

		if (K < 5) {
			System.out.print(0);
			return;
		} else if (K == 26) {
			System.out.print(N);
			return;
		}

		words = new String[N];

		for (int i = 0; i < N; i++) {
			String input = sc.next();
			String word = input.substring(4, input.length() - 4);
			words[i] = word;
		}

		visit['a' - 'a'] = true;
		visit['n' - 'a'] = true;
		visit['t' - 'a'] = true;
		visit['i' - 'a'] = true;
		visit['c' - 'a'] = true;

		check(0, 0);
		System.out.print(ans);
	}

	static void check(int start, int count) {
		if (count == K - 5) {
			int cnt = 0;
			for (int i = 0; i < words.length; i++) {
				String word = words[i];

				boolean flag = true;
				for (int j = 0; j < word.length(); j++) {
					char c = word.charAt(j);
					if (!visit[c - 'a'])
						flag = false;
				}
				if (flag)
					cnt++;
			}
			// System.out.println(cnt);
			ans = Math.max(ans, cnt);
		} else {
			for (int i = start; i < 26; i++) {
				if (visit[i])
					continue;
				visit[i] = true;
				check(i + 1, count + 1);
				visit[i] = false;
			}
		}
	}
}
