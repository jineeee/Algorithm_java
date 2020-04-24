public class Sort_quickSort {
	private static int data[] = {5, 11, 8, 4, 9, 13, 6, 2, 7};
	
	private static int partition(int[] data, int left, int right) {
		int pivot = data[(left+right)/2]; //pivot을 배열의 가운데 값으로 지정
		int low = left;
		int high = right;
		
		while(low<high) { //low화 high의 교차가 일어나지 않는 동안
			while(data[low]<pivot) //왼쪽에서 pivot보다 큰 데이터가 나올때까지 인덱스 증가 
				low++;
			while(data[high]>pivot) //오른쪽에서 pivot보다 작은 데이터가 나올때까지 인덱스 감소
				high--;
			if(low<high) { //위 두개의 반복문을 모두 빠져나왔다면 두 개의 값을 교환
				int temp = data[low];
				data[low] = data[high];
				data[high] = temp;
			}
		}
		return low; //pivot의 위치 반환
	}
	
	private static void quickSort(int[] data, int left, int right) {
		if(left<right) { //정렬할 데이터가 2개 이상이면
			int p = partition(data, left, right); //partition 함수를 호출하여 pivot을 기준으로 리스트를 분할
			//pivot을 제외한 두 부분을 대상으로 quickSort를 순환 호출
			quickSort(data, left, p-1); //왼쪽 리스트 정렬 
			quickSort(data, p+1, right); //오른쪽 리스트 정렬
		}
	}
	
	public static void main(String[] args) {
		quickSort(data, 0, data.length-1);
		for(int a : data) {
			System.out.print(a + " ");
		}
	}
}
