package week8;

import java.io.*;
import java.util.*;

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
		int mid = 0;
		while(s<=e) {
			mid = (s+e)/2;
			int night = (int) Math.ceil( (double) mid / (a - b));
			int day = night + b;
			if(day<v) s = mid+1;
			else {
				ans = mid;
				e = mid-1;
			}
		}
		System.out.print(ans);
	}
}
