package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_등굣길 {
	static int[][] map;
    static int[] dx = {0,1};
    static int[] dy = {1,0};
    static int M,N;
    
    public int solution(int m, int n, int[][] puddles) {
        map = new int[m][n];
        M = m;
        N = n;
        
        for (int[] mn: puddles){
            map[mn[0]-1][mn[1]-1] = -1;
        }
        
        map[0][0] =1;
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        
        while(!q.isEmpty()){
            int x = q.poll();
            int y = x%1000;
            x = x/1000;
            
            int count = map[x][y];
            
            for(int d = 0; d<2; d++){
            int nx = x+dx[d];
            int ny = y+dy[d];
            
                if(nx>=0 && nx<M && ny>=0 && ny<N){
                    if(map[nx][ny]==-1){
                        continue;
                    }
                    if((nx<m || ny<n)&& map[nx][ny]==0){
                        q.add(nx*1000+ny);
                    }
                    map[nx][ny] += count%1000000007;
                }
            }
        }
        
        int answer = map[m-1][n-1];
        
        return answer;
    }
}
