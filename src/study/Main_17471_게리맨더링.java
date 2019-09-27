package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Main_17471_게리맨더링 {
	
	static int N;
	static int[] sec;
	static int[][] map;
	static int min = Integer.MAX_VALUE;
	
	static void sel(int dep, int[] sel) {
		if (dep == N) {
			List<Integer> v1 = new ArrayList<>();//선택된 마을들의 번호 저장
			List<Integer> v2 = new ArrayList<>();
			for (int i =0; i<N; i++) {
				if(sel[i]==0) v1.add(i);
				else v2.add(i);
			}
			if (isCon(v1,new boolean[N],0)&&isCon(v2,new boolean[N],0)) {
				int sum1 = 0,sum2 =0, sub; 
				for (int a: v1) {
					sum1 +=sec[a];
				}
				for (int a: v2) {
					sum2 +=sec[a];
				}
				sub = Math.abs(sum2-sum1);
				min = sub>min?min:sub;
			}
		}else {
			for (int i = 0; i<N; i++) {
				sel(dep+1,sel);
				sel[dep] = 1;
				sel(dep+1,sel);
			}
			
		}
	}
	
	static boolean isCon(List<Integer> v1,boolean[] check, int dep) {
		if (dep== v1.size()) {
			for (int a: v1) {
				if (!check[a]) return false;
			}
		}
		else {
			
			int i = v1.get(dep);
			check[i] = true;
			for (int j = 0; j<N; j++) {
				if (v1.contains(j) && map[i][j] == 1) {
					return isCon(v1,check,dep+1);
				}
			}
		}
		return true;
	}
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		
		sec = new int[N];
		map = new int[N][N];
		
		st = new StringTokenizer(br.readLine());
		for (int n =0; n<N; n++) {
			sec[n] = Integer.parseInt(st.nextToken());
			
		}
		
		for (int n = 0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i<num; i++) {
				int tmp = Integer.parseInt(st.nextToken())-1;
				map[n][tmp] = 1;
				map[tmp][n] = 1;
			}
			
		}
		
		sel(0, new int[N]);
		
		System.out.println(min);
	}
}
