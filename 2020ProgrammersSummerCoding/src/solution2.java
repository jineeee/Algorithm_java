import java.util.ArrayList;

import java.util.*;

public class solution2 {
	static int i = 0;
	static Set<Long> list = new HashSet<Long>();
	static List<Long> arr = new ArrayList<Long>();
	static List<Long> sortList;
	static long[] result;
	static boolean[] visit;
	
 	static public long solution(long n) {
        while(true) {
        	list.add((long) Math.pow(3, i));
        	arr.add((long) Math.pow(3, i));

        	for(int j=1; j<=i+1; j++) {
        		result = new long[j];
        		permu(0, j, 0);
        	}
        	i++;
        	if(list.size()>n) break;
        }
        sortList = new ArrayList<Long>(list);
        sortList.sort(null);
        long answer = sortList.get((int) (n-1));
		return answer;
    }
	
 	static void permu(int current, int len, int start) {
 		if(current == len) {
 			long temp = 0;
 			for(long i:result) temp += i;
 			list.add(temp);
 		}else {
 			for(int i=start; i<arr.size(); i++) {
 				result[current] = arr.get(i);
 				permu(current+1, len, i+1);
 			}
 		}
 	}
 	
	public static void main(String[] args) {
		solution(30);
	}
}
