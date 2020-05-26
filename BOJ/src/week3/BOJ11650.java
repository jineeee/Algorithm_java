package week3;

import java.util.*;

/*
 * 백준 좌표 정렬하기 - comparable 사용하기
 * https://www.acmicpc.net/problem/11650
 */

class Dot implements Comparable<Dot>{
	int x, y;
	public Dot(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Dot o) {
		if(x==o.x) return Integer.compare(y, o.y);
		else return Integer.compare(x, o.x);
	}
}

public class BOJ11650 {
	static int n;
	static Dot[] arr;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		arr = new Dot[n];
		for(int i=0; i<n; i++) 
			arr[i] = new Dot(scanner.nextInt(), scanner.nextInt());
		Arrays.sort(arr);
		for(Dot d:arr) 
			System.out.println(d.x + " " + d.y);
	}
}
