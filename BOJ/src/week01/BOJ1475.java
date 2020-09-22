package week01;

import java.util.Scanner;

public class BOJ1475 {
	static int[] num = new int[10];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String N = scanner.next();
		for(int i=0; i<N.length(); i++) {
			int idx = Integer.parseInt(N.substring(i,i+1));
			if(idx==6 || idx==9) num[6]+=1;
			else num[idx] += 1;
		}
		int max = -1;
		num[6] = num[6]/2 + num[6]%2;
		for(int i=0; i<9; i++) {
			max = Math.max(max, num[i]);
		}
		System.out.print(max);		
	}
}
