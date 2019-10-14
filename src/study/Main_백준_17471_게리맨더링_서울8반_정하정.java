package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Main_백준_17471_게리맨더링_서울8반_정하정 {

	static int N;
	static int[] sec;
	static int[][] map;
	static int min = Integer.MAX_VALUE;

	static void sel(int dep, int[] sel) {
		if (dep == N) {
			int[] vil1 = new int[10];
			int[] vil2 = new int[10];
			int num1 = 0, num2 = 0;
			for (int i = 0; i < N; i++) {
				if (sel[i] == 0) {
					vil1[num1++] = i;

				} else {
					vil2[num2++] = i;
				}
			}
			if (num1 == 0 || num2 == 0)
				return;
			if (isCon(vil1, num1, 0, new boolean[num1]) && isCon(vil2, num2, 0, new boolean[num2])) {
				int sum1 = 0, sum2 = 0;
				for (int i = 0; i < num1; i++) {
					sum1 += sec[vil1[i]];
				}
				for (int i = 0; i < num2; i++) {
					sum2 += sec[vil2[i]];
				}
				int tmp = Math.abs(sum1 - sum2);
				min = tmp > min ? min : tmp;
			}
		} else {
			sel[dep] = 0;
			sel(dep + 1, sel);
			sel[dep] = 1;
			sel(dep + 1, sel);

		}
	}

	static boolean isCon(int[] v, int num, int dep, boolean[] vst) {
		vst[dep] = true;
		for (int i = 0; i < num; i++) {
			if (map[v[dep]][v[i]] == 1 && !vst[i]) {
				isCon(v,num, i,vst);
			}
		}
		if (dep == 0) {
			for (boolean vs : vst) {
				if (!vs)
					return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		sec = new int[N];
		map = new int[N][N];

		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			sec[n] = Integer.parseInt(st.nextToken());

		}

		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int num = Integer.parseInt(st.nextToken());

			for (int i = 0; i < num; i++) {
				int tmp = Integer.parseInt(st.nextToken()) - 1;
				map[n][tmp] = 1;
				map[tmp][n] = 1;
			}

		}
		sel(1, new int[N]);
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);
	}
}
/*
 * 6 2 2 2 2 2 2 1 3 1 4 1 1 1 2 1 6 1 5
 * 
 */