package Lv2;

import java.util.HashMap;

/*
 * 위장 - 해시를 이용해 모든 경우의 수를 수함
 * https://programmers.co.kr/learn/courses/30/lessons/42578
 */


public class Level_2_14 {

	public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        
        for(int i=0; i<clothes.length; i++) {
        	// key에 해당하는 값이 없으면 default인 0을,값이 있으면 그 값의 1을 더해 다시 넣어준다
        	// key로는 장비의 카테고리를 string으로 넣어준다
        	map.put(clothes[i][1], map.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        for(int value : map.values()) {
        	answer *= value+1; // 해당 카테고리의 장비를 선택하지 않는 경우도 있기 때문에 +1을 해준다
        }
        
        return answer-1; // 모든 카테고리의 장비를 선택하지 않으면 위장을 하지 못하므로 결과에 -1을 해준다
    }
}
