package recursive_maze;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Recursion_bracket {
	static int n;
	static String[] result;
	
	static void getResult(int idx, int lc, int rc) {
		
		if(idx==2*n) {
			for(int i=0; i<2*n; i++) {
				System.out.print(result[i]);
			}System.out.println();
		}else {
			if (lc < n) { // 여는 괄호의 갯수가 n 이하이면 여는 괄호 가능
				result[idx] = "(";
				getResult(idx+1, lc + 1, rc);
			}
			if (rc < lc) { // 여는 괄호보다 닫는 괄호가 부족하다면 닫는 괄호만 가능
			    	result[idx] = ")";
			    	getResult(idx+1, lc, rc + 1);
			}
		}
	}

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		result = new String[2*n];
		getResult(0, 0, 0);
	}
}
