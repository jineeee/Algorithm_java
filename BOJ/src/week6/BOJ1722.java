package week6;

import java.util.*;

public class BOJ1722 {
	static int n, flag, k=Integer.MAX_VALUE, cnt=0;
	static int[] arr, result, input;
	static boolean[] visit;
	static boolean print;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		arr = new int[n];
		result = new int[n];
		visit = new boolean[n];
		flag = scanner.nextInt();
		if(flag==1) {
			k = scanner.nextInt();
			for(int i=1; i<=n; i++) arr[i-1] = i;
			permu(0);
		}
		else {
			input = new int[n];
			for(int i=0; i<n; i++) {
				arr[i] = i+1;
				input[i] = scanner.nextInt();
			}
			permu(0);
		}
	}
	
	static void permu(int current) {
		if(cnt>=k || print) return;
		if(current ==n) {
			cnt++;
			if(flag==1) {
				if(cnt==k) {
					for(int i:result) System.out.print(i + " ");
				}
			}else if(flag==2){
				System.out.println(Arrays.toString(result));
				boolean flag = true;
				for(int i=0; i<n; i++) if(result[i]!=input[i]) flag=false;
				if(flag) {
					System.out.print(cnt);
					print = true;
				}
			}
		}else {
			for(int i=0; i<arr.length; i++) {
				if(!visit[i]) {
					visit[i] = true;
					result[current] = arr[i];
					permu(current+1);
					visit[i] = false;
				}
			}
		}
	}
}
