package Lv2;

import java.util.*;

/*
 * 끝말잇기 - 배열, 문자열 비교
 * https://programmers.co.kr/learn/courses/30/lessons/12981
 */
public class Level_2_16 {
	
	static public int[] solution(int n, String[] words) {
		int[] answer = new int[2];
        List<String> temp = new LinkedList<String>();
        int num = 0;
        int turn = 1; // 몇번째 바퀴인지 저장
        boolean flag = true;
        
        for(int i=0; i<words.length; i++) {
        	System.out.println(temp);      	
        	if(i==0) { // 첫번째 순서는 패스
        		temp.add(words[i]);
        		continue;
        	}
        	
        	String start = words[i].substring(0,1); // 현재 단어의 시작 글자
        	String end = words[i-1].substring(words[i-1].length()-1); // 이전 단어의 끝 글자
        	if(!start.equals(end)) { // 이어지지 않는 단어라면 break;
//        		System.out.println(words[i]);
        		num = i%n + 1; // 몇번째 사람이 틀렷는지 저장
        		flag = false;
        		break; 
        	} else if(temp.contains(words[i])) { // 이미 나온 단어라면
//        		System.out.println(words[i]);
        		num = i%n + 1; // 몇번째 사람이 틀렷는지 저장
        		flag = false;
        		break; 
        	}
        	if(i%n + 1 == n) {
//        		System.out.println(i);     
        		turn++; // 한바퀴 돌면 turn을 update
        	}
        	temp.add(words[i]);
        }
        
        if(flag) {
        	answer[0] = 0;
        	answer[1] = 0;
        }else {
        	answer[0] = num;
        	answer[1] = turn;
        }
        System.out.println(Arrays.toString(answer));
        return answer;
    }

	public static void main(String[] args) {
		String[] strings = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
		solution(3, strings);
	}
}
