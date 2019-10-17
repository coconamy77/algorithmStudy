package study;

import java.util.Arrays;

public class MyCombi {
	static int[] data = { 1, 2, 3, 4 };
	static int[] data2 = { 91, 91, 92, 10093, 10093, 9994 };
	static int[] res;
	static boolean[] visit,visit2;
	static int cnt;

	public static void main(String[] args) {
		int N = 4, N2 = 6, R = 2;
		res = new int[R];
		visit = new boolean[N];
		visit2 = new boolean[N2];

		cnt = 0;
		solve1(N, R, 0);
		System.out.println();
		System.out.println("중복순열: " + cnt);

		cnt = 0;
		solve2(N, R, 0);
		System.out.println();
		System.out.println("순열: " + cnt);

		cnt = 0;
		solve3(N, R, 0, 0);
		System.out.println();
		System.out.println("중복조합: " + cnt);

		cnt = 0;
		solve4(N, R, 0, 0);
		System.out.println();
		System.out.println("조합: " + cnt);

		cnt = 0;
		solve5(N2, R, 0);
		System.out.println();
		System.out.println("중복값이 있는 순열: " + cnt);

		cnt = 0;
		solve6(N2, R, 0, 0);
		System.out.println();
		System.out.println("중복값이 있는 조합: " + cnt);
	}

	// 중복순열: 순서가 중요하고(123!=321), 중복을 허용하는 경우
	private static void solve1(int n, int r, int depth) {
		if (depth == r) {
			System.out.print(Arrays.toString(res));
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			res[depth] = data[i];
			solve1(n, r, depth + 1);
		}
	}

	// 순열: 순서가 중요하고(123!=321), 중복을 허용하지 않는 경우
	private static void solve2(int n, int r, int depth) {
		if (depth == r) {
			System.out.print(Arrays.toString(res));
			cnt++;
			return;
		}

		for (int i = 0; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				res[depth] = data[i];
				solve2(n, r, depth + 1);
				visit[i] = false;
			}
		}
	}

	// 중복조합: 순서가 중요하지 않고(123==321), 중복을 허용하는 경우
	private static void solve3(int n, int r, int depth, int start) {
		if (depth == r) {
			System.out.print(Arrays.toString(res));
			cnt++;
			return;
		}

		for (int i = start; i < n; i++) {
			res[depth] = data[i];
			solve3(n, r, depth + 1, i);
		}
	}

	// 조합: 순서가 중요하지 않고(123==321), 중복을 허용하지 않는 경우
	private static void solve4(int n, int r, int depth, int start) {
		if (depth == r) {
			System.out.print(Arrays.toString(res));
			cnt++;
			return;
		}

		for (int i = start; i < n; i++) {
			if (visit[i] == false) {
				visit[i] = true;
				res[depth] = data[i];
				solve4(n, r, depth + 1, i);
				visit[i] = false;
			}
		}
	}

	// 중복값이 있는 순열: 순서가 중요하고(123!=321), 중복을 허용, 중복값을 허용하지 않는 경우
	private static void solve5(int n, int r, int depth) {
		if (depth == r) {
			System.out.print(Arrays.toString(res));
			cnt++;
			return;
		}
		boolean[] ch = new boolean[5];
		for (int i = 0; i < n; i++) {
			if (ch[data2[i]])
				continue;
			ch[data2[i]] = true;
			res[depth] = data2[i];
			solve5(n, r, depth + 1);
		}
	}

	// 중복값이 있는 조합: 순서가 중요하지 않고(123==321), 중복을 허용, 중복값을 허용하지 않는 경우
	private static void solve6(int n, int r, int depth, int start) {
		if (depth == r) {
			System.out.print(Arrays.toString(res));
			cnt++;
			return;
		}
		boolean[] ch = new boolean[5];
		for (int i = start; i < n; i++) {
			if (visit2[i] == false && !ch[data2[i]]) {
				ch[data2[i]] = true;
				visit2[i] = true;
				res[depth] = data2[i];
				solve6(n, r, depth + 1, i);
				visit2[i] = false;
			}
		}
	}

}