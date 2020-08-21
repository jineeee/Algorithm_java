package Lv2;

/*
 * 피보나치 수 - (A+B)%C == ((A%C)+(B%C))%C
 * https://programmers.co.kr/learn/courses/30/lessons/12945
 */

public class Level_2_32 {
	
	public static int solution(int n) {
        int[] arr = new int[n+1];
        
        arr[0]=0; arr[1]=1; arr[2]=1;
        for(int i=3; i<=n; i++) {
        	arr[i] = (arr[i-1]+arr[i-2]) % 1234567;
        }
        
        System.out.println(arr[n]);
        return arr[n];
    }

	public static void main(String[] args) {
		solution(100000);
	}
}
