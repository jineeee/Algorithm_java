package Lv2;

public class Level_2_35 {
	
	public static void main(String[] args) {
		solution("1924", 2);
	}
	
	public static String solution(String number, int k) {
        if(number.charAt(0)=='0') return "0";
        StringBuilder sb = new StringBuilder();
        
        int cnt = number.length()-k;
        int left = 0;
        int right = number.length()-cnt;
        int idx = 0;
        int max = -1;
        
        while(cnt>0){
            max = -1;
            System.out.println(cnt+" "+left+" "+right+" "+idx+" "+max);
            for(int i=left; i<=right; i++){
                int num = number.charAt(i)-'0';
                if(num>max){
                    max = num;
                    idx = i;
                }
            }
            sb.append(number.charAt(idx));
            left = idx+1;
            right = number.length() - --cnt;
        }
        return sb.toString();
    }

}
