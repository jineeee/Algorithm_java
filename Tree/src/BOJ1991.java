import java.io.*;
import java.util.*;

/*
 * 백준 1991 - 이진트리, 전위/중위/후위 탐색
 * https://www.acmicpc.net/problem/1991
 */

public class BOJ1991 {
	
	static class Node{
		char idx;
		Node left=null, right=null;
		
		public Node(char idx) {
			this.idx = idx;
		}
		
		public void print() {
			System.out.println(idx + " " + left + " " + right);
		}
	}
	
	static int idx = 0;
	static String[] strings;
	static Node[] nodeArr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		strings = new String[n];
		
		nodeArr = new Node[n];
		for(int i=0; i<n; i++) nodeArr[i] = new Node((char) ('A'+i));
		
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			char idx = st.nextToken().charAt(0);
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			if(left!='.') nodeArr[idx-'A'].left = nodeArr[left-'A'];
			if(right!='.') nodeArr[idx-'A'].right = nodeArr[right-'A'];
		}

		preorder(nodeArr[0]);
		for(String string : strings) System.out.print(string);
		System.out.println();
		idx = 0;
		
		inorder(nodeArr[0]);
		for(String string : strings) System.out.print(string);
		System.out.println();
		idx = 0;
		
		postorder(nodeArr[0]);
		for(String string : strings) System.out.print(string);
		
	}

	
	static void preorder(Node parent) {
		strings[idx++] = String.valueOf(parent.idx);
		if(parent.left!=null) preorder(parent.left);
		if(parent.right!=null) preorder(parent.right);
	}
	
	static void inorder(Node parent) {
		if(parent.left!=null) inorder(parent.left);
		strings[idx++] = String.valueOf(parent.idx);
		if(parent.right!=null) inorder(parent.right);
	}
	
	static void postorder(Node parent) {
		if(parent.left!=null) postorder(parent.left);
		if(parent.right!=null) postorder(parent.right);
		strings[idx++] = String.valueOf(parent.idx);
	}
}
