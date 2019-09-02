package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1863_종교_서울8반_정하정 {
	static int[] map;
	static int N;
	static int find(int i) {
		if (map[i]==0) {
			map[i] = i;
		}
		else if (map[i]!=i) {
			map[i] = find(map[i]);
		}
		return map[i];
	}
	
	static void union(int i, int j) {
		i = find(i);
		j = find(j);
	
		if (i!=j) {
			if (i>j) {
				map[i] = j;
			}else {
				map[j] = i;
			}
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N+1];
		
		for (int m = 0; m<M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken());
			int j = Integer.parseInt(st.nextToken());
			union(i,j);
			
		}
		
		int count = 0;
		for (int i = 1; i<=N; i++) {
			if (map[i]==0 || map[i] ==i) {
				count++;
			}
		}
		System.out.println(count);
	}
}
