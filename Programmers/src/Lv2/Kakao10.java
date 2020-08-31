package Lv2;

import java.util.*;

/*
 * 카카오 튜플 - map 사용, 정렬하기
 * https://programmers.co.kr/learn/courses/30/lessons/64065
 */

public class Kakao10 {
	
	public static void main(String[] args) {
		solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
	}
	
	public static int[] solution(String s) {
		
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String[] arr = s.split(",");
        
        for(int i=0; i<arr.length; i++) {
        	arr[i] = arr[i].replace("{", "");
        	arr[i] = arr[i].replace("}", "");
        	map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
        }
        System.out.println(map.entrySet());
        List<Map.Entry<String, Integer>> result = sortByValue(map);
        
        int[] answer = new int[map.size()];
        for(int i=0; i<result.size(); i++) 
        	answer[i] = Integer.parseInt(result.get(i).getKey());

        return answer;
    }
	
	static List<Map.Entry<String, Integer>> sortByValue(HashMap<String, Integer> map) {
		List<Map.Entry<String, Integer>> entries = new LinkedList<Map.Entry<String,Integer>>(map.entrySet());
		Collections.sort(entries, (o1, o2)-> o2.getValue().compareTo(o1.getValue()));
		System.out.println(entries);
		return entries;
	}

}
