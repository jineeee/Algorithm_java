package Oct;

public class solution2 {

	public static void main(String[] args) {
		int[][] arr = {{1, 1, 1, 1, 1, 1, 1, 1}, 
				{0, 1, 1, 1, 1, 1, 1, 1}, {0, 0, 0, 0, 1, 1, 1, 1}, 
				{0, 1, 0, 0, 1, 1, 1, 1}, {0, 0, 0, 0, 0, 0, 1, 1}, 
				{0, 0, 0, 0, 0, 0, 0, 1}, {0, 0, 0, 0, 1, 0, 0, 1}, {0, 0, 0, 0, 1, 1, 1, 1}};
		solution(arr);
	}

	static int[][] input;
	static int[] ans = new int[2];

	static public int[] solution(int[][] arr) {
		input = arr;
		recursive(arr.length, 0, 0);
		return ans;
	}

	static void recursive(int len, int row, int col) {
		if (len == 1) {
			ans[input[row][col]]++;
		} else {
			boolean zeroFlag = false;
			boolean oneFlag = false;
			for (int i = row; i < row + len; i++) {
				for (int j = col; j < col + len; j++) {
					if (input[i][j] == 0) zeroFlag = true;
					if (input[i][j] == 1) oneFlag = true;
				}
			}
			
			if (!zeroFlag) ans[1]++;
			else if (!oneFlag) ans[0]++;
			else {
				len /= 2;
				recursive(len, row, col);
				recursive(len, row, col + len);
				recursive(len, row+len, col);
				recursive(len, row+len, col+len);
			}
		}
	}
}
