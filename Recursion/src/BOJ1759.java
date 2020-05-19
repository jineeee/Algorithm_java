import java.util.*;

public class BOJ1759 {
	static String[] arr;
	static boolean[] check;
	static String[] result;
	static String[] mo = {"a", "e", "i", "o", "u"};
	static int l, c;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		l = scanner.nextInt();
		c = scanner.nextInt();
		arr = new String[c];
		check = new boolean[c];
		result = new String[l];
		for(int i=0; i<c; i++) {
			arr[i] = scanner.next();
		}Arrays.sort(arr);
		permu(0,0,0,0);	
	}
	
	static void permu(int current, int start, int moCnt, int jaCnt) {
		if(current==l) {
			if(moCnt<1 || jaCnt <2) return;
			String tempString= "";
			for(String string : result) tempString += string;
			System.out.println(tempString);
		}else {
			for(int i=start; i<arr.length; i++) {
				if(check[i]) continue;
				result[current] = arr[i];
				if(current-1>=0 && result[current].compareTo(result[current-1])==-1) continue;
				check[i] = true;
				if(Arrays.asList(mo).contains(result[current])) permu(current+1, i+1, moCnt+1, jaCnt);
				else permu(current+1, i+1, moCnt, jaCnt+1);
				check[i] = false;
			}
		}
	}
}
