package recursive_maze;

public class Recursion_blob {
	/*
     * blob의 크기를 구하려면
     * 1) image pixel이 아닐 경우 0 출력
     * 2) image pixel일 경우 북,북동,동,동남,남,남서,서,북서 8개의 픽셀이 포함된 blob의 크기를 구하여 +1
     */
	private static int BACKGROUND_COLOR = 0; //image pixel이 아닌 경우
	private static int IMAGE_COLOR = 1; //image pixel인 경우
	private static int ALREADY_COUNTED = 2; //이미 blob의 크기를 계산한 pixel인 경우
	private static int N = 8;
	private static int[][] grid = {
		      {1, 0, 0, 0, 0, 0, 0, 1},
		      {0, 1, 1, 0, 0, 1, 0, 0},
		      {1, 1, 0, 0, 1, 0, 1, 0},
		      {0, 0, 0, 0, 0, 1, 0, 0},
		      {0, 1, 0, 1, 0, 1, 0, 0},
		      {0, 1, 0, 1, 0, 1, 0, 0},
		      {1, 0, 0, 0, 1, 0, 0, 1},
		      {0, 1, 1, 0, 0, 1, 1, 1},
		  };
	
	public static int countCells(int x, int y) {
		if(x<0 || x>=N || y<0 || y>=N) //구하려는 pixel의 좌표가 유효하지 않은 경우
			return 0;
		else if (grid[x][y] != IMAGE_COLOR) //구하려는 pixel이 image pixel이 아니거나 이미 탐색한 경우
			return 0;
		else { //위의 두 경우가 아닌 경우 탐색 시작
			grid[x][y] = ALREADY_COUNTED; //count한 pixel로 표시
			//현재 pixel에 인접한 8개의 pixel이 포함된 blob의 크기를 구하여 더한 값이 결과
			return 1 + countCells(x-1, y) + countCells(x-1, y+1) + countCells(x, y+1) +
					countCells(x+1, y+1) + countCells(x+1, y) + countCells(x+1, y-1) +
					countCells(x, y-1) + countCells(x-1, y+1);
		}
	}
	
	public static void printGrid() {
		for(int x=0; x<N; x++) {
			System.out.print("{");
			for(int y=0; y<N; y++) {
				if(y < N-1) 
					System.out.print(grid[x][y] + ", ");
				else 
					System.out.print(grid[x][y]);
			}
			System.out.println("}");
		}
	}
	
	public static void main(String [] args) {
		System.out.println("result : " + countCells(0,0));
		printGrid();
	}
}
