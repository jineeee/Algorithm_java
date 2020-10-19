import java.util.Arrays;

/*
 * 프로그래머스 순위 - 그래프
 * https://programmers.co.kr/learn/courses/30/lessons/49191
 */

public class Lanking {

	static int[][] map;
    static int INF = 987654321, N;
    
    public int solution(int n, int[][] results) {
        int answer = 0;
        N = n;
        map = new int[n+1][n+1];
        for(int[] m : map) Arrays.fill(m, INF);
        for(int[] r :  results) map[r[0]][r[1]] = 1;
        
        floyd();
        
        boolean[] b = new boolean[n+1];
        Arrays.fill(b, true);
        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j) continue;
                if(map[i][j]==INF && map[j][i]==INF) {
                    b[i] = false;
                    break;
                }
            }
        }
        for(int i=1; i<=n; i++) if(b[i]) answer++;
        return answer;
    }
    
    static void floyd(){
        for(int k=1; k<=N; k++){
            for(int i=1; i<=N; i++){
                for(int j=1; j<=N; j++){
                    if(map[i][j]<=map[i][k]+map[k][j]) continue;
                    map[i][j] = map[i][k]+map[k][j];
                }
            }
        }
    }
}
