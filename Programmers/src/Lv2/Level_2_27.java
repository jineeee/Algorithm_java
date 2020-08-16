package Lv2;

/*
 * 124 나라의 숫자
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 */

public class Level_2_27 {

	public static String solution(int n) {
        String answer = "";
        String[] num = {"4", "1", "2"};
        
        while(n>0) {
        	int remain = n % 3; // 나머지 값
        	n /= 3; // n은 3으로 나눈 몫
        	
        	// 나머지가 0이면 예외처리
        	if(remain==0) n -= 1;
       
        	answer = num[remain] + answer;
        }
        System.out.print(answer);
        return answer;
    }
	
	public static void main(String[] args) {
		solution(16);
	}
}
