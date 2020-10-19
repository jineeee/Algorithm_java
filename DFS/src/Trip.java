import java.util.*;

/*
 * 여행경로 - dfs
 * https://programmers.co.kr/learn/courses/30/lessons/43164
 */

public class Trip {

	static ArrayList<String> trip = new ArrayList<String>();

	public String[] solution(String[][] tickets) {
		boolean[] visit = new boolean[tickets.length];
		for (int i = 0; i < tickets.length; i++) {
			if (tickets[i][0].equals("ICN")) {
				visit[i] = true;
				StringBuilder sb = new StringBuilder();
				sb.append("ICN " + tickets[i][1]);
				dfs(tickets[i][1], i, visit, tickets, sb.toString(), 1);
				visit[i] = false;
			}
		}
		Collections.sort(trip);
		String[] answer = trip.get(0).split(" ");

		return answer;
	}

	static void dfs(String now, int idx, boolean[] visit, String[][] tickets, String result, int cnt) {
		if (cnt == tickets.length) {
			trip.add(result);
			return;
		} else {
			for (int i = 0; i < tickets.length; i++) {
				if (visit[i])
					continue;
				String tempFrom = tickets[i][0];
				if (tempFrom.equals(now)) {
					visit[i] = true;
					dfs(tickets[i][1], i, visit, tickets, result + " " + tickets[i][1], cnt + 1);
					visit[i] = false;
				}
			}
		}
	}
}
