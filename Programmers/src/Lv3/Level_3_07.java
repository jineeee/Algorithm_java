package Lv3;

import java.util.*;

/*
 * 이중 우선순위 큐
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 */

public class Level_3_07 {

	public int[] solution(String[] operations) {
		PriorityQueue<Integer> pq1 = new PriorityQueue<>();
		PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());

		String[][] op = new String[operations.length][2];
		for (int i = 0; i < operations.length; i++) {
			op[i] = operations[i].split(" ");
		}
		for (int i = 0; i < op.length; i++) {
			String order = op[i][0];
			int num = Integer.parseInt(op[i][1]);
			if (order.equals("I")) {
				pq1.offer(num);
				pq2.offer(num);
			} else {
				if (num == 1) {
					pq2.poll();
					pq1.clear();
					for (int n : pq2)
						pq1.add(n);
				} else {
					pq1.poll();
					pq2.clear();
					for (int n : pq1)
						pq2.add(n);
				}
			}
		}

		if (pq1.isEmpty())
			return new int[] { 0, 0 };
		else {
			int[] answer = { pq2.poll(), pq1.poll() };
			return answer;
		}
	}

}
