package week5;

import java.util.*;

/* 
 * 백준 트럭 - 큐 사용
 * https://www.acmicpc.net/problem/13335
 */

public class BOJ13335 {
	static int n, w, l;
	static int[] truck;
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		w = scanner.nextInt();
		l = scanner.nextInt();
		truck = new int[n];
		for(int i=0; i<n; i++) truck[i] = scanner.nextInt();
		System.out.println(cross()+w);
	}
	
	static int cross() {
		int weight=0, time=0;
		for(int i=0; i<n; i++) {
			while (true) {

				if(queue.isEmpty()) { // 다리에 차가 없을 때
					queue.offer(truck[i]);
					time++;
					weight += truck[i];
					break;
				} else if(queue.size()==w) { // 다리가 꽉 찼을 때
					weight -= queue.remove();
				} else { // 다리에 차가 들어갈 자리가 있을 떄
					if(weight+truck[i] > l) { // 최대하중 초과
						queue.offer(0);
						time++;
					}else {
						queue.offer(truck[i]);
						time++;
						weight += truck[i];
						break;
					}
				}
			}
		}
		return time;
	}
}
