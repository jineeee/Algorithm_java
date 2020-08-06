package week8;

import java.io.*;
import java.util.*;

/*
 * 달팽이는 올라가고 싶다 - 이진탐색
 * https://www.acmicpc.net/problem/2869
 */

public class BOJ2869 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int v = Integer.parseInt(st.nextToken());
		
		int ans = 0;
		int s = 0;
		int e = v;
		int mid = (s+e)/2;
		int sub = a-b;
		
		while(true) {
			ans = mid/sub; // 답은 올라간 거리를 a-b로 나눈 값
			
			if(v-(sub*ans)>a) s = mid+1; // 거리가 모자란 경우
			else if(v-(sub*ans)<a) { // 일수를 더 줄일 수 있는 경우
				if (mid+a-v >= sub) e = mid-1;
				else break;
			}else break; // a만큼 올라가면 정상인 경우
			mid = (s+e)/2;
		}
		System.out.print(ans+1); // a만큼 올라간 후 도달하므로 날짜 +1
	}
}
