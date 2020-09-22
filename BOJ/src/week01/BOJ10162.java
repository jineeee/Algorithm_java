package week01;

import java.util.Scanner;

public class BOJ10162 {
	static int A = 5*60;
	static int B = 1*60;
	static int C = 10;
	static int countA = 0;
	static int countB = 0;
	static int countC = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T >= A) {
			T-=A;
			countA++;
		}
		while (T >= B) {
			T-=B;
			countB++;
		}
		while (T >= C) {
			T-=C;
			countC++;
		}
		if(T!=0) System.out.print(-1);
		else System.out.print(countA + " " + countB + " " + countC);
	}
}
