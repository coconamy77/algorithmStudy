package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Robot{
	int x;
	int y;
	int d;
	int no;
	
	public Robot(int no,int x, int y, int d) {
		this.no = no;
		this.d = d;
		this.x = x;
		this.y = y;
	}
//	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return no+", "+ d+"|";
//	}
	/*
5 4
2 4
1 1 E
5 4 W
1 R 7
1 F 1
1 L 5
2 F 7
	*/
	
}


public class Main_2174_로봇시뮬레이션 {

	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Robot[][] map = new Robot[B+1][A+1];
		
		Robot[] robot = new Robot[N+1];
		
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1}; 
		
		for (int n = 1; n<=N; n++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			int d= 0;
			switch(st.nextToken()) {
			case "S":
				d = 0;
				break;
			case "E":
				d = 1;
				break;
			case "N":
				d = 2;
				break;
			case "W":
				d = 3;
				break;
			}
			
			Robot r = new Robot(n,x,y,d);
			
			robot[n] = r;
			map[x][y] = r;
					
		}
		
		boolean fin = false;
		int no,d,time,nx,ny,x,y;
		for (int m = 0; m<M;m++) {
			st = new StringTokenizer(br.readLine());
			no = Integer.parseInt(st.nextToken());
			String order = st.nextToken();
			time = Integer.parseInt(st.nextToken());
			d = robot[no].d;
			if (order.equals("L")) {
				robot[no].d = (d+time+400)%4;
			}else if (order.equals("R")) {
				robot[no].d = (d-time+400)%4;
			}else {
				x = robot[no].x;
				y = robot[no].y;
				
				nx = x;
				ny = y;
				
				while(time>0) {
					nx = nx+dx[d];
					ny = ny+dy[d];
					
					if(nx<1 || ny<1 || nx>B || ny>A ) {
						//System.out.println("nx: " +nx+", ny: "+ny+", A: "+A+", B: "+B);
						System.out.println("Robot "+no +" crashes into the wall");
						fin = true;
						break;
					}else if (map[nx][ny]!=null) {
						System.out.println("Robot "+no+" crashes into robot "+map[nx][ny].no);
						fin = true;
						break;
					}
					time--;
				}
				if (fin) {
					break;
				}else {
					map[nx][ny] = map[x][y];
					map[x][y] = null;
					map[nx][ny].x = nx;
					map[nx][ny].y = ny;
				}
				
			}
//			for (int i = 0; i<=B; i++) {
//				for (int j = 0; j<=A; j++) {
//					if (map[i][j]==null) {
//						System.out.print(0+", "+ 0+"|");
//					}
//					else{
//						System.out.print(map[i][j].toString());
//					}
//				}
//				System.out.println();
//			}
		}
		if (!fin) {
			System.out.println("OK");
		}
		
		
	}
}
