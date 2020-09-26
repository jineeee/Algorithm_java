package Lv3;

/*
 * 기지국 설치 - 그리디 
 * https://programmers.co.kr/learn/courses/30/lessons/12979
 */

public class Level_3_04 {

	public static void main(String[] args) {
		solution(11, new int[] {4, 11}, 1);
	}
	
	static public int solution(int n, int[] stations, int w) {
        int answer = 0, location = 1, idx = 0;
        
        while(location<=n) {
        	// 현재 위치가 빌딩 개수를 안넘어가고, 기지국 범위 내에 있을 때
        	if(idx<stations.length && location>=stations[idx]-w) {
        		location = stations[idx]+w+1;
        		idx++;
        	}else { // 기지국을 설치해야 할 상황일 떄
				location += 2*w+1;
				answer++;
			}
        }
        
        return answer;
    }
}
