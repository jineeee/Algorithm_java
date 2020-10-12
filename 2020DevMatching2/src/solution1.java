import java.util.Arrays;

public class solution1 {
	
	public static void main(String[] args) {
		solution(10, new int[][] {{1, 5},{2, 7},{4, 8},{3, 6}});
	}

	static boolean[] lights;
	static public int solution(int n, int[][] groups) {
        int answer = 0;
        
        lights = new boolean[n];
        int cnt=0;
        for(int i=0; i<groups.length; i++) {
        	int start = groups[i][0]-1;
        	int end = groups[i][1]-1;
        	for(int j=start; j<=end; j++) {
        		lights[j] = true;
        		if(!lights[j])cnt++;
        	}
        }
        
        for(int i=0; i<lights.length; i++) 
        	if(lights[i]) lights[i] = false;
        	else lights[i] = true;
        
        System.out.print(Arrays.toString(lights));
        answer += cnt;
        
        return answer;
    }
}
