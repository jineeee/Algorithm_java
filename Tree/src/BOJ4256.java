import java.io.*;
import java.util.*;

/*
 * 백준 4256 - 전위/중위 표기식으로 후위표기식 만들기
 * https://www.acmicpc.net/problem/4256
 */

public class BOJ4256 {
	
	static String postString;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		while(t-- > 0) {
			
			postString = "";
			
			int n = Integer.parseInt(br.readLine());
			int[] pre = new int[n];
			int[] in = new int[n];
			ArrayList<Integer> preList = new ArrayList<Integer>();
			ArrayList<Integer> inList = new ArrayList<Integer>();
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				pre[i] = Integer.parseInt(st.nextToken());
				preList.add(pre[i]);
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<n; i++) {
				in[i] = Integer.parseInt(st.nextToken());
				inList.add(in[i]);
			}
			
			postOrder(preList, inList);
			System.out.println(postString);
		}
	}
	
	static void postOrder(ArrayList<Integer> pre, ArrayList<Integer> in) {
		if(pre.isEmpty()) return;
		int root = pre.get(0);
		
		int cntL = 0;
		for(int i=0; i<in.size(); i++) {
			if(in.get(i)==root) {
				cntL = i;
				break;
			}
		}
		
		ArrayList<Integer> leftPre = new ArrayList<Integer>(pre.subList(1, cntL+1));
		ArrayList<Integer> rightPre = new ArrayList<Integer>(pre.subList(cntL+1, pre.size()));
		ArrayList<Integer> leftIn = new ArrayList<Integer>(in.subList(0, cntL));
		ArrayList<Integer> rightIn = new ArrayList<Integer>(in.subList(cntL+1, pre.size()));
		
		postOrder(leftPre, leftIn);
		postOrder(rightPre, rightIn);
		
		postString += String.valueOf(root) + " ";
	}

}
