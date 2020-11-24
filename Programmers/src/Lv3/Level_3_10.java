package Lv3;

public class Level_3_10 {

	public static void main(String[] args) {
//		solution(new int[] {0, 3, 3, 0, 7, 2, 0, 2, 2, 0});
		solution(new int[] {5,2,3,3,5,3});
	}
	
	
	static public int solution(int[] a) {
		int answer = -1;
		
		// 배열에 나온 원소들의 등장 횟수 카운트
		int[] cnt = new int[a.length+1];
		for(int i : a) cnt[i]++;
		
		for(int i=0; i<cnt.length; i++) { // i는 a 배열에 들어가 있는 값
			if(cnt[i]==0) continue;
			if(cnt[i]<=answer) continue;
			
			int result = 0;
			for(int j=0; j<a.length-1; j++) {
				if(a[j]!=i && a[j+1]!=i) continue;
				if(a[j]==a[j+1]) continue;
				
				j++; // 크기가 2인 부분배열을 검사했으므로 인덱스+1
				result++; // i값이 몇번 사용되었는지 카운트
			}
			answer = Math.max(answer, result);
		}
		
		// 부분 배열의 길이는 (모든 배열에 공통으로 들어간 값의 등장횟수*2)
        return answer*2;
    }
}
