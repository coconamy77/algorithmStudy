package study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Main_정올_1024_내리막길_서울8반_정하정 {
     
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};
        static int[][] dp;
        
        public static int way(int x, int y,int[][] map) {
        	dp[x][y] = 0;
            int val = map[x][y];
            for (int d = 0; d<4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                 
                if (nx>=0 && ny>=0 && nx<map.length && ny<map[0].length && val>map[nx][ny]) {
                	if (dp[nx][ny]!=-1) {
                		dp[x][y]+=dp[nx][ny];
                	}else {
                		dp[x][y] += way(nx,ny,map);
                	}
                }
                 
            }
           return dp[x][y];
        }
 

        public static void main(String[] args) throws Exception{
           
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            int H =Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
             
            int[][] map = new int[H][W];
            dp = new int[H][W];
            for (int h= 0; h<H; h++) {
            	st = new StringTokenizer(br.readLine());
                for (int w = 0; w<W; w++) {
                    map[h][w] = Integer.parseInt(st.nextToken());
                     dp[h][w] = -1;
                }
            }
             dp[H-1][W-1] = 1;
            way(0,0,map);
             System.out.println(dp[0][0]);
        }
 
}
 
