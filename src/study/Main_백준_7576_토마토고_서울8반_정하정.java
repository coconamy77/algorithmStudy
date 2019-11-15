package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_백준_7576_토마토고_서울8반_정하정 {
	
		public static void main(String[] args) throws Exception{
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        StringTokenizer st = new StringTokenizer(br.readLine());
	       
	        int M = Integer.parseInt(st.nextToken());
	        int N = Integer.parseInt(st.nextToken());
	        
	        
	        Queue<Pos> q = new LinkedList<Pos>();
	        
	        //상자 크기 지정	
	        int[][] box = new int[N][M];
			
	        int[][] vst = new int[N][M];
	        
	        for (int j = 0; j<N; j++) {
	        	st = new StringTokenizer(br.readLine());
	        	
	        	for (int i=0; i<M; i++) {
	        		box[j][i] = Integer.parseInt(st.nextToken());
	        		
	        		//큐에 익은 토마토 위치 넣기
	        		if (box[j][i]==1) {
	        			
	        			q.add(new Pos(j,i));
	        			vst[j][i]=1;
	        		}
	        	}
	        }
	        tomato(box,q,vst);
		}
		
		private static void tomato(int[][] box, Queue<Pos> q, int[][] vst) {
			int dx[] = { 0, 0, 1, -1 };
		    int dy[] = { 1, -1, 0, 0 };
			
			while(!q.isEmpty()) {
				Pos p = q.poll();
				
				for (int i = 0; i < 4; i++)
	            {
	                int nx = p.x + dx[i];
	                int ny = p.y + dy[i];
	                
	                // 상자 범위 안
	                if (0 <= nx && nx < box.length && 0 <= ny && ny < box[0].length)
	                {
	                    if (vst[nx][ny] == 0 && box[nx][ny] == 0) //체크 안한 칸
	                    {
	                    	vst[nx][ny] = vst[p.x][p.y] + 1;
	                        box[nx][ny] = 1;
	                        q.offer(new Pos(nx, ny));
	                    }
	                }
	            }
				
			}
			 int flag = 0;
		        int max = 0;
		        for (int i = 0; i < box.length; i++)
		        {
		            for (int j = 0; j < box[0].length; j++)
		            {
		                if (box[i][j] == 0) // 다 돌았는데도 0이있음
		                    flag = 1;
		                if (vst[i][j] > max)
		                    max = vst[i][j];
		            }
		        }
		        if (flag == 1)
		            System.out.println(-1);
		        else
		            System.out.println(max - 1);
		}

		

	}	
		/*class Pos {
			int x;
			int y;
			
			Pos(int x, int y){
				this.x=x;
				this.y=y;
			}
					
		}*/
