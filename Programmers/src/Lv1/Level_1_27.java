package Lv1;

import java.util.*;

public class Level_1_27 {
//	static public int solution(int n, int[] lost, int[] reserve) {
//        int answer = n - lost.length; // 체육복을 잃어버리지 않은 학생의 수
//        
//        List<Integer> lostList = new ArrayList<Integer>(); //  체육복을 잃어버린 학생의 리스트
//		for (int i : lost) lostList.add(i);
//		System.out.println(lostList);
//
//		List<Integer> reserveList = new ArrayList<Integer>(); // 체육복 여분을 가지고 있는 학생의 리스트
//		for (int i : reserve) reserveList.add(i);
//		System.out.println(reserveList);
//		
//        for(int i=0; i<lostList.size(); i++) { // 체육복을 잃어버렸지만 여분을 갖고 있는 학생들은 각 리스트에서 제거
//			for(int j=0; j<reserveList.size(); j++) {
//				if(lostList.get(i) == reserveList.get(j)) {
//					lostList.remove(i);
//					reserveList.remove(j);
//                    i--;
//                    answer++;
//					break;
//				}
//			}
//		}
//    
//		for (int i = 0; i < lostList.size(); i++) { // 잃어버린 학생의 앞 뒤 학생이 체육복 여분을 갖고 있을 경우 빌려줄 수 있다.
//			int lostNum = lostList.get(i);
//			for (int j = 0; j < reserveList.size(); j++) {
//				int reserveNum = reserveList.get(j);
//				if (lostNum == reserveNum - 1 || lostNum == reserveNum + 1) {
//					reserveList.remove(j);
//					answer++;
//					break;
//				}
//			}
//		}
//
//		return answer;
//	}
	
	static public int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        
        List<Integer> lostList = new ArrayList<Integer>();
        for(int i:lost) lostList.add(i);
        
        List<Integer> reserveList = new ArrayList<Integer>();
        for(int i:reserve) reserveList.add(i);
        
        for(int i=0; i<lostList.size(); i++) { // 잃어버린 학생중 여벌이 있는 학생이 있다면 리스트에서 제거
        	for(int j=0; j<reserveList.size(); j++) {
        		if(lostList.get(i) == reserveList.get(j)) {
        			lostList.remove(i);
        			reserveList.remove(j);
        			answer++;
        			i--;
        			break;
        		}
        	}
        }
        
        for(int i=0; i<lostList.size(); i++) {
        	for(int j=0; j<reserveList.size(); j++) {
        		if(reserveList.get(j) == lostList.get(i)-1 || reserveList.get(j) == lostList.get(i)+1) {
        			reserveList.remove(j);
        			answer++;
        			break;
        		}
        	}
        }
        
        return answer;
    }
	
	public static void main(String[] args) {
		int[] l = {2, 4};
		int[] r = {1, 3, 5};
		solution(5, l, r);
		
	}
}
