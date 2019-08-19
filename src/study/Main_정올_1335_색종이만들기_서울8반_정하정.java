package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1335_색종이만들기_서울8반_정하정 {
	static int[][] a;
	static int[] count = new int[2];
	static void cut(int sx,int sy, int n) {
		int c = a[sx][sy];
		for (int i = sx; i<sx+n; i++) {
			for (int j = sy; j<sy+n; j++) {
				if (a[i][j]!=c) {
					cut(sx,sy,n/2);
					cut(sx+n/2,sy,n/2);
					cut(sx,sy+n/2,n/2);
					cut(sx+n/2,sy+n/2,n/2);
					return;
				}
			}
		}
		count[c]++;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		a = new int[N][N];
		for (int i = 0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j<N; j++) {
				a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		cut(0,0,N);
	
		System.out.println(count[0]);
		System.out.println(count[1]);
	}
}
