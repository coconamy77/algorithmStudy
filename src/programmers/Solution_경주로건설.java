package programmers;

public class Solution_경주로건설 {

   static int board2[][];
   static int dx[] = {0, 0, 1, -1};
   static int dy[] = {1, -1, 0, 0};
   static int nx, ny;
   static int plusScore;
   static int length;
   public static void DFS(int x, int y, int direction) {
   
      for(int i=0; i<4; i++) {
         nx = dx[i]+x;
         ny = dy[i]+y;
         if(direction==i) {
            plusScore=100;
         }else {
            plusScore=600;
         }
         if(nx>=0 && ny>=0 && nx<board2.length && ny<board2.length && board2[nx][ny]!=1 
               && (board2[nx][ny]>=board2[x][y]+plusScore || board2[nx][ny]==0) && (nx!=0 || ny!=0)) {
            board2[nx][ny]=board2[x][y]+plusScore;
            DFS(nx, ny, i);
         }
      }
   }
   
      public int solution(int[][] board) {
         board2= board;
         length=board2.length;
            for(int i=0; i<4; i++){
             DFS(0, 0, i);
            }
         return board2[length-1][length-1];
      }
   }
