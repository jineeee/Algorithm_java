public class Sort_mergeSort {
	private static int data[] = {2, 12, 8, 7, 5, 15, 10};

	//이미 정렬된 인덱스가 p에서 q까지인 배열1과 q+1에서 r까지인 배열2를 합치면서 정렬하는 함수
	private static void merge(int[] data, int left, int mid, int right) {
		int i = left; //배열1의 시작 인덱스
		int j = mid+1; //배열2의 시작 인덱스
		int k = left; //임시 배열의 시작 인덱스
		int[] temp = new int[data.length]; //원래 데이터가 저장된 배열과 크기가 같은 임시 배열

		while(i<=mid && j<=right) { //한쪽 배열의 탐색이 모두 끝날때까지 반복문 실행
			if(data[i]<=data[j]) //배열1의 요소가 더 작다면
				temp[k++] = data[i++]; //임시 배열에 삽입 후 인덱스 증가
			else
				temp[k++] = data[j++];
		}
		//탐색이 끝난 후 남은 데이터를 옮기는 과정
		while(i<=mid) //배열1에 남은 데이터가 있는 경우
			temp[k++] = data[i++];
		while(j<=right) //배열2에 남은 데이터가 있는 경우
			temp[k++] = data[j++];
		for(int t=left; t<=right; t++) //임시 배열의 값을 원래 배열로 옮김
			data[t] = temp[t];
	}
	
	private static void mergeSort(int[] data, int left, int right) {
		if(left<right) {
			int mid = (left+right)/2;
			mergeSort(data, left, mid);
			mergeSort(data, mid+1, right);
			merge(data, left, mid, right);
		}
	}
	
	public static void main(String[] argf) {
		mergeSort(data, 0, data.length-1);
		for(int a : data)
			System.out.print(a+" ");
	}
}
