package week01;

import java.util.*;

public class BOJ14501 {
	static int N;
	static int[] T, P, result;
	static int max = -1;
	
	static void getResult(int current) {
		if(current == N) {
			int remain=0, price = 0;
			for(int i=0; i<current; i++) {
				if(remain==0 && result[i]==1) {
					remain = T[i];
					price += P[i];				
				} else if(result[i]==1) return;
				
				if(remain>0) remain--;
			}
			if(remain==0) max = Math.max(price, max);
		}else {
			for(int i=0; i<2; i++){
				result[current] = i;
				getResult(current+1);
			}
		}
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		T = new int[N];
		P = new int[N];
		result = new int[N];
		for(int i=0; i<N; i++) {
			T[i] = scanner.nextInt();
			P[i] = scanner.nextInt();
		}
		getResult(0);
		System.out.println(max);
	}
}
