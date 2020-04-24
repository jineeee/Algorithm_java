package recursive_maze;

public class Recursion_maze {
	/*
     * 현재 위치에서 출구까지 가는 경로가 있으려면
     * 1) 현재 위치가 출구이거나 혹은
     * 2) 이웃한 셀들 중 하나에서 현재 위치를 지나지 않고 출구까지 가는 경로가 있거나
     */
	private static int N = 8;
	private static int [][] maze = {
			{0, 0, 0, 0, 0, 0, 0, 1},   
            {0, 1, 1, 0, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 0, 0, 1, 1, 0, 0},
            {0, 1, 1, 1, 0, 0, 1, 1},
            {0, 1, 0, 0, 0, 1, 0, 1},
            {0, 0, 0, 1, 0, 0, 0, 1},
            {0, 1, 1, 1, 0, 1, 0, 0}
	};
	
	private static final int PATHWAY_COLOUR = 0;
	private static final int WALL_COLOUR = 1;
	private static final int BLOCKED_COLOUR = 2;
	private static final int PATH_COLOUR = 3;

	public static boolean findMazePath(int x, int y) { //경로를 탐색하는 함수
		if (x<0 || y<0 || x>=N || y>=N) { //현재 좌표가 유효한 위치가 아닌 경우
			return false;
		} else if (maze[x][y] != PATHWAY_COLOUR) { //현재 좌표가 탐색이 필요 없는 경우
			return false;
		} else if (x==N-1 && y==N-1) { //현재 좌표가 출구인 경우
			maze[x][y] = PATH_COLOUR;
			return true;
		} else { //위의 세 경우가 아닐 경우 경로 탐색
			maze[x][y]= PATH_COLOUR; //방문 표시
			if (findMazePath(x-1, y) || findMazePath(x, y+1) //인접한 4개의 cell에 대하여 recusive 함수 호출
					|| findMazePath(x+1, y) || findMazePath(x, y-1))
				return true; //위의 네개의 경우 중 하나라도 true일 시 true 리턴
		}
		maze[x][y] = BLOCKED_COLOUR; 
		return false;
	}
	
	public static void printMaze() {
		for(int x=0; x<N; x++) {
			System.out.print("{");
			for(int y=0; y<N; y++) {
				if(y < N-1) 
					System.out.print(maze[x][y] + ", ");
				else 
					System.out.print(maze[x][y]);
			}
			System.out.println("}");
		}
	}
	
	public static void main(String [] args) {
		findMazePath(0, 0);
		printMaze();
	}
}
