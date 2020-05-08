package recursive_maze;

public class Recursion_NQueens {
	/*
     * 모든 조건을 만족하는 방법을 찾으려면
     * 1) level(행)번째 말들을 차례대로 모든 위치에 놓아보고
     * 2) 조건에 부합하지 않는 경우 바로 직전에 움직인 말의 위치 수정
     */
	private final static int N = 8;
	private static int [] cols = new int[N+1];
	
	private static boolean queens(int level) {
		if(!promising(level)) //더 이상 다음 경우를 탐색 할 필요가 없는 경우(해당 자리에 놓으면 안되는 경우)
			return false;
		else if(level == N) { //첫번째 if문을 통과하였으며, 모든 말이 다 놓인 경우
			for (int i = 1; i <= N; i++)
		        System.out.println("(" + i + ", " + cols[i] + ")");
			return true;
		}
		//첫번째 if문을 통과하였으므로 현재 level의 말의 위치는 놓아도 되는 자리
		//밑의 for문은 자식 노드를 recursive하게 방문
		for(int i=1; i <=N; i++) { //1번부터 N번째 열까지 놓아보는 반복문
			cols[level + 1] = i; //level+1번째 말을 (level+1행,i열)의 위치에 놓겠다는 뜻
			if(queens(level+1)) //(level+1행,i열)의 위치가 유효한지 검사하기 위해 함수 호출
				return true; //다음 말이 놓이면 true 반환하여 반복문을 나옴
		}
		return false; //해결 가능한 방법이 없음
	}
	
	/*
     * 다음 경로를 탐색할 필요가 없는 경우
     * 1) 이전 말들과 비교하여 같은 열에 놓인 경우 
     * 2) 이전 말들과 비교하여 대각선 상에 놓인 경우
     */
	private static boolean promising(int level) { //다음 경우를 탐색할 필요가 있는지 검사하는 함수
		for(int i=1; i<level; i++) { //이전 level에 놓인 말들과 조건 검사 수
			if(cols[i] == cols[level]) //같은 열에 놓인 경우
				return false;
			else if((level - i) == Math.abs(cols[level] - cols[i])) //대각선 상에 놓인 경우
				return false;
		}
		return true; //같은 열 또는 대각선 상에 놓이지 않았다면 true 반환
	}
	
	public static void main(String[] args) {
		queens(0);
	}
}
