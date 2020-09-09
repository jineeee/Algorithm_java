import java.util.*;

/*
 * 백준 - 슬라이딩 윈도우
 * https://www.acmicpc.net/problem/2531
 */

public class BOJ2531 {
	
	static int n, d, k, c, ans = Integer.MIN_VALUE, arr[], visit[];
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		d = scanner.nextInt();
		k = scanner.nextInt();
		c = scanner.nextInt();
		
		arr = new int[n];
		visit = new int[d+1]; // 초밥 번호를 바로 인덱스로 사용하기 위해 +1
		for(int i=0; i<n; i++) arr[i] = scanner.nextInt();

		slide();
		System.out.println(ans);
	}
	
	static void slide() {
		int cnt = 0;
		
		// 첫번째 초밥부터 연속 접시 수 만큼 세어줌
		for(int i=0; i<k; i++) {
			if(visit[arr[i]]==0) cnt++; // 처음 먹는 초밥이라면 count를 올려줌
			visit[arr[i]]++; // 초밥 번호를 인덱스로 사용하여 먹었음을 표시
		}
		
		// 여기까지 수행 시 첫 영역에 포함된 초밥들이 visit 배열에 세어져 들어있다
		
		// 영역을 옆으로 한칸씩 밀어가면서 초밥의 종류 수를 업데이트 해줌
		for (int i = 0; i < n; i++) {
			if(ans<=cnt) { // 최대값 찾기
				if(visit[c]==0) ans = cnt+1;
				else ans = cnt;
			}

			visit[arr[i]]--; // 영역의 맨 왼쪽 초밥을 제외
			if (visit[arr[i]] == 0) // arr[i]번 초밥이 한번도 포함되지 않으면 종류를 1 빼줌
				cnt--;

			if (visit[arr[(i + k) % n]] == 0) // arr[i]번 초밥이 처음 먹는 초밥이라면 종류를 1 더해줌
				cnt++;
			visit[arr[(i + k) % n]]++; // 영역의 맨 오른쪽을 새로운 초밥으로 옮김
		}
	}

}
