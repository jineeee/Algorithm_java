
public class solution2 {
	
	public static void main(String[] args) {
		solution(5);
	}
	
	static public int solution(int N) {
        int arr[] = new int[N+1];
        arr[1] = 1;
        arr[2] = 2;
        for(int i=3; i<=N; i++) {
        	arr[i] = arr[i-1] + arr[i-2];
        }
        
        System.out.print(arr[N]);
        return arr[N];
    }

}
