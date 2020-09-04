package Lv3;

import java.util.*;

/*
 * 카카오 불량사용자 - 정규표현식, dfs
 * https://programmers.co.kr/learn/courses/30/lessons/64064
 */

public class Kakao06 {
	
	public static void main(String[] args) {
		String[] user1 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban1 = {"fr*d*", "abc1**"};
		
		String[] user2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban2 = {"*rodo", "*rodo", "******"};
		
		String[] user3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
		String[] ban3 = {"fr*d*", "*rodo", "******", "******"};
		solution(user3, ban3);
	}

	static String[] newBanned_id;
	static boolean[] visit;
	static HashSet<HashSet<Integer>> resultSet = new HashSet<HashSet<Integer>>();
	
	public static int solution(String[] user_id, String[] banned_id) {
        newBanned_id = new String[banned_id.length];
        visit = new boolean[user_id.length];
        
        for(int i=0; i<banned_id.length; i++) newBanned_id[i] = banned_id[i].replace("*", ".");
        
        dfs(0, new HashSet<Integer>(), user_id);
        
        return resultSet.size();
    }
	
	static void dfs(int idx, HashSet<Integer> set, String[] user_id){
		if(idx==newBanned_id.length) {
			resultSet.add(set);
			return;
		}
		for(int i=0; i<user_id.length; i++) {
			if(visit[i]) continue;
			if(user_id[i].matches(newBanned_id[idx])) {
				visit[i] = true;
				set.add(i);
				dfs(idx+1, new HashSet<>(set), user_id);
				visit[i] = false;
				set.remove(i);
			}
		}
	}

}
