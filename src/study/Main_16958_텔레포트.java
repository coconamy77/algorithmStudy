package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class City{
	int x;
	int y;
	int s;
	public City(int s, int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.s = s;
	}
	
	
}

public class Main_16958_텔레포트 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());

		City[] city = new City[N+1];
		
		int[][] graph = new int[N+1][N+1];
		int x,y,s;
		City tmp;
		for (int n=1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			y = Integer.parseInt(st.nextToken());
			s = Integer.parseInt(st.nextToken());
			city[n] = new City(x,y,s);
			
			for (int i = 1; i<n; i++) {
				tmp = city[i];
				graph[n][i] = Math.abs(x-tmp.x)+Math.abs(y-tmp.y);
				if (s==1 && tmp.s==1) {
					if (graph[n][i]>3) {					
						graph[n][i] = 3;
					}
				}
				graph[i][n] = graph[n][i];
			}
		}
		
		for (int n = 1; n<=N; n++) {
			
		}
	}
}
