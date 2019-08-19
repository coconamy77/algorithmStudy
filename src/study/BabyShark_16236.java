package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BabyShark_16236 {
	static int[][] map;
	static int[] fish;
	static int x;
	static int y;
	static int size = 2;
	
	static int findWay(int i, int j) {
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		q.add(i*50+j);
		
		while(!q.isEmpty()) {
			
		}
		
		
		return 0;
	}
	
	static int go() {

		int f = 0;
		int eat = 0;
		int ans = 0;
		for (int n = 1; n < size; n++) {
			f += fish[n];
		}
		
		while (f > 0) {
			int min = map.length * 2;
			int distance = 0, nx = 0, ny = 0;
			for (int i = 0; i < map.length; i++) {
				if ((i>x && min<i-x)||(i<x && min<x-i)) {
					break;
				}
				for (int j = 0; j < map.length; j++) {
					if ((j>y && min<j-y)||(j<y && min<y-j)) {
						break;
					}
					if (map[i][j] != 0 && map[i][j] < size) {
						distance = findWay(i,j);
						
						/*if (x - i < 0) {
							if (y - j < 0)
								distance = i - x + j - y;
							else
								distance = i - x + y - j;
						} else {
							if (y - j < 0)
								distance = x - i + j - y;
							else
								distance = x - i + y - j;
						}*/
						if (min > distance) {
							min = distance;
							nx = i;
							ny = j;
						}
					}
				}
			}
			
			fish[map[nx][ny]]--;
			f--;
			eat++;
			ans += min;
			System.out.println("+"+min+" = "+ans);
			map[nx][ny] = 9;
			map[x][y] = 0;
			x = nx;
			y = ny;
			for (int[] a : map) {
				System.out.println(Arrays.toString(a));
			}
			if (eat<=6 && eat==size) {
				f += fish[size];
				size++;
				eat = 0;
				//System.out.println(size);
			}
		}
		return ans;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		fish = new int[7];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tmp = Integer.parseInt(st.nextToken());
				if (tmp != 0) {
					if (tmp == 9) {
						x = i;
						y = j;
					} else {
						fish[tmp]++;
					}
					map[i][j] = tmp;
				}
			}
		}
		
		System.out.println(go());
	}
}
