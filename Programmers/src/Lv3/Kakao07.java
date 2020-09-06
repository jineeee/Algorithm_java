package Lv3;

public class Kakao07 {
	
	public static void main(String[] args) {
		int[][] arr1 = {{1,0,0,1}, {1,1,1,1}, {2,1,0,1}, 
				{2,2,1,1}, {5,0,0,1}, {5,1,0,1}, {4,2,1,1}, {3,2,1,1}};
		
		int[][] arr2 = {{0,0,0,1}, {2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},
				{2,0,0,0},{1,1,1,0},{2,2,0,1}};
		
		solution(5, arr2);
	}
	
	static boolean[][] cols;
	static boolean[][] rows;
	
	public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = {};
        int cnt = 0;
        
        cols = new boolean[n+3][n+3]; // 기둥
        rows = new boolean[n+3][n+3]; // 보
        
        for(int[] order : build_frame) {
        	int x = order[0]+1, y = order[1]+1, a = order[2], b = order[3];
        	
        	if(b==0) { // 삭제
        		if(!checkDelete(x, y, a)) continue;
        		
        		if(a==0) {
        			if(!cols[x][y]) continue;
        			
        			cols[x][y] = false;
        			cnt--;
        		}else {
        			if(!rows[x][y]) continue;
        			
        			rows[x][y] = false;
        			cnt--;
        		}
        		
        	}else if(b==1) { // 설치
        		if(!checkMake(x, y, a)) continue;
        		
        		if(a==0) { // 기둥 설치
        			if(cols[x][y]) continue;
        			
//        			System.err.println("cols "+x + " "+ y);
        			cols[x][y] = true;
        			cnt++;
        		}else { // 보 설치
        			if(rows[x][y]) continue;
        			
//        			System.err.println("rows " + x + " "+ y);
        			rows[x][y] = true;
        			cnt++;
        		}
        		
        	}
        }
        System.out.println("cols");
        for(int i=1; i<cols.length-1;i++) {
        	for(int j=1; j<cols.length-1; j++) {
        		System.out.print(cols[i][j] + " ");
        	}System.out.println();
        }
        System.out.println("rows");
        for(int i=1; i<cols.length-1;i++) {
        	for(int j=1; j<cols.length-1; j++) {
        		System.out.print(rows[i][j] + " ");
        	}System.out.println();
        }
        
        return answer;
    }
	
	static boolean checkMake(int x, int y, int a) {
		if(a==0) {
			if(y==1 || rows[x-1][y] || rows[x][y] || cols[x][y-1]) return true;
			else return false;
		} else {
			if(cols[x][y-1] || cols[x+1][y-1] || (rows[x+1][y]&&rows[x-1][y])) return true;
			else return false;
		}
	}
	
	static boolean checkDelete(int x, int y, int a) {
		if(a==0) {
			cols[x][y] = false;
		}else {
			rows[x][y] = false;
		}
		
		boolean flag = true;
		for(int i=1; i<cols.length-1; i++) {
			for(int j=1; j<cols.length-1; j++) {
				if(cols[i][j] || rows[i][j]) {
					if(!checkMake(x, y, a)) {
						System.out.println(i + " "+j+" "+a);
						flag = false;
						break;
					}
				}
			}
		}

		if(a==0) {
			cols[x][y] = true;
		}else {
			rows[x][y] = true;
		}
		
		return flag;
	}
	
}
