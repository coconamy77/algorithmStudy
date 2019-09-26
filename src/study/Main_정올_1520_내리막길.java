package study;
import java.util.Scanner;
 
public class Main_정올_1520_내리막길 {
     
        static int[] dx = {0,1,0,-1};
        static int[] dy = {1,0,-1,0};
        static boolean[][] vst;
        
        public static int way(int x, int y,int[][] map) {
            if (x==map.length-1 && y==map[0].length-1) {
                return 1;
            }
            int count = 0;
            int val = map[x][y];
            for (int d = 0; d<4; d++) {
                int nx = x+dx[d];
                int ny = y+dy[d];
                 
                if (nx>=0 && ny>=0 && nx<map.length && ny<map[0].length && val>map[nx][ny] && !vst[nx][ny]) {
                	vst[nx][ny] = true;
                    count = count+way(nx,ny,map);
                    vst[nx][ny] = false;
                }
                 
            }
            return count;
        }
 

        public static void main(String[] args) {
            int result = -1;
            Scanner sc = new Scanner(System.in);
 
            int H = sc.nextInt();
            int W = sc.nextInt();
             
            int[][] map = new int[H][W];
            vst = new boolean[H][W];
            for (int h= 0; h<H; h++) {
                for (int w = 0; w<W; w++) {
                    map[h][w] = sc.nextInt();
                     
                }
            }
             vst[0][0]=true;
            result = way(0,0,map);
             System.out.println(result);
        }
 
}
 
