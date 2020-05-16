package week1;

import java.io.*;
import java.util.*;

public class BOJ2477 {
	static int apple;
	static int[] map = new int[6];
	static int w=0, h=0, w2=501, h2=501;
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		apple = sc.nextInt();
		
		for(int i=0; i<6; i++) {
			int s = sc.nextInt();
			map[i] = sc.nextInt();
			if(i%2==0) w = Math.max(w, map[i]);
			else h = Math.max(h, map[i]);
		}
//		System.out.println(Arrays.toString(map));
		
		for(int i=0; i<6; i++) {
			if (i % 2 == 0) {
	            if (h == map[(i + 5) % 6] + map[(i + 1) % 6])  w2 = map[i];
	        } else {
	            if (w == map[(i + 5) % 6] + map[(i + 1) % 6]) h2 = map[i];
	        }
		}
		int result = w*h - w2*h2;
		System.out.print(result*apple);
	}
}
