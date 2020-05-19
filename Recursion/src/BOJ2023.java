import java.util.*;

/*
 * 백준 신기한 소수 - 재귀, 소수
 * https://www.acmicpc.net/problem/2023
 */

public class BOJ2023 {
	static int n;
	static int[] result;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		result = new int[n];
		combi(0);
	}
	
	static void combi(int current) {
		if(current == n) {
			if(result[0]==1) return;
			String resultStr = "";
			for(int i: result) resultStr+=i;
			System.out.println(resultStr);
		}else {
			for(int i=1; i<=9; i++) {
				result[current] = i;
				String temp = "";
				for(int j=0; j<=current; j++) temp += result[j];
				int num = Integer.parseInt(temp);
				int cnt = 0;
				for(int k=2; k*k<=num; k++) {
					if(num%k==0) cnt++;
				}
				if(cnt==0) combi(current+1);
			}
		}
	}
}
