package Lv2;

/*
 * 카카오 n진수 게임 - 진법 변환
 * https://programmers.co.kr/learn/courses/30/lessons/17687
 */

public class Kakao09 {
	
	public static void main(String[] args) {
		solution(16, 16, 2, 1);
	}
	
	public static String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder result = new StringBuilder();
        
        for(int i=0; i<t*m; i++) {
        	if(i==0) result.append(i);
        	result.append(convert(n, i));
        }
        
        for(int i=p-1; i<result.length(); i=i+m) {
        	answer += result.substring(i, i+1);
        	if(answer.length()==t) break;
        }
        
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
