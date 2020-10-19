package Lv3;

/*
 * 문자열 - 팰린드롬
 * https://programmers.co.kr/learn/courses/30/lessons/12904
 */

public class Level_3_09 {
	
	public int solution(String s){
        char[] word = s.toCharArray();
        
        for(int len=s.length(); len>1; len--){
            for(int i=0; i<=s.length()-len; i++){
                int start = i;
                int end = start+len-1;
                
                boolean flag = true;
                for(int j=0; j<len/2; j++){
                    if(word[start+j]!=word[end-j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) return len;
            }
        }
        return 1;
    }

}
