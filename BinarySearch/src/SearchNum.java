import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SearchNum {
	static int s;
	static int e;
	static int m;
	static int[] array = {2,3,4,5,6,7,8};
	
	static void getResult(int k) {
		if(k<array[0] || k>array[array.length-1]) return;
		
		s = 0;
		e = array.length-1;
		
		while (e-s>=0) {
			m = (s+e)/2;
			
			if(array[m]==k) {
				System.out.println(m);
				return;
			}if(array[m]>k) {
				e=m-1;
			}else {
				s=m+1;
			}
		
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int k = Integer.parseInt(st.nextToken());
		
		getResult(k);
	}
	
}
