package week1;

import java.util.*;

public class BOJ2251 {
//	static Set<Integer> set = new HashSet<Integer>();
	static List<Integer> set = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int A = scanner.nextInt();
		int B = scanner.nextInt();
		int C = scanner.nextInt();
		
		set.add(C); // 옮기지 않은 경우
		if(B<=C && C-B<=A) set.add(B); // 
		System.out.println(set);
		
		if(A<=C && C-A<=B) set.add(A);
		System.out.println(set);
		
		if(C-B>=0) set.add(C-B); // B를 꽉채운 경우
		System.out.println(set);
		
		if(C-A>=0) set.add(C-A);
		System.out.println(set);
		
		List<Integer> list = new ArrayList<Integer>(set);
		Collections.sort(list);
		System.out.println(list);
	}
}
