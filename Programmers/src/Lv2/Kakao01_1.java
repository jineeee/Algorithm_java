package Lv2;

public class Kakao01_1 {
	
	public static void main(String[] args) {
		solution("abcabcdede");
	}
	
	static public int solution(String s) {
		int answer = Integer.MAX_VALUE;
		if(s.length()==1) return 1;
		
		for(int i=1; i<=s.length()/2; i++) {
			StringBuilder sb = new StringBuilder();
			int cnt = 1;
			String str1 = "";
			String str2 = "";
			
			for(int j=0; j<s.length()/i; j++) {
				str1 = str2; // 직전 문자열과 비교
				str2 = s.substring(i*j, i*j+i); // 길이를 i만큼 자름
				System.err.println(str1 + " " + str2);
				if(str1.equals(str2)) {
					cnt++;
				}else {
					sb.append(checkNum(cnt) + str1);
					cnt = 1;
				}
			}
			sb.append(checkNum(cnt) + str2);
			if(s.length()%i!=0) sb.append(s.substring(s.length()/i*i));
			answer = Math.min(answer, sb.length());
		}
		System.out.print(answer);
		return answer;
	}
	
	static String checkNum(int cnt) {
		return cnt<=1? "" : String.valueOf(cnt);
	}

}
