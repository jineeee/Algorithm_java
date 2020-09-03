package Lv3;

import java.util.*;

/*
 * 카카오 셔틀버스 
 * https://programmers.co.kr/learn/courses/30/lessons/17678
 */

public class Kakao05 {
	
	public static void main(String[] args) {
		System.out.println(solution(1, 1, 5, new String[]{"08:00", "08:01", "08:02", "08:03"}));
        System.out.println(solution(2, 10, 2, new String[]{"09:10", "09:09", "08:00"}));
        System.out.println(solution(2, 1, 2, new String[]{"09:00", "09:00", "09:00", "09:00"}));
        System.out.println(solution(1, 1, 5, new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"}));
        System.out.println(solution(1, 1, 1, new String[]{"23:59"}));
        System.out.println(solution(10, 60, 45, new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59"
                , "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"}));
	}
	
	static String[] busTime;
	
	// n회, t분 간격, 최대 m명의 승객, 대기열 도착 시간 모음 timetable
	public static String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        Arrays.parallelSort(timetable);
        
        busTime = new String[n];
        for(int i=0; i<n; i++) busTime[i] = getBusTime(t, i);
        int goneCrew = 0; // 출근한 크루 수
        for(int i=0; i<busTime.length; i++) { // 모든 버스 순회
        	
        	int crew = 0; // 이번 버스에 탄 크루 수
        	String lastCrew = ""; // 마지막으로 버스에 탄 크루의 시간 
        	
        	for(int j=goneCrew; j<timetable.length; j++) { // 승객 태우기
        		if(busTime[i].compareTo(timetable[j])>=0) { // 이전에 도착한 승객만 태움
        			lastCrew = timetable[j];
        			crew++;
        			goneCrew++;
        			if(crew==m) break;
        		}
        	}
        	
        	if(crew<m) // 버스에 자리가 남으면 버스 시간에 도착해도 됨
        		answer = busTime[i];
        	else if(crew==m) { // 버스에 자리가 없으면 마지막 도착 크루보다 1분 일찍 도착
        		String[] lastTime = lastCrew.split(":");
        		int time = Integer.parseInt(lastTime[0]);
        		int min = Integer.parseInt(lastTime[1])-1;
        		if(min<0) {
        			min=59;
        			time -=1;
        		}
        		answer = String.format("%02d", time)+":"+String.format("%02d", min);
        	}
        }
        return answer;
    }
	
	static String getBusTime(int t, int i) {
		int time = 9 + t*i/60;
		int min = 00 + t*i%60;
		return String.format("%02d", time)+":"+String.format("%02d", min);
	}

}
