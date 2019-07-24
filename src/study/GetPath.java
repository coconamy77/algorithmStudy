package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class GetPath {
	/*ù° �ٿ� ������ ���� N (1 �� N �� 100)�� �־�����. ��° �ٺ��� N�� �ٿ��� �׷����� ���� ����� �־�����. 
	i��° ���� j��° ���ڰ� 1�� ��쿡�� i���� j�� ���� ������ �����Ѵٴ� ���̰�, 0�� ���� ���ٴ� ���̴�. i��° ���� i��° ���ڴ� �׻� 0�̴�.*/

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int N = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[N][N];
        boolean[] vst = new boolean[N];
        
        for (int i = 0; i<N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for (int j=0; j<N ; j++) {
        		graph[i][j] = Integer.parseInt(st.nextToken());
        	}
        	
        }
		
        //Queue<Integer> q = new LinkedList<Integer>();
        
        for (int i =0; i<N;i++) {
        	Arrays.fill(vst, false);
        	
        	find(graph, vst,i);
        	
        	
        	
        	
        	
        	/*q.add(i);
        	
        	while(!q.isEmpty()) {
        		
        		int node  = q.poll();
        		
        		for (int n=0; n<N; n++) {
    				if( graph[node][n]==1 && !vst[n]) {
    					q.add(n);
    					vst[n]=true;
    				}
    			}
        	}*/
        	for (boolean v : vst) {
        		if (v) {
        			System.out.print(1 +" ");
        		}else System.out.print(0+" ");
        	}
        	System.out.println();
        }
        
		
	}

	private static void find(int[][] graph, boolean[] vst, int n) {
		
		vst[n]=true;
		if (!vst[n]) {
			
			for (int i=0; i<graph.length; i++) {
				if (graph[n][i]==1) {
					
					find(graph,vst,i);
					
				}
			}
		}
		
	}
}
