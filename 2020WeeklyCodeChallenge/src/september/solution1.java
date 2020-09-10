package september;

import java.util.*;

public class solution1 {
	
	public static void main(String[] args) {
		solution(new int[] {5,0,2,7});
	}

	static HashSet<Integer> set = new HashSet<Integer>();
	static int[] num;
	
	static int[] solution(int[] numbers) {
        num = numbers;
        
        int[] idx = new int[numbers.length];
        for(int i=0; i<numbers.length; i++) idx[i] = i;
        combi(2, new int[2], 0, 0, idx);
        System.out.println(set);
        
        Integer[] integers = set.toArray(new Integer[set.size()]);
//        System.out.println(Arrays.toString(integers));
        int[] answer = new int[integers.length];
        for(int i=0; i<integers.length; i++) answer[i] = integers[i];
        Arrays.parallelSort(answer);
        return answer;
    }
	
	static void combi(int n, int[] result, int current, int start, int[] idx) {
		if(current==n) {
			set.add(num[result[0]] + num[result[1]]);
		}else {
			for(int i=start; i<idx.length; i++) {
				result[current] = idx[i];
				combi(n, result, current+1, i+1, idx);
			}
		}
	}
}
