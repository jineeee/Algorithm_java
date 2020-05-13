package Lv2;

import java.util.*;

public class Level_2_22 {
	static public int solution(int[] A, int[] B){
        int answer=0;
        List<Integer> list = new ArrayList<Integer>();
        
        Arrays.sort(A); // 오름차순으로 정렬
        for(int i : B)  list.add(i);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(Arrays.toString(A));
        System.out.println(list);
        
        for(int i=0; i<A.length; i++) {
        	answer += A[i]*list.get(i);
        }
        System.out.println(answer);
		return answer;
    }
	
	public static void main(String[] args) {
		int[] temp = {1, 4, 2};
		int[] temp2 = {5, 4, 4};
		solution(temp, temp2);
	}
}
