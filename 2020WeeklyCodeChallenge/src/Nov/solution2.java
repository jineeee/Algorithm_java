package Nov;

public class solution2 {
	
	public static void main(String[] args) {
		String string = "110010101001";
		solution("110010101001");
//		System.out.println(string.replaceAll("0", ""));
	}
	
	static public int[] solution(String s) {
        int[] answer = new int[2];
        int cnt1 = 0;
        int cnt2 = 0;
        while(true){
            for(int i=0; i<s.length(); i++){
                if(s.charAt(i)=='0') cnt2++;
            }
            String temp = s.replaceAll("0", "");
            System.out.println(temp.length());
            s = convert(2, temp.length());
            	
            	if(s.equals("1")) break;
        }
        
        return answer;
    }
    
    static String convert(int n, long i) {
		StringBuilder sb = new StringBuilder();
		while (i>0) {
			long rem = i % n;
			sb.append(rem >= 10 ? String.valueOf((char)('A' + (rem - 10))) : rem);
			i /= n;	
		}
		return sb.reverse().toString();
	}

}
