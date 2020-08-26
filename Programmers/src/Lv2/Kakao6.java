package Lv2;

/* 카카오 프렌즈4블록 
 * https://programmers.co.kr/learn/courses/30/lessons/17679
 */

public class Kakao6 {

	public static void main(String[] args) {
		String[] arr = { "CCBDE", "AAADE", "AAABF", "CCBBF" };
		solution(4, 5, arr);
	}

	static int M, N;
	static String[][] map;
	static boolean[][] bool;

	public static int solution(int m, int n, String[] board) {
		int answer = 0;

		M = m;
		N = n;
		map = new String[m][n];
		for (int i = 0; i < m; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = String.valueOf(board[i].charAt(j));

		while (true) {
			bool = new boolean[m][n];

			for (int i = 0; i < m - 1; i++)
				for (int j = 0; j < n - 1; j++)
					if (!map[i][j].isEmpty())
						checkFour(i, j);

			int cnt = 0;
			for (int i = 0; i < m; i++)
				for (int j = 0; j < n; j++)
					if (bool[i][j]) {
						cnt++;
						map[i][j] = "";
					}

			if (cnt == 0)
				break;
			answer += cnt;

			moveBlock();
		}

		System.out.println(answer);
		return answer;
	}

	static void moveBlock() {
		for (int j = 0; j < N; j++) {
			String temp = "";

			for (int i = M - 1; i >= 0; i--) {
				if (!map[i][j].isEmpty())
					temp += map[i][j];
				map[i][j] = "";
			}
			
			for (int i = 0; i < temp.length(); i++) {
					map[M-i-1][j] = String.valueOf(temp.charAt(i));
			}
		}
	}

	static void checkFour(int x, int y) {
		if (map[x][y].equals(map[x][y + 1]) && map[x][y].equals(map[x + 1][y]) && map[x][y].equals(map[x + 1][y + 1]))
			bool[x][y] = bool[x + 1][y] = bool[x][y + 1] = bool[x + 1][y + 1] = true;
	}
}
