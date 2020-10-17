import java.io.*;

/*
 * dfs
 * https://www.acmicpc.net/problem/1987
 */

public class BOJ1987 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int r = Integer.parseInt(temp[0]);
		int c = Integer.parseInt(temp[1]);
		char[][] arr = new char[r][c];
		for (int i = 0; i < r; i++) {
			arr[i] = br.readLine().toCharArray();
			for (int j = 0; j < c; j++)
				arr[i][j] = (char) (arr[i][j] - 'A');
		}
		solution(r, c, arr);
	}

	static public void solution(int r, int c, char[][] arr) {
		dfs(arr, new boolean[26], 0, 0);
		System.out.print(answer);
	}

	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { 1, -1, 0, 0 };
	static int answer = 1, cnt = 1;

	static void dfs(char[][] arr, boolean[] visit, int x, int y) {
		int idx = arr[x][y];
		visit[idx] = true;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr[0].length)
				continue;
			int nidx = arr[nx][ny];
			if (visit[nidx])
				continue;

			answer = Math.max(answer, ++cnt);
			dfs(arr, visit, nx, ny);
		}
		visit[idx] = false;
		cnt--;
	}
}
