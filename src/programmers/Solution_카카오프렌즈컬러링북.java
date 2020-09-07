package programmers;

import java.util.*;

class Solution_카카오프렌즈컬러링북 {
       public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
		
		int[] dx = {0,0,1,-1};
		int[] dy = {1,-1,0,0};
		
		Queue<Integer> q = new LinkedList<>();
		int tmp = 0, tmpArea = 0, x,y,nx,ny;
		for (int i = 0; i<m; i++){
			for (int j = 0; j<n; j++){
				if (picture[i][j]!= 0){
					tmp = picture[i][j];
					
					numberOfArea++;
					q.add(i*10000+j);
					picture[i][j] = 0;
					tmpArea++;
					
					while(!q.isEmpty()){
						x = q.poll();
						y = x%10000;
						x = x/10000;
						
						for (int d = 0; d<4; d++){
							nx = x+dx[d];
							ny = y+dy[d];
							
							if (nx>=0 && ny>=0 && nx<m && ny<n && picture[nx][ny]==tmp){
								tmpArea++;
								picture[nx][ny] = 0;
								q.add(nx*10000+ny);
							}
						}
					}
					
					maxSizeOfOneArea = maxSizeOfOneArea>tmpArea?maxSizeOfOneArea:tmpArea;
					
					tmpArea = 0;
					
					
					
				}
			}
		}
		
		

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

}
