package week01;

import java.util.Scanner;

/*
 * 백준 숫자더하기
 * https://www.acmicpc.net/problem/11720
 */

public class BOJ11720 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int num = scanner.nextInt();
		String numbers = scanner.next();
		String[] numArr = numbers.split("");
		int sum = 0;
		for(int i=0; i<numArr.length; i++) {
			sum += Integer.parseInt(numArr[i]);
		}
		System.out.print(sum);
	}

}
