package Lv2;

import java.util.*;

/* 카카오 닉네임 - hashmap을 이용하여 문자열 처리
 * https://programmers.co.kr/learn/courses/30/lessons/42888
 * 
 * ["Enter uid1234 Muzi", 
 * 	"Enter uid4567 Prodo",
 * 	"Leave uid1234",
 * 	"Enter uid1234 Prodo",
 * 	"Change uid4567 Ryan"]
 * 
 * ["Prodo님이 들어왔습니다.", 
 * 	"Ryan님이 들어왔습니다.", 
 * 	"Prodo님이 나갔습니다.", 
 * 	"Prodo님이 들어왔습니다."]
 */
public class Level_2_18 {
	
	static public String[] solution(String[] record) {
        List<String> answerList = new ArrayList<String>();
        HashMap<String, String> map = new HashMap<String, String>();
        
        String[][] rec = new String[record.length][3];
        
        for(int i=0; i<record.length; i++) {
        	if(record[i].split(" ")[0].equals("Enter"))
        		map.put(record[i].split(" ")[1], record[i].split(" ")[2]);
        	if(record[i].split(" ")[0].equals("Change"))
        		map.put(record[i].split(" ")[1], record[i].split(" ")[2]);
        }
        
        for (int i = 0; i < rec.length; i++) {
        	if(record[i].split(" ")[0].equals("Enter"))
        		answerList.add(map.get(record[i].split(" ")[1]) + "님이 들어왔습니다.");
        	if(record[i].split(" ")[0].equals("Leave"))
        		answerList.add(map.get(record[i].split(" ")[1]) + "님이 나갔습니다.");
		}

        String[] answer = new String[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
        	answer[i] = answerList.get(i);
		}
        
        return answer;
    }
	
	public static void main(String[] args) {
		String [] tempStrings = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan", "Leave uid4567"};
		solution(tempStrings);
	}

}
