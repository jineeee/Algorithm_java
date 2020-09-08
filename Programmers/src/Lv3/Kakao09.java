package Lv3;

import java.util.*;

/*
 * 카카오 - 이진트리, 전위순회, 후위순회
 * https://programmers.co.kr/learn/courses/30/lessons/42892
 */

class Node{
	int idx, x, y;
	Node left = null, right = null;
	
	public Node(int idx, int x, int y) {
		this.idx = idx;
		this.x = x;
		this.y = y;
	}
}

public class Kakao09 {
	
	public static void main(String[] args) {
		
		int[][] arr = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
		solution(arr);	
	}

	static Node[] nodeArr;
	static int[][] answer;
	static int index = 0;
	
	public static int[][] solution(int[][] nodeinfo) {
		answer = new int[2][nodeinfo.length];
        nodeArr = new Node[nodeinfo.length];
        
        for(int i=0; i<nodeinfo.length; i++) nodeArr[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        
        Arrays.sort(nodeArr, new Comparator<Node>() {
			public int compare(Node o1, Node o2) {
				if(o1.y==o2.y) return Integer.compare(o1.x, o2.x); // x는 오름차순
				return Integer.compare(o2.y, o1.y); // y는 내림차순
			}	
		});
        
        
        Node root = nodeArr[0];
        for(int i=1; i<nodeArr.length; i++) addNode(root, nodeArr[i]);
        
        preorder(root);
        index = 0;
        postorder(root);
        
        return answer;
    }
	
	static void addNode(Node parent, Node child) {
		if(parent.x > child.x) {
			if(parent.left==null) parent.left = child;
			else addNode(parent.left, child);
		}else {
			if(parent.right==null) parent.right = child;
			else addNode(parent.right, child);
		}
	}
	
	static void preorder(Node root) {
		answer[0][index++] = root.idx;
		if(root.left!=null) preorder(root.left);
		if(root.right!=null) preorder(root.right);
	}
	
	static void postorder(Node root) {
		if(root.left!=null) postorder(root.left);
		if(root.right!=null) postorder(root.right);
		answer[1][index++] = root.idx;
	}
}
