package Lv3;

import java.util.*;

public class Level_3_08 {

	public long solution(int n, int[] times) {
        long answer = 0;
        
        boolean[] box = new boolean[times.length]; // 창구가 찼는지
        Arrays.fill(box, true);
        
        Queue<int[]> queue = new LinkedList<>();
        boolean[] check = new boolean[n];
        for(int i=0; i<times.length; i++){
            queue.offer(new int[] {0+times[i], i});
            check[i] = true;
        }
        
        int idx = times.length; // 고객 번호
        int sec = 0; // 현재 초
        
        while(!queue.isEmpty()){
            sec++;
            while(queue.peek()[0]==sec){
                int[] p = queue.poll();
                box[p[1]] = false;
            }
            
            for(int i=0; i<box.length; i++){
                if(!box[i]){
                    queue.offer(new int[] {sec+times[i], i});
                    box[i] = true;
                }
            }
        }
        return sec;
    }
}
