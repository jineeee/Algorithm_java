package Lv3;

import java.util.Arrays;

/*
 * 카카오 자물쇠와 열쇠
 * https://programmers.co.kr/learn/courses/30/lessons/60059
 */

public class Kakao04 {
	
	public static void main(String[] args) {
		
		int[][] key1 = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
		int[][] lock1 = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};
		int[][] key2 = {{0, 1}, {1, 0}};
		int[][] lock2 = {{1,1,1,1}, {1,1,0,1}, {1,0,1,1},{1,1,1,1}};
		solution(key1, lock1);
	}

	static int m, n;
	static int[][] newLock;
	
	public static boolean solution(int[][] key, int[][] lock) {
        boolean answer = false;
        
        m = key.length;
        n = lock.length;
        newLock = new int[n+2*(m-1)][n+2*(m-1)];
        for(int i=m-1; i<m-1+n; i++) 
        	for(int j=m-1; j<m-1+n; j++) 
        		newLock[i][j] = lock[i-(m-1)][j-(m-1)];

        for(int t=0; t<4; t++) {
        	int[][] newKey = turnKey(key);
        	int[][] paddingLock = Arrays.copyOf(newLock, newLock.length);
        	
        	if(moveKey(newKey, paddingLock)) {
        		answer = true;
        		break;
        	}
        	
        	key = Arrays.copyOf(newKey, m);
        }
        
        System.out.println(answer);
        return answer;
    }
	
	static boolean moveKey(int[][] key, int[][] lock) {
		boolean flag = true;
		
		for(int i=0; i<=lock.length-m; i++) { // lock 기준 행 번호
			for(int j=0; j<=lock.length-m; j++) { // lock 기준 열 번호
				flag = true;
				
				int[][] copyLock = copy(lock);
				int[][] newLock = checkOpen(i, j, key, copyLock);
				
				for(int p=m-1; p<m-1+n; p++)
					for(int q=m-1; q<m-1+n; q++)
		        			if(newLock[p][q]!=1) flag = false;
				
				if(flag) return true;
			}
		}	
		return flag;
	}
	
	static int[][] checkOpen(int i, int j, int[][] key, int[][] lock) {
		for(int p=0; p<m; p++)
			for(int q=0; q<m; q++) lock[p+i][q+j] += key[p][q];
			
		return lock;
	}
	
	static int[][] turnKey(int[][] key) {
		int[][] tempKey = new int[m][m];
		for(int i=0; i<m; i++)
			for(int j=0; j<m; j++) tempKey[i][j] = key[m-j-1][i];

		return tempKey;
	}
	
	static int[][] copy(int[][] arr) {
		int[][] temp = new int[arr.length][arr.length];
		for(int i=0; i<arr.length; i++)
			for(int j=0; j<arr.length; j++) temp[i][j] = arr[i][j];
			
		return temp;
	}
	
}
