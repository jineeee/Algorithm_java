package Lv2;

import java.util.Arrays;
import java.util.Comparator;

/*
 * 가장 큰 수 - comparator, 문자열 비교
 * https://programmers.co.kr/learn/courses/30/lessons/42746
 */
public class Level_2_19 {
//	static int len;
//	static int[] result;
//	static boolean[] visited;
//	static long max = -1;
//
//	static public String solution(int[] numbers) {
//        len = numbers.length;
//        result = new int[len];
//        visited = new boolean[len];
//        permu(0, numbers);
//        return String.valueOf(max);
//    }
//	
//	static void permu(int x, int[] numbers) { // 순열
//		if(x==len) {
//			String string = "";
//			for(int i: result) string += String.valueOf(i);
//			max = Math.max(max, Long.parseLong(string));
//		}else {
//			for(int i=0; i<len; i++) {
//				if(!visited[i]) {
//					visited[i] = true;
//					result[x] = numbers[i];
//					permu(x+1, numbers);
//					visited[i] = false;
//				}
//			}
//		}
//	}
	
	static public String solution(int[] numbers) {
		String answer = "";
		String[] strNum = new String[numbers.length];
		
		for(int i=0; i<numbers.length; i++) {
			strNum[i] = String.valueOf(numbers[i]);
		}
		
		Arrays.sort(strNum, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return (o2+o1).compareTo(o1+o2);
			}		
		});

		//0000 처럼 0으로만 구성되어있으면 0 return
        if (strNum[0].equals("0")) return "0";
        
        //그 외의 경우 순차적으로 연결하여 answer return
        for (int i = 0; i < strNum.length; i++) {
            answer+=strNum[i];
        }
        return answer;
	}

	public static void main(String[] args) {
		int[] temp = {6, 10, 2};
		solution(temp);
	}
}


