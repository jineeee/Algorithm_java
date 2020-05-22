package week2;

import java.util.*;

/*
 * 백준 요세푸스 문제 - list 탐색
 * https://www.acmicpc.net/problem/1158
 */

public class BOJ1158 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int k = scanner.nextInt();
		int target = k-1, start;
		List<Integer> list = new ArrayList<Integer>();
		List<Integer> result = new ArrayList<Integer>();
		for(int i=1; i<=n; i++) list.add(i);
		result.add(list.get(target));
		list.remove(target);
		while (!list.isEmpty()) {
			start = target%list.size();
			target = (start+k-1)%list.size();
			result.add(list.get(target));
			list.remove(target);
		}
		System.out.print("<");
		for(int i=0; i<result.size(); i++) {
			if(i==result.size()-1) System.out.print(result.get(i));
			else System.out.print(result.get(i) + ", ");
		}
		System.out.print(">");
	}
}
