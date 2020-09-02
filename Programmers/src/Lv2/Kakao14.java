package Lv2;

import java.util.*;

/*
 * 카카오 수식 최대화 - 문자열
 * https://programmers.co.kr/learn/courses/30/lessons/67257
 */

public class Kakao14 {

	public static void main(String[] args) {
		String string1 = "50*6-3*2";
		solution(string1);
	}
	
	static String[] oper = {"+", "-", "*"};
	static String[] numArr, operArr, temp = new String[3];
	static ArrayList<String> list = new ArrayList<String>();
	static long answer = Long.MIN_VALUE;
	
	public static long solution(String expression) {
        numArr = expression.split("[*||+||-]");
        operArr = expression.replaceAll("[0-999]", "").split("");
        
        for(int i=0; i<operArr.length; i++) {
        	list.add(numArr[i]);
        	list.add(operArr[i]);
        } list.add(numArr[numArr.length-1]);
        
        permu(0, new boolean[3]);
        
        return answer;
    }
	
	static void permu(int current, boolean[] visit) {
		if (current==3) {
			answer = Math.max(calc(temp), answer);
		}else {
			for(int i=0; i<3; i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[current] = oper[i];
					permu(current+1, visit);
					visit[i] = false;
				}
			}
		}
	}
	
	static Long calc(String[] operResult) {
		
		ArrayList<String> copy = new ArrayList<String>(list);

		for(int i=0; i<3; i++) {
			String oper = operResult[i];
			for(int j=0; j<copy.size(); j++) {
				if(copy.get(j).equals(oper)) {
					Long result = 0L;
					if(oper.equals("+")) {
						result = Long.valueOf(copy.get(j-1))+Long.valueOf(copy.get(j+1));
					}else if(oper.equals("-")) 
						result = Long.valueOf(copy.get(j-1))-Long.valueOf(copy.get(j+1));
					else if(oper.equals("*")) 
						result = Long.valueOf(copy.get(j-1))*Long.valueOf(copy.get(j+1));
					
					copy.set(j-1, String.valueOf(result));
					copy.remove(j);
					copy.remove(j);
					j--;
				}
			}
		}
		return Math.abs(Long.valueOf(copy.get(0)));
	}

}
