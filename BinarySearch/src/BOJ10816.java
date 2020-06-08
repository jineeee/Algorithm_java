

import java.util.*;

/*
 * 백준 숫자카드2 - 이분탐색 (정답X), 특정숫자기법 찾기
 * https://www.acmicpc.net/problem/10816
 */

public class BOJ10816 {
	static int N, M, start, end, middle;
	static long[] sang, num;

	static int getResult(long target) {
		if(target<sang[0] || target>sang[N-1]) return 0;
		
		int cnt=0;
		start = 0;
		end = sang.length-1;
		
		while(end-start>=0) {
			middle = (start+end)/2;
			if(target==sang[middle]) {
				cnt++;
				int tmp = middle;
//				System.out.println("temp "+tmp);
				while ((tmp-1)>=0 && sang[tmp-1]==target) {
					if(tmp-1==middle) break;
					cnt++;
					tmp--;
//					System.out.println("--" + tmp);
				}
				while ((tmp+1)<N && sang[tmp+1]==target) {
					if(tmp+1==middle) break;
					cnt++;
					tmp++;
//					System.out.println("++" + tmp);
				}
				break;
			}
			else if(target>sang[middle])
				start = middle+1;
			else if(target<sang[middle])
				end = middle-1;
		}
		return cnt;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		sang = new long[N];
		for(int i=0; i<N; i++) 
			sang[i] = scanner.nextLong();
		M = scanner.nextInt();
		num = new long[M];
		for(int i=0; i<M; i++)
			num[i] = scanner.nextLong();
		Arrays.sort(sang);
		for(long i: num) {
			System.out.print(getResult(i) + " ");
		}
	}
}
