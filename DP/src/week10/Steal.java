package week10;

/*
 * 프로그래머스 도둑질
 * https://programmers.co.kr/learn/courses/30/lessons/42897
 */

public class Steal {
	
	public int solution(int[] money) {
        int[] dp1 = new int[money.length];
        dp1[0] = money[0];
        dp1[1] = money[0];
        for(int i=2; i<money.length-1; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+money[i]);
        }
        
        int[] dp2 = new int[money.length];
        dp2[1] = money[1];
        for(int i=2; i<money.length; i++){
            dp2[i] = Math.max(dp2[i-1], dp2[i-2]+money[i]);
        }
        
        return Math.max(dp1[money.length-2], dp2[money.length-1]);
    }

}
