package september;

import java.util.*;

public class solution3 {
	
	public static void main(String[] args) {
		int[] arr = {9,-1,-5};
		solution(arr);
	}
	
	static int solution(int[] a) {
        int answer = 0;
        int[] left_min = new int[1000001];
        int[] right_min = new int[1000001];
        
        for(int i=0; i<a.length; i++) {
        	if(i==0) left_min[i] = a[i];
        	else left_min[i] = Math.min(left_min[i-1], a[i]);
        }
        for(int i=a.length-1; i>-1; i--) {
        	if(i==a.length) right_min[i] = a[i];
        	else right_min[i] = Math.min(right_min[i+1], a[i]);
        }
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
}
