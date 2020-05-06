package Lv2;

public class Level_2_15 {
	
	static public int solution(String s) {
        int answer = 1000; // 문자열의 최대 길이가 1000
        
        if(s.length()==1) return 1; 
        
        for(int i=1; i<=s.length()/2; i++) {
        	String num1 = "";
        	String num2 = "";
        	String result = "";
        	int count = 1;
        	
        	// i개씩 j개의 덩어리로 자름, 길이 i에 따라 덩어리 j의 개수가 달라지므로 j<s.length()/i
        	for(int j=0; j<s.length()/i; j++) {
        		num1 = num2;
        		num2 = s.substring((i*j), (i*j)+i);
        		System.out.println("num1 : " + num1);
        		System.out.println("num2 : " + num2);
        		
        		if(num1.equals(num2)) { // 문자열이 일치한다면 count 증가
        			count++;
        		} else { // 결과를 담을 result에 문자열을 합침 
        			result += processCount(count) + num1;
        			System.out.println("result : " + result);
        			count = 1; // count 값 초기화
        		}
        	}
        	// 마지막 문자는 비교 대상이 없으므로 else문을 실행하지 않고 for문을 빠져나오므로, 여기서 수
        	result += processCount(count) + num2;
        	if(s.length()%i != 0) { // 남은 문자열이 있다면 result 값에 합쳐줌
        		result += s.substring(s.length()-(s.length()%i), s.length());
        	}
        	System.out.println("final result : " + result);
        	answer = Math.min(answer, result.length());
        }
        
        return answer;
    }
	
	// 동일한 문자열의 개수를 처리하는 함수 
	static String processCount(int count) {
		return count>1 ? String.valueOf(count) : "";
	}
	
	public static void main(String[] args) {
		solution("aabbaccc");
	}

}
