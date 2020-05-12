package Lv2;

/*
 * 멀쩡한 사각형 - 최대 공약수
 * https://programmers.co.kr/learn/courses/30/lessons/62048
 */

public class Level_2_18 {

	public long solution(int w, int h) {
        return w*h - (w+h-gcd(w, h));
    }
	
	static int gcd(int w, int h) {
		while(h != 0) {
			int r = w%h;
			w = h;
			h = r;
		} return w;
	}
}
