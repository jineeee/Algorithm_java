import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 백준 수 찾기 - 이분탐색 
 * https://www.acmicpc.net/problem/1920
 */

public class BOJ1920 {
	static int[] array1;
	static int[] array2;
	static int num1,num2;
	static int s,e,m;
	
	static int getResult(int n) {
		int status = 0;
		
		if(n<array1[0] || n>array1[num1-1]) return status;
		
		s = 0;
		e = num1-1;
		
		while (e-s>=0) {
			m = (s+e)/2;
			if(array1[m]==n) {
				status = 1;
				break;
			}if(array1[m]>n) {
				e=m-1;
			}else {
				s=m+1;
			}
		}
		
		return status;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		num1 = Integer.parseInt(st.nextToken());
		array1 = new int[num1];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<num1; i++) {
			array1[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(array1);
		
		st = new StringTokenizer(br.readLine());
		num2 = Integer.parseInt(st.nextToken());
		array2 = new int[num2];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<num2; i++) {
			array2[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<num2; i++) {
			System.out.println(getResult(array2[i]));
		}
		
	}
}
