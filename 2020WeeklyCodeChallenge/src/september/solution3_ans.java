package september;

import java.util.*;

public class solution3_ans {
	
	public static void main(String[] args) {
		int[] arr = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		solution(arr);
	}
	
	static int solution(int[] a) {
        int answer = 0;
        int[] left_min = new int[a.length+1];
        int[] right_min = new int[a.length+1];
        
        for(int i=0; i<a.length; i++) {
        	if(i==0) left_min[i] = a[i];
        	else left_min[i] = Math.min(left_min[i-1], a[i]);
        }
        System.out.println(Arrays.toString(left_min));
        for(int i=a.length-1; i>-1; i--) {
        	if(i==a.length) right_min[i] = a[i];
        	else right_min[i] = Math.min(right_min[i+1], a[i]);
        }
        System.out.println(Arrays.toString(right_min));
        int cnt = 0;
        for(int i=0; i<a.length; i++) {
        	if(i==0) cnt++;
        	else if(i==a.length-1) cnt++;
        	else {
        		int p=0;
        		if(left_min[i-1] < a[i]) p++;
        		if(right_min[i-1] < a[i]) p++;
        		if(p!=2) cnt++;
        	}
        }
        System.out.print(cnt);
        return answer;
    }
	
//	static public int solution(int[] a) {
//		int answer = 0;
//		int min = Integer.MAX_VALUE;
//		int smallIdx = -1;
//		for (int i = 0; i < a.length; i++) {
//			if (min > a[i]) {
//				smallIdx = i;
//				min = a[i];
//			}
//		}
//		int tempMin = a[0];
//		for (int i = 1; i < smallIdx; i++) {
//			if (tempMin < a[i]) {
//				answer++;
//			} else {
//				tempMin = a[i];
//			}
//		}
//		tempMin = a[a.length - 1];
//		for (int i = a.length - 2; i > smallIdx; i--) {
//			if (tempMin < a[i]) {
//				answer++;
//			} else {
//				tempMin = a[i];
//			}
//		}
//		answer = a.length - answer;
//		System.out.print(answer);
//		return answer;
//	}
}
