package week3;

import java.util.*;

/*
 * 백준 제로 - 리스트 다루기
 * https://www.acmicpc.net/problem/10773
 */

public class BOJ10773 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int idx = 0;
		for(int i=0; i<n; i++) {
			int num = scanner.nextInt();
			if(num!=0) {
				list.add(num);
				idx++;
			}
			else {
				list.remove(idx-1);
				idx--;
			}
		}
		int ans = 0;
		for(int i:list) ans+=i;
		System.out.print(ans);
	}
}
