package week06;

import java.util.*;

/*
 * 백준 날짜계산 - dp
 * https://www.acmicpc.net/problem/1476
 */

public class BOJ1476 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int e = scanner.nextInt()-1;
		int s = scanner.nextInt()-1;
		int m = scanner.nextInt()-1;
		int year = 0;
		while(true) {
			if((year%15==e)&&(year%28==s)&&(year%19==m)) {
				System.out.print(year+1);
				break;
			}
			year++;
		}
	}
}
