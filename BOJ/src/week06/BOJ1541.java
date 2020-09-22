package week06;

import java.util.*;

/*
 * 백준 잃어버린 괄호 - 문자열
 * https://www.acmicpc.net/problem/1541
 */

public class BOJ1541 {
	static String input;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		input = scanner.next();
		String[] strings = input.split("\\-");
		int ans=0;
		for(int i=0; i<strings.length; i++) {
			int result = clac(strings[i]);
			
			if(i==0) ans += result;
			else ans -= result;
		}
		System.out.print(ans);
	}
	
	static int clac(String string) {
		String[] strings = string.split("\\+");
		int result = 0;
		for(String string2 : strings) result += Integer.parseInt(string2);
		return result;
	}
}
