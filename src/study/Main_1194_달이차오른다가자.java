package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main_1194_달이차오른다가자 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =  Integer.parseInt(br.readLine().split(" ")[0]);
		int M =  Integer.parseInt(br.readLine().split(" ")[0]);
	
		int x = 0; 
		int y = 0;
		
		int[][] map  = new int[N][M];
		
		for (int n =0; n<N; n++) {
			String st = br.readLine();
			for (int m =0; m<M; m++) {
				map[n][m] = Integer.parseInt(st.split("")[m]);
				if (map[n][m] == 0) {
					x = n;
					y = m;
				}
			}
		}
		
		
		
		
		
	
	
	}
}
