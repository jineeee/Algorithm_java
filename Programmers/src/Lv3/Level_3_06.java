package Lv3;

import java.util.*;

/*
 * 우선순위 큐
 * https://programmers.co.kr/learn/courses/30/lessons/42627#
 */

public class Level_3_06 {

	public static void main(String[] args) {
		int[][] arr = { { 0, 3 }, { 1, 9 }, { 2, 6 } };
		solution(arr);
	}

	static public int solution(int[][] jobs) {
		Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] i1, int[] i2) {
				if (i1[0] == i2[0])
					return Integer.compare(i1[1], i2[1]);
				return Integer.compare(i1[0], i2[0]);
			}
		});

		int answer = jobs[0][0];
		ArrayList<Integer> list = new ArrayList<>();
		boolean[] check = new boolean[jobs.length];

		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(answer + jobs[0][1]);
		list.add(answer + jobs[0][1] - jobs[0][0]);
		check[0] = true;

		int cnt = 1;

		while (cnt < jobs.length) {
			answer++;

			if (queue.size() == 1)
				if (queue.peek() == answer)
					queue.poll();

			if (queue.size() == 0) {
				PriorityQueue<Disk> pq = new PriorityQueue<Disk>();
				for (int i = 0; i < jobs.length; i++) {
					if (check[i])
						continue;

					if (jobs[i][0] <= answer) {
						pq.offer(new Disk(i, answer + jobs[i][1]));
					}
				}
				if (pq.size() >= 1) {
					queue.offer(pq.peek().sec);
					check[pq.peek().idx] = true;
					list.add(pq.peek().sec - jobs[pq.peek().idx][0]);
					cnt++;
				}
			}
		}
		int sum = 0;
		for (int i : list) sum += i;
		answer = sum / jobs.length;
		return answer;
	}

	static class Disk implements Comparable<Disk> {
		int idx, sec;

		public Disk(int idx, int sec) {
			this.idx = idx;
			this.sec = sec;
		}

		@Override
		public int compareTo(Disk d1) {
			return Integer.compare(sec, d1.sec);
		}
	}
}
