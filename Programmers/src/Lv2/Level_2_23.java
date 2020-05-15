package Lv2;

public class Level_2_23 {

	static public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int x = 0, y=0;
        for(int i=1; i<brown+4; i++) {
        	x = i;
        	y = (brown+4) - x;
        	System.out.println(x + " " + y);
        	if(x%2 !=0 || y%2 != 0) continue;
        	if((x/2-2)*(y/2-2)==yellow) {
        		x = x/2;
        		y = y/2;
        		break;
        	}
        }
        System.out.println(x + " " + y);
        answer[0] = Math.max(x, y);
        answer[1] = Math.min(x, y);
        return answer;
    }
	
	public static void main(String[] args) {
		solution(10, 2);
	}
}
