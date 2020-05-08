package Lv1;

/*
 * https://programmers.co.kr/learn/courses/30/lessons/12916
 */

public class Level_1_14 {
	
	boolean solution(String s) {
        int pc = 0;
        int yc = 0;

        for(int i=0; i<s.length(); i++) {
        	if(s.charAt(i) == 'p' || s.charAt(i) == 'P') pc++;
        	else if(s.charAt(i) == 'y' || s.charAt(i) == 'Y') yc++;
        }
        
        if(pc==yc) return true;
        else return false;
    }

}
