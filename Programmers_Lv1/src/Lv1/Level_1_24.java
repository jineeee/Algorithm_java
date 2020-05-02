package Lv1;

/*
 * 최대공약수와 최대공배수
 * https://programmers.co.kr/learn/courses/30/lessons/12940
 */

public class Level_1_24 {
	
	public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n, m);
        answer[1] = lcm(n, m);
        
        return answer;
    }
	
	static public int gcd(int a, int b) {
		while (b!=0) {
			int r = a%b;
			a = b;
			b = r;
		}
		return a;
	}
	
	static public int lcm(int a, int b) {
		return a*b / gcd(a, b);
	}

}
