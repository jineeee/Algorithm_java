import java.util.Arrays;

/*
 * 입국심사 - 이분탐색
 * https://programmers.co.kr/learn/courses/30/lessons/43238
 */

public class Imigration {
	
	public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        Arrays.sort(times);
        long left = 0; // 최소 소요 시간
        long right=(long)times[times.length-1]*(long)n; // 최대 소요 시간
        long mid;
        
        while(left<=right){
            mid = (left+right)/2;
            long cnt = 0L;
            for(int t : times) cnt+= mid/t;
            
            if(cnt>=n){
                right = mid-1;
                answer = Math.min(answer, mid);
            }else left = mid+1;
            
        }
        
        return answer;
    }

}
