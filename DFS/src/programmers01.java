
public class programmers01 {
	public static void main(String[] args) {
		solution(2, 11);
	}

	static int answer = 9;

	static public int solution(int N, int number) {
		dfs(N, number, 0, 0);
		return answer > 8 ? -1 : answer;
	}

	static void dfs(int N, int number, int result, int cnt) {
		if (cnt > 8)
			return;
		if (result == number) {
			answer = Math.min(answer, cnt);
			return;
		}
		// i는 숫자를 이어붙힐 때 쓸 개수
		// 8번 이상 쓰는 것은 탐색하지 않음
		for (int i = 1; i <= 8 - cnt; i++) {
			dfs(N, number, result + getNum(N, i), cnt + i);
			dfs(N, number, result - getNum(N, i), cnt + i);
			dfs(N, number, result / getNum(N, i), cnt + i);
			dfs(N, number, result * getNum(N, i), cnt + i);
		}
	}

	static int getNum(int N, int n) {
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += Math.pow(10, i) * N;
		}
		return result;
	}
}
