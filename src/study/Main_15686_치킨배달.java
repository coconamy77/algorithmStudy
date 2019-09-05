package study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15686_치킨배달 {

	static int[] chicken, home;
	static int M, min = Integer.MAX_VALUE;
	static int nc = 0, nh = 0;

	static void select(int i, int start, int[] selected) {
		if (i == M) {
			int tmp = getcd(selected);
			min = tmp > min ? min : tmp;
		} else {
			for (int j = start; j < nc; j++) {
				selected[i] = chicken[j];
				select(i + 1, j + 1, selected);
			}
		}
	}

	static int getcd(int[] sel) {
		int sum = 0;
		for (int i = 0; i < nh; i++) {
			int dis = Integer.MAX_VALUE;
			int h = home[i];
			for (int j = 0; j<M; j++) {
				int c = sel[j];
				int tmp = Math.abs(c/100-h/100)+Math.abs(c%100-h%100);
				dis = tmp>dis?dis:tmp;
			}
			sum+=dis;
			if (sum>min) break;
		}
		return sum;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		chicken = new int[13];
		home = new int[2 * N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if (t == 2) {
					chicken[nc++] = i * 100 + j;
				} else if (t == 1) {
					home[nh++] = i * 100 + j;
				}
			}
		}
		int[] selected = new int[M];
		select(0, 0, selected);
		
		System.out.println(min);
	}
}
