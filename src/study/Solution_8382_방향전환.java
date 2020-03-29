package study;

import java.io.*;
import java.util.*;

public class Solution_8382_방향전환{
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int T,x1,x2,y1,y2;
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t<=T; t++){
			
		st = new StringTokenizer(br.readLine());
		
		x1 = Integer.parseInt(st.nextToken())+100;
		y1 = Integer.parseInt(st.nextToken())+100;
		x2 = Integer.parseInt(st.nextToken())+100;
		y2 = Integer.parseInt(st.nextToken())+100;
		
		boolean[][] vst = new boolean[201][201];
		
		vst[x1][y1] = true;
		
		Queue<int[]> q = new LinkedList<int[]>();
		
		//System.out.println(x1+" "+y1+" "+x2+" "+y2);
		int nx = x1, ny = y1;
		int[] que = new int[4];
		int ans = 333;
		
		for (int d = 0; d<4; d++){
			if (x1==x2 && y1==y2){
				ans = 0;
				break;
			}
			nx = x1+dx[d];
			ny = y1+dy[d];
			if (nx>=0 && nx<=200 && ny>=0 && ny<=200){
				if (nx==x2 && ny==y2){
					ans = 1;
					break;
				}
				vst[nx][ny] = true;
				q.add(new int[]{nx,ny,d,1});
			}
		}
		//System.out.println(q.size());
		
		while(!q.isEmpty() && (nx!=x2 || ny!=y2)){
			que = q.poll();
			//System.out.println("새로 나온 큐"+que[0]+" "+que[1]);
			for (int d = 0; d<4; d++){
				if (d%2==que[2]%2){
					//System.out.println(d);
					continue;
				}
				nx = que[0]+dx[d];
				ny = que[1]+dy[d];
				
				if (nx==x2 && ny==y2){
					ans =que[3]+1;
					break;
				}
				if (nx>=0 && nx<=200 && ny>=0 && ny<=200 && !vst[nx][ny]){
				
				//System.out.println(que[3]+" "+ nx+" "+ ny+" "+d);
					q.add(new int[]{nx,ny,d,que[3]+1});
					vst[nx][ny] = true;	
				}
			}
		}
		System.out.println("#"+t+" "+ans);
	}
   }
}



