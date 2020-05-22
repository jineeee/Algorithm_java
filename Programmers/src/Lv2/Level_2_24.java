package Lv2;

/*
 * 스킬트리 - 문자열
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 */

public class Level_2_24 {

	static public int solution(String skill, String[] skill_trees) {
        int ans = 0;

        for(int i=0; i<skill_trees.length; i++) {
        	boolean flag = true;
        	int count = 0;
        	int idx=0;
        	String[] item = skill_trees[i].split("");
        	
        	for(int j=0; j<item.length; j++) {
        		idx = skill.indexOf(item[j]);
        		if(idx>count) {
        			flag = false;
        			break;
        		}else if(idx==count) count++;
        	}
        	if(flag) ans++;
        }
        System.out.print(ans);
        return ans;
    }

	
	public static void main(String[] args) {
		String[] s = {"BACDE", "CBADF", "AECB", "BDA"};
		solution("CBD", s);
	}
}
