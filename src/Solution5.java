import java.util.Arrays;

class Solution5 {
	static int[][][] dp;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	static int N;
	public int getAns(int[][] b,int x, int y) {
		if (dp[x][y][0]>0) {
			return dp[x][y][0];
		}
		if (x==N-1 && y==N-1) {
			return -2;
		}
		if (b[x][y]==1) {
			return -1;
		}
		
		dp[x][y][0] = -1;
		int tmp=0;
		for (int d = 0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			if (nx>=0 && ny>=0 && nx<N && ny<N && dp[nx][ny][0]!=-1) {
				tmp = getAns(b,nx,ny);
				if (tmp==-2) {
					dp[x][y][0] = 100;
					dp[x][y][1] = d;
					//System.out.println("x = "+x+", y = "+y+", d = "+d);
				}
				else if (tmp>0) {
					if (d!=dp[nx][ny][1]) {
						tmp+=500;
					}
					tmp += 100;					
					if (dp[x][y][0]==-1) {
						dp[x][y][1] = d;
						dp[x][y][0] = tmp;
					}else {
						if (dp[x][y][0]>tmp) {
							dp[x][y][0] = tmp;
							dp[x][y][1] = d;
						}
					}
					//System.out.println("x = "+x+", y = "+y);
				}
			}
		}
		
		if (dp[x][y][0]==-1) {
			dp[x][y][0] = 0;
		}
		return dp[x][y][0];
	}
    public int solution(int[][] board) {
        int answer = 0;
        N = board.length;
        dp = new int[N][N][2];
        answer = getAns(board,0,0);
        for (int i = 0; i<N; i++) {
        	System.out.println();
        	for (int j = 0; j<N; j++) {
        		System.out.print(dp[i][j][0]+" ");
        	}
        }
        
        System.out.println("dudududud" +dp[7][6][1]);
        return answer;
    }
    
}