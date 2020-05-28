

import java.util.*;

/*
 * 백준 로또 - 조합, 재귀
 * https://www.acmicpc.net/problem/6603
 */

public class BOJ6603 {
	static int k;
	static int[] arr;
	static int[] result = new int[6];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			k = scanner.nextInt();
			arr = new int[k];
			for(int i=0; i<k; i++) arr[i] = scanner.nextInt();
			combi(0, 0);
			System.out.println();
			
			if(k==0) {
				scanner.close();
				break;
			}
		}	
	}
	
	static void combi(int current, int start) {
		if(current==6) {
			for(int i:result) System.out.print(i + " ");
			System.out.println();
		}else {
			for(int i=start; i<arr.length; i++) {
				result[current] = arr[i];
				combi(current+1, i+1);
			}
		}
	}
}
