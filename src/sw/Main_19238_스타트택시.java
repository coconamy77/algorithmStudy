package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Customer {
	int name;
	int ox;
	int oy;
	int nx;
	int ny;

	public Customer(int name, int ox, int oy, int nx, int ny) {
		this.name = name;
		this.ox = ox;
		this.oy = oy;
		this.nx = nx;
		this.ny = ny;
	}
}

public class Main_19238_스타트택시 {

	static int[][] map;//출발, 도착
	static int N, M, fuel;
	static Customer[] cus;
	static int tx, ty;
	static int[] dx = { 0, 0, 1, -1 };
	static int[] dy = { 1, -1, 0, 0 };

	public static int[] findCus() {
		//System.out.println("가까운 손님 찾기");
		int cus = 0, dis = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] vst = new boolean[N + 2][N + 2];
		q.add(new int[] { 0, tx, ty });// dis, x,y
		vst[tx][ty] = true;
		int nx = 0, ny = 0;
		int tx = 0, ty = 0;
		int[] tmp;
		while (!q.isEmpty()) {
			tmp = q.poll();
			tx = tmp[1];
			ty = tmp[2];
			//System.out.println("위치 : 	"+tx+" "+ty);

			if (map[tx][ty] > 1) {
				dis = tmp[0];
				//System.out.println("???????????????????");
				while (!q.isEmpty()) {
					tmp = q.poll();
					if (dis != tmp[0]) {
						q.clear();
						break;
					}
					nx = tmp[1];
					ny = tmp[2];
					if (map[nx][ny] > 1) {
						if (nx < tx) {
							tx = nx;
							ty = ny;
						} else if (nx == tx) {
							if (ny < ty) {
								tx = nx;
								ty = ny;
							}
						}
					}
				}
				cus = map[tx][ty];
				map[tx][ty] = 0;
				//System.out.println("여기는 처음!!! "+cus+ " "+dis  );
				return new int[] {cus,dis};
			} else {
				if (tmp[0] != dis) {
					dis++;
					if (dis>=fuel) {
						fuel = -1;
						//System.out.println("여기는 두번째!!! "+cus+ " "+dis  );
						return new int[] {};
					}
				}

				for (int d = 0; d < 4; d++) {
					nx = tx + dx[d];
					ny = ty + dy[d];
					//System.out.println("왜애애애애애ㅐ앵 : "+nx+" "+ny);
					if (map[nx][ny] != 1 && !vst[nx][ny]) {
						vst[nx][ny] = true;
						//System.out.println("추가 : "+nx+" "+ny);
						q.add(new int[] { dis+1, nx, ny });
					}
				}
			}
		}

		//System.out.println("여기는 세번째!!! "+cus+ " "+dis  );
		fuel = -1;
		return new int[] { cus, dis };
	}
	
	public static int go(int cx, int cy) {
		//System.out.println("손님 태워 출발~~~~~~~~``");
		int dis = 0;
		Queue<int[]> q = new LinkedList<>();
		boolean[][] vst = new boolean[N + 2][N + 2];
		q.add(new int[] { 0, tx, ty });// dis, x,y
		vst[tx][ty]= true;
		int nx = 0, ny = 0;
		int tmpx = 0, tmpy = 0;
		int[] tmp;
		while (!q.isEmpty()) {
			tmp = q.poll();
			tmpx = tmp[1];
			tmpy = tmp[2];
			//System.out.println("위치 : "+tmpx+" "+tmpy);
			if (tmp[0] != dis) {
				dis++;
				if (dis>=fuel) {
					return -1;
				}
			}
			for (int d = 0; d < 4; d++) {
				nx = tmpx + dx[d];
				ny = tmpy + dy[d];
				
				if (map[nx][ny] != 1 && !vst[nx][ny]) {
					//System.out.println("지금 여기 값이 뭔데? "+map[1][nx][ny]);
					if (nx==cx && ny ==cy) {
						tx = nx;
						ty = ny;
						//map[1][nx][ny] = 0;
						return dis+1;
					}
					vst[nx][ny] = true;
					//System.out.println("추가: "+nx+" "+ny+" "+dis);
					q.add(new int[] { dis+1, nx, ny });
				}
			}
		}
		
		return -1;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map = new int[N + 2][N + 2];
		cus = new Customer[M + 2];

		for (int j = 0; j < N + 2; j++) {
			map[0][j] = 1;
		}

		for (int i = 1; i < N + 1; i++) {
			map[i][0] = 1;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j < N + 1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
			map[i][N + 1] = 1;
		}

		for (int j = 0; j < N + 2; j++) {
			map[N + 1][j] = 1;
		}

		st = new StringTokenizer(br.readLine());
		tx = Integer.parseInt(st.nextToken());
		ty = Integer.parseInt(st.nextToken());
		int ox, oy, nx, ny;
		for (int i = 2; i < M + 2; i++) {
			st = new StringTokenizer(br.readLine());
			ox = Integer.parseInt(st.nextToken());
			oy = Integer.parseInt(st.nextToken());
			nx = Integer.parseInt(st.nextToken());
			ny = Integer.parseInt(st.nextToken());
			cus[i] = new Customer(i, ox, oy, nx, ny);

			map[ox][oy] = i;
		}

//		for (int i =0; i<N+2; i++) {
//			System.out.println();
//			for (int j = 0; j<N+2; j++) {
//				System.out.print(map[0][i][j]+" ");
//			}
//		}

		int[] nearest;// {손님 번호, 거리}
		int tmpf = 0;
		while (M > 0 && fuel > 0) {
			//System.out.println(fuel);
			nearest = findCus();
			
			if (fuel==-1) {
				fuel = -1;
				break;
			}
			tmpf= nearest[1];
			//System.out.println("가까운 손님 =>"+(nearest[0]-1)+" 거리==>"+tmpf);
			fuel -= tmpf;
			
			tx = cus[nearest[0]].ox;
			ty = cus[nearest[0]].oy;
			//System.out.println("현재: "+fuel);
			tmpf = go(cus[nearest[0]].nx, cus[nearest[0]].ny);
			//System.out.println("도착해쓰요 "+tmpf);
			if (tmpf==-1) {
				fuel = -1;
				break;
			}
			fuel = fuel-tmpf+tmpf*2;
			//System.out.println("현재 "+fuel);
			M--;
		}

		if (M > 0 && fuel == 0) {
			fuel = -1;
		}

		System.out.println(fuel);
	}
}
