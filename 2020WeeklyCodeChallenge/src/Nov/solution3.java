package Nov;

import java.util.ArrayList;
import java.util.Arrays;

public class solution3 {
	
	public static void main(String[] args) {
//		solution(new int[] {0, 3, 3, 0, 7, 2, 0, 2, 2, 0});
		solution(new int[] {5,2,3,3,5,3});
	}
	
	static int answer = 0;
	static boolean flag = false;
	
	static public int solution(int[] a) {
        for(int i=a.length%2==0 ? a.length : a.length-1; i>=2; i=i-2){
        	if(flag) break;
        	makeCombination(i, new int[i], 0, 0, a);
        }
        System.out.println(answer);
        return answer;
    }
    
	private static void makeCombination(int r, int[] temp, int current, int start, int[] a) {
		if(flag) return;
		if (r == current) {
			if(!check(temp, r)) return;
			System.out.println(Arrays.toString(temp));
			if(answer<temp.length) {
				answer = r;
				flag = true;
			}
		} else {
			for (int i = start; i < a.length; i++) {
				if(current%2==1 && temp[current-1]==a[i]) continue;
				temp[current] = a[i];
				if(current%2==0 && !check(temp, current)) continue;
				makeCombination(r, temp, current + 1, i + 1, a);
			}
		}
	}
    
    static boolean check(int[] result, int len){
        int n1 = result[0], n2 = result[1];
        
        boolean flag1 = true, flag2 = true;
        for(int i=2; i<=len-2; i+=2){
            if(result[i]!=n1 && result[i+1]!=n1) flag1 = false;
            if(result[i]!=n2 && result[i+1]!=n2) flag2 = false;
        }
        
        if(!flag1 && !flag2) return false;
        return true;
    }

}
