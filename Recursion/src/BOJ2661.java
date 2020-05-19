import java.util.*;

public class BOJ2661 {
	static int n;
	static int[] result;
	static int print = 1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		result = new int[n];
		int k=1;
		int i=2;
		k = i<<2;
//		System.out.print(k);
		combi(0);
	}
	
	static void combi(int current) {
		if(print==0) return;
		else if(current==n) {
			System.out.println(Arrays.toString(result));
			String tempString = "";
			for(int i:result) tempString += i;
//			for(int i=0; i<n/2; i++) {
//				for(int j=i+2; j<n/2; j++) {
//					if(tempString.substring(i,j).equals(tempString.substring(j,2*j))) return;
//				}
//			}
			System.out.println(tempString);		
			print = 0;
		}else {
			for(int i=1; i<=3; i++) {
				result[current] = i;
				
				String tempString = "";
				int check=0;
				for(int j=0; j<=current; j++) tempString += result[j];
				if(current-1>=0&&result[current]==result[current-1]) continue;
				
				if(checkNum(result, current+1)) {
					System.out.println(Arrays.toString(result));
					combi(current+1);
				}
			}
		}
	}
	
	static boolean checkNum(int[] re, int len) {
		String tempString = "";
		for(int i=0; i<len; i++) {
			tempString += re[i];
		}
		for(int i=0; i<=len/2; i++) {
			for(int j=2; j<=len/2; j++) {
//				if(i>len || j>len) break;
				System.out.println(tempString);
				if(i+j==len) {
					tempString.substring(i,i+j).equals(tempString.substring(j));
					return false;
				}
				else if(tempString.substring(i,i+j).equals(tempString.substring(j,2*j))) return false;
			}
		}
		return true;
	}
}
