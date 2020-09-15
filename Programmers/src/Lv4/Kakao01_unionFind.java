package Lv4;

import java.util.*;

/*
 * 호텔 방 배정 - unionFind
 * https://programmers.co.kr/learn/courses/30/lessons/64063
 * 해답 - https://tech.kakao.com/2020/04/01/2019-internship-test/
 */

public class Kakao01_unionFind {
	static HashMap<Long, Long> room = new HashMap<Long, Long>();
	
	public static void main(String[] args) {
		long[] arr = {1,3,1,2};
	}
	
	public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        
        for(int i=0; i<room_number.length; i++) {
        	answer[i] = getEmp(room_number[i]);
        }
        return answer;
    }

	static long getEmp(long room_number) {
		if(!room.containsKey(room_number)) { // 빈 방인 경우 해당 방 넘버 return
			room.put(room_number, room_number+1);
			return room_number;
		}else { // 빈 방이 없는 경우 연결 연결된 방을 탐색해서 빈 방을 찾아 return
			long next = room.get(room_number);
			long empty = getEmp(next);
			room.put(room_number, empty); // 부모 노드 변경
			return empty;
		}
	}
}
