import java.util.*;

/*
 * 백준 좋은수열 = 백트래킹
 * https://www.acmicpc.net/problem/2661
 */

public class BOJ2661 {
	static int n, start=1, end=3;
	static int[] result;
	static int print = 1;
	static boolean flag = false;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		result = new int[n];
		combi("");
	}
	
	static void combi(String result) {
		if(flag) return;
		if(result.length()==n) {
			System.out.println(result);
			flag = true;
		}else {
			for(int i=start; i<=end; i++) {
				if(check(result+i)) // 좋은 수열인지 검사를 한 후 재귀 진행
					combi(result+i);
			}
		}
	}
	
	static boolean check(String string) {
		int len = string.length();
		// 최근에 추가된 마지막 숫자만 앞과 비교해주면 되므로 뒤부터 잘라가면서 비교
		for(int i=1; i<=len/2; i++) { // 비교할 문자열의 길이
			String front_str = string.substring(string.length()-i); // 문자열의 뒤부터 1,2,3...씩 잘라가며 비교 수행
            String behind_str = string.substring(string.length()-i*2, string.length()-i);
            
            if(front_str.equals(behind_str)) return false;
		}
		return true;
	}

}
