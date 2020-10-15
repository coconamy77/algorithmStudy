package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



class Fish {
	int name;
	int dir;
	int x;
	int y;

	public Fish(int name, int dir, int x, int y) {
		this.name = name;
		this.dir = dir;
		this.x = x;
		this.y = y;
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void turn() {
		dir++;
		if (dir == 8) {
			dir = 0;
		}
	}

	public String toString() {
		String s = "[" + name + ",";
		switch (dir) {
		case 0:
			s += "↑";
			break;
		case 1:
			s += "↖";
			break;
		case 2:
			s += "←";
			break;
		case 3:
			s += "↙";
			break;
		case 4:
			s += "↓";
			break;
		case 5:
			s += "↘";
			break;
		case 6:
			s += "→";
			break;
		case 7:
			s += "↗";
			break;
		}
		return s + "]";
	}
}

public class Main_19236_청소년상어 {

	static Fish[][] map = new Fish[4][4];
	static Fish[] fish = new Fish[17];
	static int sx = 0, sy = 0, sd = 0;
	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, -1, -1, -1, 0, 1, 1, 1 };
	static int answer = 0;

	static boolean range(int x, int y) {
		if (x >= 0 && y >= 0 && x < 4 && y < 4) {
			return true;
		}
		return false;
	}

	static void getNew(Fish f) {

		int nx, ny;
		nx = f.x + dx[f.dir];
		ny = f.y + dy[f.dir];

		while (!range(nx, ny) || map[nx][ny] == fish[0]) {
//			System.out.println("????getNew " + f.name + " " + nx + " " + ny + " " + f.dir);
			f.turn();
			nx = f.x + dx[f.dir];
			ny = f.y + dy[f.dir];
		}
		f.move(nx, ny);
	}

	static void print(Fish[] nowfish) {
		System.out.println("현재 물고기 상황");
		int cnt = 0;
		for (int i = 0; i < 17; i++) {
			if (nowfish[i] == null) {
				System.out.print("[0,0]");
			} else {
				cnt++;
				System.out.print(nowfish[i].toString());
			}
		}
		System.out.println("총 " + (cnt - 1) + "마리");

		for (int i = 0; i < 4; i++) {
			System.out.println();
			for (int j = 0; j < 4; j++) {
				if (map[i][j] == null) {
					System.out.print("  ");
					continue;
				}
				System.out.print(map[i][j].name + " ");
			}
		}
		System.out.println();

	}

	static void moveFish() {
		System.out.println("물고기 움직여");
		Fish f;
		int ox, oy, nx, ny;
		for (int i = 1; i < 17; i++) {
			if (fish[i] == null) {
				continue;
			}
			f = fish[i];
			ox = f.x;
			oy = f.y;
			getNew(f);
			nx = f.x;
			ny = f.y;
			map[ox][oy] = map[nx][ny];
			if (map[nx][ny] != null) {
				map[ox][oy].move(ox, oy);
			}
			map[nx][ny] = f;
		}
		System.out.print("물고기 움직여따아=======>");
		print(fish);
	}

	public static int movable() {
//		System.out.println("movable");
		int m = 0;
		int nx, ny;
		for (int i = 1; i < 4; i++) {
			nx = sx + dx[sd] * i;
			ny = sy + dy[sd] * i;
			if (!range(nx, ny)) {
				return m;
			}
			if (map[nx][ny]!=null) {
				m++;
			}
		}
		return m;
	}

	public static void copymap(Fish[][] ori, Fish[][] tmp, Fish[] tmpfish) {
//		System.out.println("copymap");
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				if (ori[i][j] == null) {
					tmp[i][j] = null;
					continue;
				}
				tmp[i][j] = tmpfish[ori[i][j].name];
			}
		}
	}

	public static void copyFish(Fish[] ori, Fish[] tmp) {
//			System.out.println("오리지날-> 뉴~");
		for (int i = 0; i < 17; i++) {
			if (ori[i] == null) {
				tmp[i] = null;
				continue;
			}
			tmp[i] = new Fish(ori[i].name, ori[i].dir, ori[i].x, ori[i].y);
		}

	}

	public static void getAnswer(int sum) {
		int movable = movable();
		if (movable == 0) {
			if (sum > answer) {
				answer = sum;
			}
			System.out.println("답인가?! ->" + answer);
			return;
		}
		Fish[][] tmp = new Fish[4][4];
		Fish[] tmpfish = new Fish[17];
		copyFish(fish, tmpfish);
		copymap(map, tmp, tmpfish);
		System.out.println("복사했엉~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  " + sx
				+ " " + sy);
//		print(fish);
		int ox = sx, oy = sy, od = sd;
		int tmpval = 0;
		for (int m = 1; m <= 3; m++) {
			sx = sx + dx[sd] * m;
			sy = sy + dy[sd] * m;

			if (!range(sx, sy)) {
				sx = ox;
				sy = oy;
				break;
			}
			if (map[sx][sy] == null) {
				sx = ox;
				sy = oy;
				continue;
			}
			System.out.println("상어위치 " + ox + " " + oy + " -> " + sx + " " + sy);
			tmpval = moveShark(ox, oy);
			moveFish();
			getAnswer(sum + tmpval);
			sx = ox;
			sy = oy;
			sd = od;
			System.out.println("이걸 복사 할것이다 ==============>" + sx + " " + sy);
			print(tmpfish);
			copyFish(tmpfish, fish);
			copymap(tmp, map, fish);
			System.out.println("백트레킹~ " + sx + " " + sy);
			print(fish);
		}
	}

	public static int moveShark(int ox, int oy) {
		int val = 0;

		map[ox][oy] = null;

		val = map[sx][sy].name;
		map[sx][sy] = fish[0];
		sd = fish[val].dir;
		fish[0].dir = sd;
		fish[val] = null;
		fish[0].move(sx, sy);

		return val;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, d;
		for (int i = 0; i < 4; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				n = Integer.parseInt(st.nextToken());
				d = Integer.parseInt(st.nextToken()) - 1;
				fish[n] = new Fish(n, d, i, j);
				map[i][j] = fish[n];
			}
		}

		sd = map[0][0].dir;
		answer = map[0][0].name;
		fish[0] = new Fish(0, sd, 0, 0);// 상어는 0번!!
		map[0][0] = fish[0];
		fish[answer] = null;
		moveFish();
		print(fish);

		getAnswer(answer);

		System.out.println(answer);

	}
}
