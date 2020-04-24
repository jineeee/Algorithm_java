
public class Sort_insertionSort {
	private static int data[] = {7, 1, 10, 3, 5, 9, 2};

	private static void insertionSort(int[] data, int length) {
		for(int i=1; i<length; i++) { //key는 두번째 원소에서 시작
			for(int j=i; j>0; j--) { //연속된 두 원소의 크기를 비교하여 정렬하는 루프
				if(data[j] < data[j-1]) {
					int temp = data[j];
					data[j] = data[j-1];
					data[j-1] = temp;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		insertionSort(data, data.length);
		for(int a : data) {
			System.out.print(a + " ");
		}
	}
}
