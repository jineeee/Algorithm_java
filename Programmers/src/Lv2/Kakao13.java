package Lv2;

/*
 * 카카오 단체사진 찍기 - 재귀, 백트래킹
 * https://programmers.co.kr/learn/courses/30/lessons/1835
 */

public class Kakao13 {
	
	public static void main(String[] args) {
		String[] arr1 = {"N~F=0", "R~T>2"};
		String[] arr2 = {"M~C<2", "C~M>1"};
		solution(2, arr1);
	}
	
	static String[] kakao = {"A", "C", "F", "J", "M", "N", "R", "T"};
	static int len = 8, answer;
	
	public static int solution(int n, String[] data) {
        
		answer = 0;
		String[] temp = new String[8];
        permu(temp, 0, new boolean[8], data);
       
        System.out.print(answer);
        return answer;
    }
	
	static void permu(String[] temp, int current, boolean[] visit, String[] data) {
		if(len==current) {
			String tempStr = "";
			for(String string : temp) tempStr += string;
			if (check(tempStr, data)) answer++;
		}else {
			for(int i=0; i<8; i++) {
				if(!visit[i]) {
					visit[i] = true;
					temp[current] = kakao[i];
					permu(temp, current+1, visit, data);
					visit[i] = false;
				}
			}
		}
	}
	
	static boolean check(String result, String[] input) {
		for(int i=0; i<input.length; i++) {
			char k1 = input[i].charAt(0);
			char k2 = input[i].charAt(2);
			char oper = input[i].charAt(3);
			int num = input[i].charAt(4)-'0';
			
			int term = Math.abs(result.indexOf(k1)-result.indexOf(k2))-1;

			if(oper=='=') {
				if (term!=num) return false;
			}else if(oper=='>') {
				if(term<=num) return false;
			}else if(oper=='<'){
				if(term>=num) return false;
			}
		}
		return true;
	}

}
