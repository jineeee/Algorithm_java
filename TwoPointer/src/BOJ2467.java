import java.io.*;

/*
 * 투포인터
 * https://www.acmicpc.net/problem/2467
 */

public class BOJ2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] temp = br.readLine().split(" ");
		int n = Integer.parseInt(temp[0]);
		int[] arr = new int[n];
		temp = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(temp[i]);
		}
		solution(n, arr);
	}

	static public void solution(int N, int[] arr) {
		int s = 0, e = N - 1;
		int idx1 = 0, idx2 = 0;
		int min = 2000000000;

		while (s < e) {
			int sum = arr[s] + arr[e];
			if (Math.abs(sum) <= min) {
				min = Math.abs(sum);
				idx1 = s;
				idx2 = e;
			}

			if (sum < 0) {
				s++;
			} else if (sum > 0) {
				e--;
			} else if (sum == 0)
				break;
		}

		System.out.print(arr[idx1] + " " + arr[idx2]);
	}
}
