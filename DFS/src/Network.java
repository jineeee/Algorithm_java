
/*
 * 네트워크 - dfs, blob 구하기
 * https://programmers.co.kr/learn/courses/30/lessons/43162
 */

public class Network {

	static boolean[] visit;

	public int solution(int n, int[][] computers) {
		int answer = 0;
		visit = new boolean[n];
		for (int i = 0; i < n; i++) {
			if (visit[i])
				continue;
			answer++;
			dfs(computers, i);
		}
		return answer;
	}

	static void dfs(int[][] com, int c) {
		visit[c] = true;
		for (int i = 0; i < com.length; i++) {
			if (visit[i] || com[c][i] == 0)
				continue;
			dfs(com, i);
		}
	}

}
