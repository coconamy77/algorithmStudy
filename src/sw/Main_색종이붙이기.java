package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_색종이붙이기 {
	static int[][] map = new int[10][10];
	static int[] cnt = new int[6];
	static int min = -1;

	public static boolean possible(int x, int y, int size) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (map[i][j] == 0)
					return false;
			}
		}
		return true;
	}

	public static void fill(int x, int y, int size, int value) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				map[i][j] = value;
			}
		}
	}

	public static void findMin(int count) {
		boolean flag = false;
		if (min!=-1 && min<=count) {
			return;
		}
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					flag = true;
					for (int k = 5; k > 0; k--) {
						if (cnt[k] < 5) {
							if (i + k <= 10 && j + k <= 10 && possible(i, j, k)) {
								//System.out.println(i+", "+j);
								fill(i, j, k, 0);
								cnt[k]++;
								findMin(count + 1);
								cnt[k]--;
								fill(i, j, k, 1);
							}
							if (count+1==min) {
								return;
							}
						}
					}
				}
			}
		}
		if (!flag) {
			if (min != -1) {
				if (min > count) {
					min = count;
				}
			} else {
				min = count;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		findMin(0);

		System.out.println(min);
	}

}