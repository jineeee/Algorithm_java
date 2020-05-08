package Lv1;

import java.util.*;

/*
 * 실패율
 * https://programmers.co.kr/learn/courses/30/lessons/42889
 * 5, [2,1,2,6,2,4,3,3]  ->	 [3,4,2,1,5]
 * 전체 스테이지의 개수 N, 게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages
 */

public class Kakao4 {
	static public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] s = new int[N+1]; // 스테이지별로 패스했거나 현재 도전중인 유저를 합한 수
        int[] nowUser = new int[N+1]; // 현재 해당 인덱스 스테이지에 위치하고 있는 유저의 수
        double[] failure = new double[N];
        
        for(int i=0; i<stages.length; i++) {
        	nowUser[stages[i]-1] += 1;
        	for(int j=stages[i]; j>0; j--) {
        		s[j-1] += 1;
        	}
        }
        
        for (int i=0; i<s.length-1; i++) {
        	if(s[i]==0) { // 분모가 0이 되는 경우 예외처리
        		failure[i] = 0;
        		continue;
        	}
        	failure[i] = ((double)nowUser[i]/s[i]);
        }
       
        
        double[] failure2 = Arrays.copyOf(failure, failure.length);
        for (int i =0; i < failure2.length ; i++ ){
			for(int j =i+1; j<failure2.length; j++){
				if (failure2[j] > failure2[i]){
					double temp = failure2[i];
					failure2[i] = failure2[j];
					failure2[j] = temp;
				}
			}
		}
        
        for(int i=0; i<failure2.length; i++) {
        	for(int j=0; j<failure.length; j++) {
        		if(failure2[i] == failure[j]) {
        			answer[i] = j+1;
        			failure[j] = -1;
        			break;
        		}
        	}
        }
        
        System.out.println(Arrays.toString(s));
        System.out.println(Arrays.toString(nowUser));
        System.out.println(Arrays.toString(failure));
        System.out.println(Arrays.toString(failure2));
        System.out.println(Arrays.toString(answer));
        return answer;
    }
	
	public static void main(String[] args) {
		int[] stage = {2,1,2,6,2,4,3,3};
		solution(7, stage);
	}
}
