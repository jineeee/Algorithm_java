package practice;

/*
 * 프로그래머스 2018 카카오 공채 - 비밀지도
 */

public class Kakao2 {
	
	static int n=6;
	static int[] a1 = {46, 33, 33 ,22, 31, 50};
	static int[] a2 = {27 ,56, 19, 14, 14, 10};

	static public String[] solution(int n, int[] arr1, int[] arr2) {
		 String[] answer = {};
		 String[] map = new String[n];
		 
		 for(int i = 0 ; i < n ; i++) {
			 map[i] = Integer.toBinaryString(arr1[i] | arr2[i]);
		 }
		 
		 for (int i=0; i<n; i++) {
			 map[i] = String.format("%" + n + "s", map[i]);
		 }
	      
	      for (int i=0; i<n; i++) {
	    	  map[i] = map[i].replace("1", "#");
	    	  map[i] = map[i].replace("0", " ");
	      }
	      
	      for(int i=0; i<n; i++) {
	    	  System.out.println(map[i]);
	      }
	      
	      answer = map;
	      return answer;
	  }
	
	public static void main(String[] args) {
		solution(n, a1, a2);
	}
}
