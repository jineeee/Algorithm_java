public class Sort_heapSort_maxHeapify {
	static int size = 0; //데이터가 추가되어 있는 부분만큼의 배열의 길이
	private static void swap(int[] data, int a, int b) {
		int temp = data[a];
		data[a] = data[b];
		data[b] = temp;
	}
	
	private static void print(int[] data) {
		for(int i=0; i<data.length; i++) { //size보다 1 작을 때까지 출력
			System.out.print(data[i] + " ");
		} System.out.println("\n");
	}
	
	private static void buildMaxHeap(int[] data) {
		int length = data.length+1;
		for(int i = (length/2)-1; i>=0; i--) { //배열은 0부터 시작하므로 -1 수행
			maxHeapify(data,i);
		}	
	}

	private static void maxHeapify(int[] data, int i) { //data는 배열,i는 루트 노드의 인덱스
		int root = i;
		int length = data.length;
		int leftChild = (i*2)+1; //배열은 0부터 시작하므로 +1
		int rightChild = (i*2)+2; //배열은 0부터 시작하므로 +2
		
		//리프 노드까지 탐색을 끝냈을 때
		if(leftChild > length && rightChild > length)
			return;

		//leftChild가 존재하고. 루트 노드의 값보다 클 때
		if(leftChild<length && data[leftChild]>data[i])  //leftChild가 존재하고 루트 노드의 값보다 클 때
			root = leftChild; //루트에 leftChild의 인덱스 할당
		
		//rightChild가 존재하고, 루트 노드의 값보다 크거나 leftChild의 값보다도 클 때
		if (rightChild<length && data[root]<data[rightChild]) 
			root = rightChild; //루트에 rightChild의 인덱스 할당
		
		//기존 루트보다 큰 값의 자식이 있을 때
		if(root != i) {
			swap(data, i, root); //실제 노드의 값 교환
			maxHeapify(data, root); //변경된 루트로 다시 max heapify 진행 
		}
	}

	public static void main(String[] args) {
		int data[] = { 5, 2, 100, 7, 12, 42, 62, 52};
		buildMaxHeap(data); //max heap property를 만족하도록 정렬
		print(data); //max heap 출력
	}
}
