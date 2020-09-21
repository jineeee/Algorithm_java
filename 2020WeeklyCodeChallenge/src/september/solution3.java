package september;

/*
 * 풍선 터뜨리기 - DP
 * https://programmers.co.kr/learn/courses/30/lessons/68646
 */

public class solution3 {
	
	public static void main(String[] args) {
		int[] arr = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
		solution(arr);
	}

	static int solution(int[] a) {
        int answer = 2; // 양 끝 두개는 무조건 가능
        int min = Integer.MAX_VALUE;
        int minIdx=0;
        for(int i=0; i<a.length; i++) {
        	if(a[i]<min) {
        		min = a[i];
        		minIdx = i;
        	}
        }
        
        int leftMin = a[0];
        for(int i=1; i<minIdx; i++) {
        	if(a[i]>leftMin) continue;
        	leftMin = a[i];
        	answer++;
        }
        
        int rightMin = a[a.length-1];
        for(int i=a.length-2; i>minIdx; i--) {
        	if(a[i]>rightMin) continue;
        	rightMin = a[i];
        	answer++;
        }
        
        if(minIdx!=0 && minIdx!=a.length-1) answer++;
        System.out.print(answer);
        return answer;
    }
	
}
