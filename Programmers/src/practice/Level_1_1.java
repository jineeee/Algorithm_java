package practice;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 프로그래머스 Level 1
 * 문자열로 구성된 리스트 strings와, 정수 n이 주어졌을 때, 
 * 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다. 
 * 예를 들어 strings가 [sun, bed, car]이고 n이 1이면 각 단어의 인덱스 1의 문자 u, e, a로 strings를 정렬합니다.
 */

public class Level_1_1 {
	public String[] solution(String[] strings, int n) {
		
		String[] answer = {};
	      
	    Arrays.sort(strings, new Comparator<String>() {
	    	@Override
			public int compare(String o1, String o2) {
                if( Integer.compare(o1.charAt(n), o2.charAt(n)) == 1 
                		||  Integer.compare(o1.charAt(n), o2.charAt(n)) == -1)
				    return Integer.compare(o1.charAt(n), o2.charAt(n));
                else 
                    return o1.compareTo(o2);
	    	}
	    });
	    answer = strings;
	    return answer;
	   
	}
}
