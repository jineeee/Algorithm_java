import java.awt.desktop.PrintFilesEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2206 {
	static int N;
	static int M;
	static int[][] map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		
		N = Integer.parseInt(st[0]);
		M = Integer.parseInt(st[1]);
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			 st = br.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st[j]);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
}
