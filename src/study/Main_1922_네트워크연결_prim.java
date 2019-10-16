package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main_1922_네트워크연결_prim {
	
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		PriorityQueue<int[]> com = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[2], o2[2]);
			}
		});
		
		int[][] info = new int[N][N];
		boolean[] vst = new boolean[N];
		
		for (int t = 0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken())-1;
			int j = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken());
			
			info[i][j] = v;
			info[j][i] = v;
		}
		
		
		
		int sum = 0;
		
		for (int i = 1; i<N; i++) {
			if (info[0][i]!= 0) {
				com.add(new int[] {0,i,info[0][i]});
			}
		}
		vst[0] = true;
		
		int count = 0;
		while(true){
			int[] tmp = com.poll();
			if (vst[tmp[1]])continue;
			vst[tmp[1]] = true;
			sum+=tmp[2];
			count++;
			if (count>=N-1)break;
			for (int i = 0; i<N; i++) {
				if (info[tmp[1]][i]!=0 && !vst[i]) {
					com.add(new int[] {tmp[1],i,info[tmp[1]][i]});
				}
			}
			
			
		}
		
		System.out.println(sum);
		
	}
}
