package Lv2;

import java.util.*;

/*
 * 가장 큰 수 - 문자열 정렬
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */

public class Level_2_25 {

	public static String solution(int[] numbers) {
        String answer = "";
        
        String[] strings = new String[numbers.length];
        for(int i=0; i<numbers.length; i++) strings[i] = String.valueOf(numbers[i]);
        
        Arrays.sort(strings, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}
		});
        for(String string : strings) answer += string;

        if(answer.charAt(0)=='0') return "0";
        else return answer;
    }
	
	public static void main(String[] args) {
		int[] arr = {0,0,0};
		solution(arr);
	}
}
