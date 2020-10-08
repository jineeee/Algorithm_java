package Oct;

public class solution4 {
	
	public static void main(String[] args) {
		solution("baby");
	}

	static public long solution(String s) {
        long answer = 0;
        for(int i=2; i<=s.length(); i++) { // i는 부분 문자열의 길이
        	for(int j=0; j<=s.length()-i; j++) {
        		int start = j;
        		int end = start + i -1;
//        		String temp = s.substring(start, end+1);
//        		answer += twoPointer(temp);
        		while (start<end) {
        			if(s.charAt(start) != s.charAt(end)) {
        				answer += end-start;
        				break;
        			}
        			else {
        				if(s.charAt(start)==s.charAt(start+1)) end--;
        				else if(s.charAt(end)==s.charAt(end-1)) start++;
        				else start++;
        			}
        		}
        	}
        }
        System.out.println(answer);
        return answer;
    }
	
//	static long twoPointer(String string) {
//		int start = 0;
//		int end = string.length()-1;
//		while (start<end) {
//			if(string.charAt(start) != string.charAt(end)) return end-start;
//			else {
//				if(string.charAt(start)==string.charAt(start+1)) end--;
//				else if(string.charAt(end)==string.charAt(end-1)) start++;
//				else start++;
//			}
//		}
//		return 0;
//	}
}
