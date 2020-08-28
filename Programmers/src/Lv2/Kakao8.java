package Lv2;

import java.util.*;

/*
 * 카카오 압축 - 문자열 다루기
 * https://programmers.co.kr/learn/courses/30/lessons/17684
 */

public class Kakao8 {
	
	public static void main(String[] args) {
		String string = "ABABABABABABABAB";
		solution(string);
	}
	
	static String[] list = {"","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
	static ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(list));
	
	public static int[] solution(String msg) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        
        for(int i=0; i<msg.length(); i++) {
        	int idx = 0, size = 0;
        	String addString = "";
        	for(int j=i; j<msg.length(); j++) {
        		String temp = msg.substring(i, j+1);
        		
        		if(arrayList.contains(temp)) {
        			idx = arrayList.indexOf(temp);
        			size = j-i;
        		} else {
					addString = temp;
					break;
				}
        	}
        	result.add(idx);
        	arrayList.add(addString);
        	i += size;
        }
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++) answer[i] = result.get(i);
        return answer;
    }

}
