package Lv2;

public class Level_2_31 {

	public static void main(String[] args) {
		solution("JEROEN");
	}
	
	public static int solution(String name) {
        int answer = 0;
        char[] nameArr = name.toCharArray();
        boolean[] bool = new boolean[nameArr.length];
        
        for(int i=0; i<nameArr.length; i++) {
        	if(nameArr[i]!='A') {
        		bool[i] = true;
        		answer += changeAlpha(nameArr[i]);
        	}
        }
        
        int min = name.length() - 1;
        bool[0] = true;
        
        
        return answer;
    }
	
	static int changeAlpha(char c) {
		int a = c - 'A';
		int b = 'Z' - c + 1;
		if(a > b) return b; // 이전 알파벳으로 이동 (커서 아래)
		else return a; // 다음 알파벳으로 이동 (커서 위)
	}
}
