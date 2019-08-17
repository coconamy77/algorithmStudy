/*package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Escape_3055 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String nm = br.readLine();
		int N = Integer.parseInt(nm.split(" ")[0]);
		int M = Integer.parseInt(nm.split(" ")[1]);

		int[][] map = new int[N][M];
		int gd = 0,water = 0, bb = 0;

		Queue<Integer> w = new LinkedList<Integer>();

		for (int n = 0; n < N; n++) {
			nm = br.readLine();
			for (int m = 0; m < M; m++) {
				switch (nm.charAt(m)) {
				case '*':
					map[n][m] = -1;
					water = -1 * (n * 100 + m)-1;
					break;
				case 'X':
					map[n][m] = -1;
					break;
				case 'D':
					bb = n * 100 + m;
					break;
				case 'S':
					gd = n * 100 + m;
					map[n][m] = 1;
					break;
				}
			}

		}
		if(water<0)
			w.offer(water);
		w.offer(gd);
		int count = 1;
		boolean safe = false;

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		while (!safe && !w.isEmpty()) {
			int t = w.poll();
			// System.out.println(t);
			boolean isGd = true;
			if (t < 0) {
				isGd = false;
				t = -(t+1);
			}
			
			int x = t / 100;
			int y = t % 100;

			for (int i = 0; i < 4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				//System.out.println("x=" + nx + ",y=" + ny );
				if (nx >= 0 && nx < map.length && ny >= 0 && ny < map[0].length && map[nx][ny] != -1) {
					if (isGd) {
						
						if (nx * 100 + ny == bb) {
							count = count<map[x][y]+1? map[x][y] + 1:count;
							map[nx][ny] = count;
							safe = true;
							break;
						} else {
							if (map[nx][ny] == 0) {
								count = count<map[x][y]+1? map[x][y] + 1:count;
								map[nx][ny] = count;
								w.add(nx * 100 + ny);
							}

						}
					} else {
						if (nx * 100 + ny == bb)continue;
						map[nx][ny] = -1;
						w.add(-1 * (nx * 100 + ny)-1);
					}

				}
			}
			System.out.println(t+"고슴도치?"+isGd);
			
			for (int[] a : map) {
				
				System.out.println(Arrays.toString(a));
			}
		}
		if (safe)
			System.out.println(map[bb/100][bb%100]-1);
		else
			System.out.println("KAKTUS");

	}
}
*/
package study;

import java.io.BufferedReader; import java.io.IOException; import java.io.InputStreamReader; import java.util.LinkedList; import java.util.Queue; import java.util.StringTokenizer;
public class Escape_3055 {
static char[][] array;
static Queue<Integer> queue_star = new LinkedList<Integer>();
static Queue<Integer> queue_star2 = new LinkedList<Integer>();
static Queue<Integer> queue_S = new LinkedList<Integer>();
static Queue<Integer> queue_S2 = new LinkedList<Integer>();
static int count=0;
public static void main(String[] args) throws IOException {
    BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(in.readLine(), " ");
    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());
    String str;
    array = new char[n + 2][m + 2];
    for (int i = 0; i < n + 2; i++) {
        for (int j = 0; j < m + 2; j++) {
            array[i][j] = '&'; //벽
        }
    }

    for (int i = 1; i < n + 1; i++) {
        str = in.readLine().trim();
        for (int j = 1; j < m + 1; j++) {
            array[i][j] = str.charAt(j-1);
            if (array[i][j] == '*') {
                queue_star.offer(i);
                queue_star.offer(j);
            }
            if (array[i][j] == 'S') {
                queue_S.offer(i);
                queue_S.offer(j);
            }
        }
    }
    while (true) {
        int tempi;
        int tempj;
        count++; //횟수 증가
        if(count>n*m) //횟수를 맵크기로 해줘야 함 이거땜에 틀렸었음
        {
            System.out.println("KAKTUS"); //못 찾
            return;
        }
        while (!queue_star.isEmpty()) {//물큐 순서 중요
            tempi = queue_star.poll();
            tempj = queue_star.poll(); //물이 먼저 가야함
            if (array[tempi+1][tempj] == '.') { //갈 수 있으면
                array[tempi+1][tempj] = '*';
                queue_star2.offer(tempi+1);
                queue_star2.offer(tempj);
            }
            if (array[tempi-1][tempj] == '.') {
                array[tempi-1][tempj] = '*';
                queue_star2.offer(tempi-1);
                queue_star2.offer(tempj);
            }
            if (array[tempi][tempj+1] == '.') {
                array[tempi][tempj+1] = '*';
                queue_star2.offer(tempi);
                queue_star2.offer(tempj+1);
            }
            if (array[tempi][tempj-1] == '.') {
                array[tempi][tempj-1] = '*';
                queue_star2.offer(tempi);
                queue_star2.offer(tempj-1);
            }
        }
        while(!queue_star2.isEmpty()) {//동물 큐
            queue_star.offer(queue_star2.poll());
        }

        while (!queue_S.isEmpty()) {
            tempi = queue_S.poll();
            tempj = queue_S.poll();
            if (array[tempi+1][tempj] == 'D') {//목적지 도착하면 끝
                System.out.println(count);
                return;
            }
            if (array[tempi-1][tempj] == 'D') {
                System.out.println(count);
                return;
            }
            if (array[tempi][tempj+1] == 'D') {
                System.out.println(count);
                return;
            }
            if (array[tempi][tempj-1] == 'D') {
                System.out.println(count);
                return;
            }

            if (array[tempi+1][tempj] == '.') { //갈 수 있으면
                array[tempi+1][tempj] = 'S';
                queue_S2.offer(tempi+1);
                queue_S2.offer(tempj);
            }
            if (array[tempi-1][tempj] == '.') {
                array[tempi-1][tempj] = 'S';
                queue_S2.offer(tempi-1);
                queue_S2.offer(tempj);
            }
            if (array[tempi][tempj+1] == '.') {
                array[tempi][tempj+1] = 'S';
                queue_S2.offer(tempi);
                queue_S2.offer(tempj+1);
            }
            if (array[tempi][tempj-1] == '.') {
                array[tempi][tempj-1] = 'S';
                queue_S2.offer(tempi);
                queue_S2.offer(tempj-1);
            }
        }
        while(!queue_S2.isEmpty()) {
            queue_S.offer(queue_S2.poll()); //temp값 사용
        }

    }

}
}