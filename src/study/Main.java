package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

   static int[][] map;
   static int N, M, ans, mid;

   static int getBig(int i) {
      int cnt = 0;
      for (int j = 1; j <= N; j++) {
         if (map[j][i] == 1) {
            cnt++;
            cnt += getBig(j);
            if (cnt >= mid) {
               return cnt;
            }
         }
      }
      return cnt;
   }
   
   static int getSmall(int i) {
      int cnt = 0;
      for (int j = 1; j <= N; j++) {
         if (map[i][j] == 1) {
            cnt++;
            cnt += getSmall(j);
            if (cnt >= mid) {
               return cnt;
            }
         }
      }
      return cnt;
   }


   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      N = Integer.parseInt(st.nextToken());
      M = Integer.parseInt(st.nextToken());

      map = new int[N + 1][N + 1];
      mid = (N + 1) / 2;
      ans = 0;

      for (int m = 0; m < M; m++) {
         st = new StringTokenizer(br.readLine());
         map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
      }

      for (int i = 1; i <= N; i++) {
         if(getSmall(i)>=mid) ans++;
         if(getBig(i)>=mid) ans++;
      }

      System.out.println(ans);
   }
}