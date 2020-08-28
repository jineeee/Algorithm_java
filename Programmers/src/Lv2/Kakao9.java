package Lv2;

import java.util.ArrayList;
import java.util.Collections;

public class Kakao9 {
	
	public static void main(String[] args) {
		solution(16, 16, 2, 1);
	}
	
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder stringBuilder = new StringBuilder();
        
        for(int i=0; i<t*m; i++) {
        	if(i==0) stringBuilder.append(i);
        	
        	stringBuilder.append(convert(n, i));
        }
        System.out.println("sb  " + stringBuilder);
        
        for(int i=p-1; i<stringBuilder.length(); i=i+m) {
        	answer += stringBuilder.substring(i, i+1);
        	if(answer.length()==t) break;
        }
        System.out.print(answer.toUpperCase());
        
        return answer.toUpperCase();
    }
	
	static String convert(int n, int i) {
		StringBuilder sb = new StringBuilder();
		while (i>0) {
			int rem = i % n;
			sb.append(rem >= 10 ? String.valueOf((char)('A' + (rem - 10))) : rem);
			i /= n;	
		}
		
		return sb.reverse().toString();
	}

}
