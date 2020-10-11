package Oct;

import java.util.Arrays;

public class solution1 {
	
	public static void main(String[] args) {
		solution(45);
	}
	
	static public int solution(int n) {
        String three = convert(n);
        
        int answer = 0;
        for(int i=0; i<three.length(); i++) {
        	answer += (Character.getNumericValue(three.charAt(i)) * (Math.pow(3, three.length()-i-1)));
        }
        return answer;
    }
	
	static public String convert(int num) {
		StringBuilder sb = new StringBuilder();
		while(num>0) {
			int remain = num%3;
			sb.append(remain);
			num /= 3;
		}
		return sb.toString();
	}

}
