public class Sort_selectionSort {
	private static int data[] = {7, 1, 3, 5, 9, 2};
	
	//최대 원소를 맨 오른쪽으로 이동시키며 정렬
	public static void selectionSortMax(int[] data, int length) {
		int max; //값이 최대인 원소
		int temp;
		for(int i=data.length-1; i>0; i--) { //맨 오른쪽 원소부터 왼쪽에서 두번째 원소까지 탐색
			max = i; //정렬이 완료된 부분을 제외한 맨 오른쪽 원소를 max라고 가정
			for(int j=i-1; j>=0; j--) { //값이 최대인 원소를 찾기 위한 루프
				if(data[max] < data[j])
					max = j;
			}
			temp = data[i];
			data[i]= data[max];
			data[max] = temp;
		}
	}
	
	//최소 원소를 맨 왼쪽으로 이동시키며 정렬
	public static void selectionSortMin(int[] data, int length) {
		int min; //값이 최소인 원소
		int temp;
		for (int i=0; i<length-1; i++) { //맨 왼쪽 원소부터 오른쪽에서 두번째 원소까지 탐색
			min = i;
			for(int j=i+1; j<=length-1; j++) { //정렬이 완료된 부분을 제외하고 맨 오른쪽 원소까지 탐색
				if(data[j] < data[min])
					min=j;
			}
			temp = data[i];
			data[i] = data[min];
			data[min] = temp;
		}
	}
	
	public static void main(String[] args) {
		 selectionSortMin(data, data.length);
		 for(int a : data) {
			 System.out.print(a + " ");
		 }
	}

}
