import java.util.*;

/*
 * 정점 0에서 3까지 가는데 걸리는 시간 구하기
 * input
 * 0 1
 * 0 2
 * 1 3
 */

public class example1 {
	static boolean[] check = new boolean[4];
	static int[] result = new int[4];
	static LinkedList<LinkedList<Integer>> list = new LinkedList<LinkedList<Integer>>();
	static Queue<Integer> queue = new LinkedList<Integer>();

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		for(int i=0; i<4; i++) list.add(new LinkedList<Integer>());
		for(int i=0; i<3; i++) {
			int a = scanner.nextInt();
			int b = scanner.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		System.out.println(list);
		getResult();
		System.out.println(result[3]);
	}
	
	static void getResult() {
		queue.offer(0);
		check[0] = true;
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0; i<list.get(now).size(); i++) {
				int dot = list.get(now).get(i);
				
				if(check[dot]) continue;
				check[dot] = true;
				result[dot] = result[now]+1;
				queue.offer(dot);
			}
		}
	}
}
