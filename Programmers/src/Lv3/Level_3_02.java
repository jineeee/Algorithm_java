package Lv3;

import java.util.*;

/*
 * 방문길이 - DP
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 */

public class Level_3_02 {

	public static void main(String[] args) {
		String string = "ULURRDLLU";
		solution(string);
	}
	
	static int solution(String dirs) {
        ArrayList<String> list = new ArrayList<String>();
        int px=0, py=0, nx=0, ny=0;
        for(int i=0; i<dirs.length(); i++) {
			if (dirs.charAt(i) == 'U') {
				nx = px+1;
				ny = py;
			} else if (dirs.charAt(i) == 'D') {
				nx = px-1;
				ny = py;
			} else if (dirs.charAt(i) == 'L') {
				nx = px;
				ny = py-1;
			} else if (dirs.charAt(i) == 'R') {
				nx = px;
				ny = py+1;
			}
			String temp = String.valueOf(px) + String.valueOf(py) + String.valueOf(nx) + String.valueOf(ny);
			String temp2 = String.valueOf(nx) + String.valueOf(ny) + String.valueOf(px) + String.valueOf(py);
			if(!isValid(nx, ny)) continue;
			px = nx; py = ny;
			if(list.contains(temp) || list.contains(temp2)) continue;
			list.add(temp);
        }
        
		System.out.print(list.size());
        return list.size();
    }
	
	static boolean isValid(int x, int y) {
		return x>=-5 && y>=-5 && x<=5 && y<=5;
	}
}
