import java.util.*;

/*
 * 백준 색칠하기 - 그래프 탐색
 * https://www.acmicpc.net/problem/13265
 */

public class BOJ13265 {
	static int T, N, M;
	static LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
	static int[] color;
	static boolean[] visit;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		T = scanner.nextInt();
		while (T-- > 0) {
			list.clear();
			queue.clear();
			N = scanner.nextInt();
			color = new int[N + 1];
			visit = new boolean[N + 1];
			for (int i = 0; i <= N; i++)
				list.add(new LinkedList<Integer>());
			M = scanner.nextInt();
			for (int i = 0; i < M; i++) {
				int a = scanner.nextInt();
				int b = scanner.nextInt();
				list.get(a).add(b);
				list.get(b).add(a);
			}
			queue.offer(1);
			color[1] = 1;
			visit[0] = visit[1] = true;
			System.out.println(getResult());
		}
	}

	static String getResult() {
		while (true) {
			int cnt = 0;
			while (!queue.isEmpty()) {
				int now = queue.poll();
				
				if(list.get(now).size()==0) {
					visit[now] = true;
					continue;
				}
				
				for (int i = 0; i < list.get(now).size(); i++) {
					int next = list.get(now).get(i);
					
					if (color[next] != 0 && color[now] == color[next])
						return "impossible";
					
					else if (color[next] == 0) {
						if (color[now] == 1)
							color[next] = 2;
						else
							color[next] = 1;
						queue.offer(next);
						visit[next] = true;
					}
				}
			}
			
			for (int i = 0; i < visit.length; i++) {
				if (!visit[i]) {
					queue.offer(i);
					cnt++;
				}
			}
			if (cnt == 0)
				break;
		}
		return "possible";
	}
}
