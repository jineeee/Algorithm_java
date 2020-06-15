package week6;

import java.util.*;

/*
 * 백준 1만들기 - dp
 * https://www.acmicpc.net/problem/1463
 */

public class BOJ1463 {
	static int[] d;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int number = scanner.nextInt();
		d = new int[number+1];
	    System.out.println(calculate(number));
	}
	
	public static int calculate(int number){
        if (number == 1){
            return 0;
        }
        if (d[number] > 0){
            return d[number];
        }
        d[number] = calculate(number-1) + 1;
        if (number%3 == 0) {
            d[number] = Math.min(d[number],calculate(number/3) +1);
        }
        if (number%2 == 0) {
            d[number] = Math.min(d[number],calculate(number/2) +1);
        }
        return d[number];
    }
}
