package programmers;

public class Solution_경주로건설 {
	
	int[] dx = {0,0,1,-1};
	int[] dy = {1,-1,0,0};
	//->,<-,ㅜ,^
	
	public void dfs(int x, int y, int w, int[][] b) {
		int now = b[x][y];
		int tmp;
		for (int d = 0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if (w==d) {
				tmp = now+100;
			}else {
				tmp = now+600;
			}
			
			if (nx>=0 && ny>=0 && nx<b.length && ny<b.length && b[nx][ny]!=1 && (b[nx][ny]==0||b[nx][ny]>tmp)){
				b[nx][ny] = tmp;
				dfs(nx, ny, d, b);
			}
			
		}
		
	}

	public int solution(int[][] board) {
        
        
        //dfs(0,0,0,board);
        int nx, ny;
        
        dfs(1,0,2,board);
        for (int d = 0; d<4; d++) {
        	
        	dfs(0,0,d,board);
        }
        
        return board[board.length][board.length];
    }
}
