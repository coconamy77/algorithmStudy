package sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ss {
	public static int[][] ar = new int[100][100];
	static int x=-1;
	
	public static int left(int i, int j) {
		while(j > 0 && ar[i][j-1] == 1) {
			j--;
		}
		return j;
	}
	
	public static int right(int i, int j) {
		while(j < 99 && ar[i][j+1] == 1) {
			j++;
		}
		return j;
	}
	
	public static void main(String[] args) throws Exception {
		// 테스트용
		System.setIn(new FileInputStream("res/input_d4_1210_Ladder1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	 
		
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			st.nextToken();
			x = -1;
			
			// 사다리값 2차원배열에 저장
			for(int i = 0; i < 100; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < 100; j++) {
					ar[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// X가 있는 마지막줄 위치 찾기
			for(int i = 0; i < 100; i++) {
				x = (ar[99][i] == 2) ? i : x;
			}
			
			for(int i = 98; i >= 0; i--) {
				if(i==0) break;
				
				if(x-1 >= 0 && ar[i][x-1] == 1) { // 좌
					x = left(i, x-1);
				}
				
				else if(x+1 < 100 && ar[i][x+1] == 1) { // 우
					x = right(i, x+1);
				}
			}
			System.out.println("#" + tc + " " + x);		
		}
	}
}