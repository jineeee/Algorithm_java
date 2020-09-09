package Lv3;

import java.util.*;

/*
 * 카카오 - 외벽점검 (포기..)
 * https://programmers.co.kr/learn/courses/30/lessons/60062
 */

public class Kakao11 {
	
	public static void main(String[] args) {
		int[] weak1 = {1, 5, 6, 10};
		int[] dist1 = {1,2,3,4};
		int[] weak2 = {1, 3, 4, 9, 10};
		int[] dist2 = {3,5,7};
		solution(12, weak1, dist1);
	}
	
	static int[][] weakList;
	static int ans = Integer.MAX_VALUE;
	
	// 외벽의 길이 n, 취약 지점의 위치가 담긴 배열 weak, 각 친구가 1시간 동안 이동할 수 있는 거리가 담긴 배열 dist
	public static int solution(int n, int[] weak, int[] dist) {
        
        makeWeakList(weak);
//        for(int i=0; i<weak.length; i++) System.out.println(Arrays.toString(weakList[i]));
        
        for(int i=1; i<=dist.length; i++) // 친구들 순열
        	permu(i, 0, new boolean[dist.length], new int[i], dist);
        
        return ans;
    }
	
	static void permu(int n, int current, boolean[] visit, int[] result, int[] dist) {
		if(current==n) {
			System.out.println(Arrays.toString(result));
			getSearch(result);
		}else {
			for(int i=0; i<dist.length; i++) {
				if(visit[i]) continue;
				result[current] = dist[i];
				visit[i] = true;
				permu(n, current+1, visit, result, dist);
				visit[i] = false;
			}
		}
	}
	
	static void makeWeakList(int[] weak) {
		weakList = new int[weak.length][weak.length];
		
		for(int i=0; i<weak.length; i++) {
			for(int j=0; j<weak.length; j++) {
				if(i+j<weak.length) weakList[i][j] = weak[i+j];
				else weakList[i][j] = weak[(i+j)%weak.length];
			}
		}
	}
	
	static void getSearch(int[] result) {
		for(int[] weak : weakList) {
			boolean[] fix = new boolean[weak.length];
			int idx = 0, start = 0;
			
			while (idx!=result.length) {
				int i = start;
				int value = result[idx++];
				
				for(int j=start; j<weak.length; j++) {
					if(!(weak[i]<= weak[j] && weak[j] <= weak[i]+value)) break;
					fix[i] = true;
					start++;
				}
			}
		}
	}
	
}
