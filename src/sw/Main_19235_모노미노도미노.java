package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_19235_모노미노도미노 {
	
	public static void newB(int[][] map, int type, int y) {
		int x = 1;
		if (type==1) {
			while(x+1>=0 && map[x+1][y]==0) {
				x++;
			}
			map[x][y] = 1;
			if (check(map, x)) {
				// 내리기
				goDown(map, 0);
			}
			
		}else if(type==2) {
			while(x+1>=0 && map[x+1][y]==0 && map[x+1][y+1]==0) {
				x++;
			}
			map[x][y] = 21;
			map[x][y+1] = 22;
			if (check(map, x)) {
				goDown(map, 0);
			}
		}else {
			while(x+2>=0 && map[x+2][y]==0) {
				x++;
			}
			map[x][y] = 1;
			map[x+1][y] = 1;
			boolean c = check(map,x), c2 = check(map,x);
			if (c || c2) {
				goDown(map, 0);
			}
		}
		
		
	}
	
	public static void goDown(int[][] map, int last) {
		int nx = 5;
		if (last>0) {
			nx = nx-last;
			for (int y = 0; y<4; y++) {
				for (int x = 5; x>=2; x--) {
					map[x][y] = map[x-last][y];
				}
			}
		}else {
			
		}
	}
	public static int checklast(int[][] map) {
		int last = 0;
		for (int y = 0; y<4; y++) {
			if (map[1][y]!=0) {
				last++; 
				break;
			}
		}
		if (last==0) {
			return 0;
		}
		for (int y = 0; y<4; y++) {
			if (map[0][y]!=0) {
				last++; 
				break;
			}
		}
		return last;
	}
	public static boolean check(int[][] map, int x) {
		for (int y = 0; y<4; y++) {
			if (map[x][y]==0) {
				return false;
			}
		}
		for (int y = 0; y<4; y++) {
			map[x][y]=0;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[][] map1 = new int[6][4];
		int[][] map2 = new int[6][4];
		
		int N = Integer.parseInt(st.nextToken());
		
		int t, x, y;
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			
			t = Integer.parseInt(st.nextToken());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			
			newB(map1, t, y);
			newB(map2, t, x);
			
		}
		
	}
}
