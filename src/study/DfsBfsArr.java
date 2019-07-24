package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class DfsBfsArr {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int numNode = Integer.parseInt(st.nextToken());
        int numLink = Integer.parseInt(st.nextToken());
        int fNode = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[numNode][numNode];
        
        boolean[] vst = new boolean[numNode];
        
        for (int i =0; i<numLink; i++) {
        	
        	st = new StringTokenizer(br.readLine());
        	int v1 = Integer.parseInt(st.nextToken());
        	int v2 = Integer.parseInt(st.nextToken());
        	
        	graph[v1-1][v2-1]=1;
        	graph[v2-1][v1-1]=1;
        	
        }
        
        dfs(graph, vst, fNode);
        System.out.println();
        Arrays.fill(vst, false);
        bfs(graph, vst, fNode);

	}

	static void bfs(int[][] graph, boolean[] vst, int fNode) {
		Queue<Integer> q = new LinkedList<>();
		
		q.add(fNode);
		vst[fNode-1]=true;
		System.out.print(fNode + " ");
		
		while(!q.isEmpty()){
			int node = q.poll();
			
			for (int i=0; i<graph.length; i++) {
				if( graph[node-1][i]==1 && !vst[i]) {
					q.add(i+1);
					vst[i]=true;
					System.out.print(i+1 + " ");
				}
			}
		}
		
		
	}

	static void dfs(int[][] graph, boolean[] vst, int fNode) {
		if (vst[fNode-1]) {
			return;
		} else {
			vst[fNode-1]=true;
			System.out.print(fNode + " ");
			
			for (int i = 0; i<graph.length;i++) {
			
				if (graph[fNode-1][i]==1) {
					dfs(graph, vst, i+1);
					
				}
			}
			
		}
		
	}

}
