package week5;

import java.util.Scanner;

/* 
 * 백준 z - 재귀
 * https://www.acmicpc.net/problem/1074
 */

public class BOJ1074 {
	static int n, r, c, count;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		r = scanner.nextInt();
		c = scanner.nextInt();
//		search(0,0,(int)Math.pow(2, n));
		search2();
	}
	
	static void search(int x, int y, int size) {
		if(size==1) {
			if(x==r && y==c)
				System.out.println(count);
			count++;
			return;
		}else {
			size = size/2;
			search(x, y, size);
			search(x, (y+size), size);
			search(x+size, y, size);
			search(x+size, y+size, size);
		}
	}
	
	static void search2() {
		int x=0, y=0, count=0, size=(int)Math.pow(2, n);
		while (size>0) {
			size /= 2;
			if(r<x+size && c<y+size) {
				count += size*size*0;
			}else if(r<x+size) {
				count += size*size*1;
				y += size;
			}else if(c<y+size) {
				count += size*size*2;
				x += size;
			}else {
				count += size*size*3;
				x += size;
				y += size;
			}

			if(size==1) {
				System.out.println(count);
				break;
			}
		}
		
	}
}
