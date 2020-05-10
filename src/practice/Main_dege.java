package practice;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main_dege{
	static int[] dx = {0,0,1,-1};
	static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[r][c];
		
		for (int i =0; i<r; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j<c; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
        int answer = 0;
        int nx, ny;
        for (int i = 0; i<r; i++) {
        	for (int j = 0; j<c;j++) {
        		if (map[i][j]==1) {
        			for (int d = 0; d<4; d++) {
        				nx = i+dx[d];
        				ny = j+dy[d];
        				
        				if (nx<0 || ny<0 || nx>=r || ny>=c || map[nx][ny]==0) {
        					answer++;
        				}
        			}
        		}
        	}
        }
        System.out.println(answer);
       
	}
    
}