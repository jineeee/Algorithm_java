package Lv2;

import java.util.*;

/*
 * 카카오 파일명 정렬 - 자바 comparator
 * https://programmers.co.kr/learn/courses/30/lessons/17686
 */

public class Kakao11 {

	public static void main(String[] args) {
		String[] arr = {"img00122222222.png", "img00000999910.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"};
		String[] arr2 = {"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-00014 Tomcat", "foo9.txt","F-15","foo010 bar020.zip"};
		String[] arr3= {"muzi1.txt", "MUZI1.txt", "muzi001.txt", "muzi1.TXT"};
		solution(arr);
	}
	
	static String[][] result;
	
	public static String[] solution(String[] files) {
        result = new String[files.length][3];
        
        for(int i=0; i<files.length; i++) {
        	result[i][2] = String.valueOf(i);
        	
        	int idx = getHead(files[i]);
        	result[i][0] = files[i].substring(0, idx).toLowerCase();
        	
        	int numIdx = getNumber(files[i], idx);
        	if(numIdx-idx > 5) {
        		result[i][1] = files[i].substring(idx, numIdx);
        		if(result[i][1].isEmpty()) result[i][1] = "0";
        	}
        	else if(numIdx!=0) result[i][1] = files[i].substring(idx, numIdx);
        	else result[i][1] = files[i].substring(idx);
        
        	
        }
        
        Arrays.sort(result, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {
				if(o1[0].equals(o2[0]) && Integer.parseInt(o1[1])==Integer.parseInt(o2[1])) 
					return Integer.compare(Integer.parseInt(o1[2]), Integer.parseInt(o2[2]));
				if(o1[0].equals(o2[0])) 
					return Integer.compare(Integer.parseInt(o1[1]), Integer.parseInt(o2[1]));
				else return o1[0].compareTo(o2[0]);
			}
		});
        
        String[] answer = new String[result.length];
        for(int i=0; i<result.length; i++) {
        	answer[i] = files[Integer.parseInt(result[i][2])];
        }
        return answer;
    }
	
	static int getHead(String string) {
		int idx = 0;
		for(int i=0; i<string.length(); i++) {
			char temp = string.charAt(i);
			if(temp>=48 && temp<=57) {
				idx = i;
				break;
			}
		}
		return idx;
	}
	
	static int getNumber(String string, int start) {
		int idx = 0;
		for(int i=start; i<string.length(); i++) {
			char temp = string.charAt(i);
			if(temp<48 || temp>57) { // 숫자가 끝나는 시점
				idx = i;
				break;
			}
		}
		return idx;
	}
}
