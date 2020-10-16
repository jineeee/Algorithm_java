import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
 * 투포인터 (세용액)
 * https://www.acmicpc.net/problem/2473
 */

public class BOJ2473 {

	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String[] temp = br.readLine().split(" ");
	    int n = Integer.parseInt(temp[0]);
	    // int h = Integer.parseInt(temp[1]);
	    long[] arr = new long[n];
	    temp = br.readLine().split(" ");
	    for(int i=0; i<n; i++){
	      arr[i] = Long.parseLong(temp[i]);
	    }
	    solution(n, arr);
	  }

	  static int[] ans = new int[3];
	  static long min = 3000000000L;
	  static long[] input;

	  static public void solution(int N, long[] arr){
	    Arrays.sort(arr);
	    input = arr;
	    for(int i=0; i<N-2; i++){
	      calc(i);
	    }
	    Arrays.sort(ans);
	    System.out.print(input[ans[0]]+" "+input[ans[1]]+" "+input[ans[2]]);
	  }

	  static void calc(int idx){
	    int s = idx+1, e = input.length-1;
	    while(s<e){
	      long sum = input[idx]+input[s]+input[e];
	      if(Math.abs(sum)<min){
	        min = Math.abs(sum);
	        ans[0] = idx;
	        ans[1] = s;
	        ans[2] = e;
	      }
	      if(sum<0) s++;
	      else e--;
	    }
	  }
}
