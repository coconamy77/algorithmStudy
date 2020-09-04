import java.util.*;

public class Solution_카카오프렌즈컬러링북{
   public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
		
		int dx = {0,0,1,-1};
		int dy = {1,-1,0,0};
		
		Queue<Integer> q = new LinkedList<>();
		int tmp = 0, tmpArea = 0, x,y;
		for (int i = 0; i<m; i++){
			for (int j = 0; j<n; j++){
				if (picture[i][j]	!= 0){
					tmp = picture[i][j];
					
					numberOfArea++;
					q.add(i*1000+j);
					picture[i][j] = 0;
					
					while(!q.isEmpty()){
						x = q.poll();
						
						
						
					}
					
					
					
					
					
				}
			}
		}
		
		

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }


    public static void main(String args[]){

        
    }
}



