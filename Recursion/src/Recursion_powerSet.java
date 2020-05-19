public class Recursion_powerSet {
	
	private static char data[] = {'a','b','c','d','e','f'};
	private static int n = data.length; //위의 배열의 경우 n=6
	private static boolean [] include = new boolean [n]; //크기가 6인 boolean 값을 가진 배열
	
	public static void powerSet(int k) { //k는 배열의 index
		//상태공간트리 상에서 현재위치가 리프노드
		if(k==n) { //base case
			for (int i=0; i<n; i++) //배열의 모든 원소 출력
				if (include[i]) 
					System.out.print(data[i] + " ");
			System.out.println();
			System.out.println("if문 완료");
			return;
		}
		//리프노드의 위치가 아니라면,
		//data k를 포함하지 않는 경우 (트리상에서 왼쪽 노드)
		include[k] = false; //k를 포함하지 않는다는 표시
		powerSet(k+1);
		//data k를 포함하지 않는 경우 (트리상에서 오른쪽 노드)
		include[k] = true; //k를 포함한다는 표시
		powerSet(k+1);
	}
	
	public static void main(String[] args) {
		powerSet(0);
	}
}

