package week4;

import java.util.*;

/* 백준 일곱 난쟁이 - 조합
 * https://www.acmicpc.net/problem/2309
 */

public class BOJ2309 {
	static int[] nan = new int[9];
	static Integer[] result = new Integer[7];
	static boolean flag;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<9; i++) nan[i] = scanner.nextInt();
		combi(0, 0);
	}
	
	static void combi(int current, int start) {
		if(flag) return;
		if(current == 7) {
			int temp = 0;
			for(int i:result) temp += i;
			if(temp==100) {
				Arrays.sort(result);
				for(int i:result) System.out.println(i);
				flag = true;
			}
		}else {
			for(int i=start; i<nan.length; i++) {
				result[current] = nan[i];
				combi(current+1, i+1);
			}
		}
	}
}
