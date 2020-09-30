package week11;

import java.io.*;
import java.util.Arrays;

/*
 * 백준 전화번호 - Trie, 트리
 * https://www.acmicpc.net/problem/5052
 */

public class BOJ5052_trie {
	
	static class Trie{
		boolean flag;
		Trie[] child;
		
		public Trie() {
			flag = false;
			child = new Trie[NUMS];
			for(int i=0; i<NUMS; i++) child[i] = null;
		}
	}
	
	static final int NUMS = 10;
	static Trie root;
	
	static boolean insert(String key) {
		Trie current = root;
		int len = key.length();
		int idx=0; // 문자열을 숫자로 바꿔 배열의 인덱스 값으로 사용
		
		for(int i=0; i<len; i++) {
			idx = key.charAt(i)-'0'; 
			if(current.child[idx]==null) // 처음 등장하는 노드라면 현재 노드의 자식으로 추가
				current.child[idx] = new Trie();
			current = current.child[idx];
			
			if(current.flag && i+1<len) // 문자 중간에 다른 문자의 마지막 노드가 등장하는 경우
				return false;
		}
		current.flag = true; // 마지막 current는 가장 마지막 노드를 가리키게됨
		return true;
	}
	
//	static boolean available(String key) {
//		Trie current = root;
//		int len = key.length();
//		int idx;
//		
//		for(int i=0; i<len; i++) {
//			System.out.println(key + " " + key.charAt(i) + " " + current.flag);
//			if(current.flag) return false; // 현재 노드가 마지막 노드라면 false 반환
//			
//			idx = key.charAt(i)-'0';
//			current = current.child[idx];
//		}
//		return true;
//	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			int n = Integer.parseInt(br.readLine());
			root = new Trie();
			String[] num = new String[n];
			for(int i=0; i<n; i++) num[i] = br.readLine();

			Arrays.sort(num); // 짧은 문자열부터 트라이 구조에 추가
			boolean ans = true;
			for(int i=0; i<num.length; i++) {
				if(!insert(num[i])) { // 트라이 구조에 추가
					ans = false;
					break;
				}
			}
			if(ans) System.out.println("YES");
			else System.out.println("NO");
		}
		
		
	}
	
}
