package Lv3;

import java.util.Arrays;

public class Level_3_03 {
	
	public static void main(String[] args) {
		int[] arr1 = {5,1,3,7};
		int[] arr2 = {2,2,6,8};
		solution(arr1, arr2);
	}
	
	static public int solution(int[] A, int[] B) {
		int ans=0;
		Arrays.sort(A);
		Arrays.sort(B);
		
		int aIdx = 0, bIdx = 0;
		for(int i=0; i<A.length; i++) {
			if(A[aIdx]>=B[bIdx]) {
				bIdx++;
			}else {
				aIdx++;
				bIdx++;
				ans++;
			}
		}
		
        return ans;
    }

}
