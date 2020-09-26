public class solution4 {
	
	public static void main(String[] args) {
		int[][] arr = {{1,2},{3,4},{5,6},{-1,7},{8,9},{-1,-1},{-1,-1},{-1,-1},{-1,-1},{-1,-1}};
		int[][] arr2 = {{1,2},{-1,-1},{-1,-1}};
		
		int[][] arr3 = {{-1, 1}, {-1, -1}};
		solution(arr, arr3);
	}
	
	static class Node{
		int idx;
		Node left=null, right=null;
		
		public Node(int idx) {
			this.idx = idx;
		}
	}

	static Node[] nodeArr1, nodeArr2;
	
	static public int solution(int[][] t1, int[][] t2) {
        int answer = 0;
        
        nodeArr1 = new Node[t1.length];
        nodeArr2 = new Node[t2.length];
		for(int i=0; i<t1.length; i++) nodeArr1[i] = new Node(i);
		for(int i=0; i<t2.length; i++) nodeArr2[i] = new Node(i);
		
		for(int i=0; i<t1.length; i++) {
			int left = t1[i][0];
			int right = t1[i][1];
			if(left!=-1) nodeArr1[i].left = nodeArr1[left];
			if(right!=-1) nodeArr1[i].right = nodeArr1[right];
		}
		
		for(int i=0; i<t2.length; i++) {
			int left = t2[i][0];
			int right = t2[i][1];
			if(left!=-1) nodeArr2[i].left = nodeArr2[left];
			if(right!=-1) nodeArr2[i].right = nodeArr2[right];
		}
		
		for(int i=0; i<nodeArr1.length; i++) {
			if(checkSame(nodeArr1[i], nodeArr2[0])) answer++;
		}
        return answer;
    }
	
	static boolean checkSame(Node t1root, Node t2root) {
		if (t1root==null && t2root==null) return true;
		
		if(t1root.left==null&&t2root.left!=null) return false;
		if(t1root.right==null&&t2root.right!=null) return false;
		if(t2root.left==null&&t1root.left!=null) return false;
		if(t2root.right==null&&t1root.right!=null) return false;
		
		if(checkSame(t1root.left, t2root.left)&&checkSame(t1root.right, t2root.right)) return true;

		return false;
	}
}
