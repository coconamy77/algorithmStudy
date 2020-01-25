package algo_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3952_줄세우기 {
	//위상정렬
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int T = Integer.parseInt(st.nextToken());
		
		
		for (int t = 1; t<=T; t++) {
			System.out.print("#"+t);
			
			st = new StringTokenizer(br.readLine());
		
			int N = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N+1][N+1];
			int[] count = new int[N+1];
			
			int M = Integer.parseInt(st.nextToken());
			
			for (int m = 0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				int tmp1 = Integer.parseInt(st.nextToken());
				int tmp2 = Integer.parseInt(st.nextToken());
				map[tmp1][tmp2]++;
				count[tmp2]++;
			}
			/*System.out.println(Arrays.toString(count));
			
			for (int[] a: map) {
				System.out.println(Arrays.toString(a));
			}*/
			int[] q = new int[N];
			int head=0,tail=0;
			
			for (int i = 1; i<=N; i++) {
				if (count[i]==0) {
					//System.out.println("여기?");
					q[tail++] = i;
				}
				
			}
			
			while(head!=tail) {
				int tmp = q[head++];
				System.out.print(" "+tmp);
				for (int i=1;i<=N; i++ ) {
					if (map[tmp][i]!=0) {
						count[i]--;
						//System.out.println(Arrays.toString(count));
						if(count[i]==0) {
							q[tail++]=i;
						}
					}
				}
			}
			
			if (head!=N+1) {
				for (int i=1;i<N+1; i++) {
					
					if (count[i]!=0) {
						System.out.print(" "+i);
					}
				}
			}
			System.out.println();
			
			
		}
	}
}
