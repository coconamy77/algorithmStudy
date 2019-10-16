package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결_kruskal {
	
	static List<int[]> com;
	static int[] uf;
	
	static int find(int x) {
		if (uf[x]==0 ) {
			uf[x] = x;
		}else if(uf[x]!=x){
			uf[x] = find(uf[x]);
		}
		
		return uf[x];
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x==y) return false;
		
		else if (x>y) {
			uf[x] = y;
		}else {
			uf[y] = x;
		}
		return true;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		com = new ArrayList<int[]>();
		
		uf = new int[N+1];
		
		for (int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			com.add(new int[] {Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(com,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		
		
		int sum = 0;
		for (int n=0; n<N-1;) {
			int[] tmp = com.remove(0);
			if (union(tmp[0],tmp[1])) {
				//System.out.println(tmp[0]+" "+ tmp[1]);
				sum += tmp[2];
				n++;
			}
		}
		
		System.out.println(sum);
		
	}
}
