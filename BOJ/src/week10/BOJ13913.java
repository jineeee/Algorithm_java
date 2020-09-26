package week10;

import java.io.*;
import java.util.*;

/*
 * 숨바꼭질4 - bfs
 * https://www.acmicpc.net/problem/13913
 */

public class BOJ13913 {
	
	static int N, K, ans = Integer.MAX_VALUE;
	static int[] parent = new int[100001];
    static int[] time = new int[100001];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String[] arr = bufferedReader.readLine().split(" ");
		N = Integer.parseInt(arr[0]);
		K = Integer.parseInt(arr[1]);
		
		bfs();
		
		Stack<Integer> stack = new Stack<>();
        stack.push(K); // 동생 위치 
        int index = K;

        while (index != N) {
            stack.push(parent[index]);
            index = parent[index];
        }

        // 최종 출력
        StringBuilder sb = new StringBuilder();
        sb.append(time[K] - 1 + "\n");
        while (!stack.isEmpty()) {
            sb.append(stack.pop() + " ");
        }
        System.out.println(sb.toString());
        
	}
	
	static void bfs() {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.offer(N);
		time[N] = 1;
		
		while (!queue.isEmpty()) {
			int nowSubin = queue.poll();
			
			if(nowSubin==K) return;
			
			for(int i=0; i<3; i++) {
				int nextSubin;
				
				if(i==0) nextSubin = nowSubin+1;
				else if(i==1) nextSubin = nowSubin-1;
				else nextSubin = nowSubin*2;
				
				if(!isValid(nextSubin) || time[nextSubin]!=0) continue;
				
				queue.offer(nextSubin);
				time[nextSubin] = time[nowSubin]+1;
				parent[nextSubin] = nowSubin;
			}
		}
	}
	
	static boolean isValid(int x) {
		return x>=0 && x<=100000;
	}

}
