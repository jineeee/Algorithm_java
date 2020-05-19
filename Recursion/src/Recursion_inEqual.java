import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 재귀 - 부등호를 만족하는 수 구하기
 * https://haejun0317.tistory.com/99
 */

public class Recursion_inEqual {
	static int n; // 부등호의 개수
	static String[] equal; // 부등호를 잘라서 넣을 배열
	static int len; // 숫자의 길이는 부등호의 개수 +1
	static int[] result; // 조합된 숫자를 구할 때 쓸 배열
	static int[] check; // 사용한 숫자인지 표시할 때 쓸 배열 
	static int printMin = 1; // 최소값 하나만 출력할 때 쓸 값
	static int printMax = 1; // 최대값 하나만 출력할 때 쓸 값
	
	static void getMin(int x) { // 최소값을 구하는 함수, x는 숫자의 자리수
		if(printMin==0) return; // 숫자를 하나만 출력 후 return
		
		if(x==len) { // 기저조건
			int correct = 1; // 부등호를 만족하면 1, 그렇지않으면 0
			
			for(int i=0; i<n; i++) { // 부등호를 만족하는지 비교하는 반복문
				if(equal[i].equals("<")) {
					if(result[i]>=result[i+1]) {
						correct = 0;
						break;
					}
				} else {
					if(result[i]<=result[i+1]) {
						correct = 0;
						break;
					}
				}
			}
			
			if(correct==1) { // 조합된 숫자를 출력하는 부분
				for(int i=0; i<len; i++) {
					System.out.print(result[i]);
				}System.out.println();
				printMin = 0;
			}
				
		}else { // 조합 만들기
			for(int i=0; i<=9; i++) { // 고를 수 있는 수는 0부터 9까지
				if(check[i]==0) {
					result[x] = i;
	                check[i] = 1; // 숫자 i를 사용했다고 표시
	                getMin(x+1);
	                check[i] = 0;
				}
			}
		}
	}
	
	static void getMax(int x) { // 최대값을 구하는 함수, x는 숫자의 자리수
		if(printMax==0) return; // 숫자를 하나만 출력 후 return
		
		if(x==len) { // 기저조건
			int correct = 1; // 부등호를 만족하면 1, 그렇지않으면 0
			
			for(int i=0; i<n; i++) { // 부등호를 만족하는지 비교하는 반복문
				if(equal[i].equals("<")) {
					if(result[i]>=result[i+1]) {
						correct = 0;
						break;
					}
				} else {
					if(result[i]<=result[i+1]) {
						correct = 0;
						break;
					}
				}
			}
			
			if(correct==1) { // 조합된 숫자를 출력하는 부분
				for(int i=0; i<len; i++) {
					System.out.print(result[i]);
				}System.out.println();
				printMax = 0;
			}
				
		}else { // 조합 만들기
			for(int i=9; i>=0; i--) { // 고를 수 있는 수는 0부터 9까지
				if(check[i]==0) {
					result[x] = i;
	                check[i] = 1; // 숫자 i를 사용했다고 표시
	                getMax(x+1);
	                check[i] = 0;
				}
			}
		}
	}
	
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		equal = new String[n];
		for (int i=0; i<n; i++) {
			equal[i] = st.nextToken();
		}
		len = n+1;
		result = new int[len];
		check = new int[1000];
		getMin(0);
		getMax(0);
	}
}
