package Lv2;

/*
 * 큰 수 만들기 - 탐욕법
 * https://programmers.co.kr/learn/courses/30/lessons/42883
 */

public class Level_2_29 {
	
	public static String solution(String number, int k) {
        if(number.charAt(0)=='0') return "0";
        
        StringBuilder sb = new StringBuilder(number);
        int delCnt = 0, idx = 1;
        
        while (delCnt!=k) {
//        	System.out.println(sb.toString());
			if(idx>=1 && sb.charAt(idx-1)<sb.charAt(idx)) { // 왼쪽 값과 비교해서 현재 인덱스 위치의 값이 더 클 때
				sb.deleteCharAt(idx-1); // 작은 값 삭제
				delCnt++; // 삭제 카운트 증가
				idx--; // 앞 인덱스를 삭제했으므로 인덱스 값 조정
			}else {
				if(idx==sb.length()-1 && sb.charAt(idx-1)>=sb.charAt(idx)) { // 가장 마지막 값이 앞의 값보다 작을 때
					sb.deleteCharAt(idx); // 가장 마지막 값 삭제
					delCnt++;
				}else { // idx가 0이거나, 왼쪽 값과 비교해서 현재 인덱스 위치의 값이 더 클 때는 삭제하지 않음
					idx++;
				}
			}
		}
//        System.out.print(sb.toString());
        return sb.toString();
    }

	public static void main(String[] args) {
		solution("4177252841", 4);
	}
}
