import java.util.ArrayList;

/*
 * 단어변환 - dfs
 * https://programmers.co.kr/learn/courses/30/lessons/43163
 */

public class Words {

	public static void main(String[] args) {
		String[] arr = { "hot", "dot", "dog", "lot", "log", "cog" };
		solution("hit", "cog", arr);
	}

	static int ans = 51;

	static public int solution(String begin, String target, String[] words) {
		int answer = 0;
		boolean flag = true;
		for (String w : words)
			if (w.equals(target))
				flag = false;
		if (flag)
			return 0;

		dfs(words, begin, target, 0, new boolean[words.length]);

		return ans;
	}

	static void dfs(String[] words, String now, String target, int cnt, boolean[] visit) {
		if (now.equals(target)) {
			ans = Math.min(ans, cnt);
		} else {
			for (int i = 0; i < words.length; i++) {
				String s = words[i];
				if (s.equals(now) || visit[i])
					continue;

				int temp = 0;
				for (int j = 0; j < s.length(); j++) {
					if (s.charAt(j) != now.charAt(j))
						temp++;
				}
				if (temp == 1) {
					visit[i] = true;
					dfs(words, s, target, cnt + 1, visit);
					visit[i] = false;
				}
			}
		}
	}

}
