package Lv1;

import java.util.Stack;

/*
 * board에 들어있는 모양
 * 0 0 0 0 0 b[0][n]
 * 0 0 1 0 3 b[1][n]
 * 0 2 5 0 1 b[2][n]
 * 4 2 4 4 2 b[3][n]
 * 3 5 1 3 1 b[4][n]
 * 
 * 실행 시 뽑히는 인형들
 * 4 3 1 1 3 2 X 4
 */

public class Kakao1 {
	static int[][] b = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}}; 
	static int[] m = {1,5,3,5,1,2,1,4};
	static Stack<Integer> basket = new Stack<Integer>();
	static int count;
	
	static public void checkBasket(int curDoll) {
		if(basket.isEmpty()) { // basket이 빈 경우 (빈 stack은 peek() 실행 불가)
			basket.push(curDoll);
			System.out.println(curDoll + " : 1번 push 실행");
		} else if(basket.peek() == curDoll) { // 최근 들어간 인형과 현재 인형이 같은 경우
			System.out.println(curDoll + " : pop실행");
			basket.pop();
			count++;
		} else { // 최근 들어간 인형이 현재 인형과 다른 경우
			basket.push(curDoll);
			System.out.println(curDoll + " : 2번 push 실행");
		}
	}
	
	static public int solution(int[][] board, int[] moves) {
		int answer = 0;

		for(int i=0; i<moves.length; i++){ // 크레인 작동 횟수만큼 반복문 실행
			int crane = moves[i]-1;
			
			for(int j=0; j<board.length; j++) { // 해당 열의 모든 요소 탐색
				int doll = board[j][crane];
				
				if(doll == 0) continue; // 인형이 없는 곳에서 크레인을 작동시킨 경우
				else{
					checkBasket(doll);	
					board[j][crane] = 0;
					break; // 인형 하나를 뽑으면 다음 인형을 탐색할 필요가 없으므로 반복문 실행 중지
				}
			}
		}
		answer = count*2;
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.print(solution(b, m));
	}
}
