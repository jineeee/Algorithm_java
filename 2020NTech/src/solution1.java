
public class solution1 {
	
public static void main(String[] args) {
	int[][] arr = {{2, 5}, {3, 7}, {10, 11}};
		solution(arr);
	}

	static public int solution(int[][] flowers) {
		int answer = 0, minDay = 366, maxDay = 0;
		boolean[] days = new boolean[365];
		
		for(int index = 0; index<flowers.length; index++) {
			int start = flowers[index][0];
			int end = flowers[index][1];
			minDay = Math.min(start, minDay);
			maxDay = Math.max(maxDay, end);
			
			for(int index2 = start; index2<end; index2++) {
				days[index2] = true;
			}
		}
		
		for(int index = minDay; index<=maxDay; index++) {
			if(days[index]) answer++;
		}
		System.out.print(answer);
		return answer;
	}

}
