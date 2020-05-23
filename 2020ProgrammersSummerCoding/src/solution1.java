
public class solution1 {
	static int inputYear;
	static int len;
	static int[] result;
	static boolean[] visit;
	static String[] year;
	static boolean flag = false;
	static int tempInt;

	static public int solution(int p) {
        int answer = 0;
        inputYear = p;
        year = String.valueOf(p).split("");
        len = year.length;
        result = new int[len];
        visit = new boolean[10];
        answer = permu(0);
        System.out.print(answer);
        return answer;
    }
	
	static int permu(int current) {
		if(flag) return 0;
		if(len==current) {
			if(result[0]==0) return 0;
			String tempString = "";
			for(int i:result) tempString+=i;
			tempInt = Integer.parseInt(tempString);
			if(tempInt<=inputYear) return 0;
			flag = true;
			
		}
		else{
			for(int i=0; i<=9; i++) {
			if(!visit[i]) {
				result[current] = i;
				visit[i] = true;
				permu(current+1);
				visit[i] = false;
				}
			}
		}
		return tempInt;
	}
	
	public static void main(String[] args) {
		solution(2019);
	}
}
