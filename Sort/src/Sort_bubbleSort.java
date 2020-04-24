public class Sort_bubbleSort {
	private static int data[] = {7, 1, 10, 3, 5, 9, 2};
	
	private static void bubble(int[] data, int length) {
		for(int i=length-1; i>0; i--) { //정렬이 완료된 부분은 제외
			for(int j=0; j<i; j++) { //정렬이 완료되지 않은 부분 중 맨 왼쪽부터 비교
				if(data[j] > data[j+1]) { //연속 두개의 원소를 비교
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		bubble(data, data.length);
		for(int a : data) {
			System.out.print(a + " ");
		}
	}
}
