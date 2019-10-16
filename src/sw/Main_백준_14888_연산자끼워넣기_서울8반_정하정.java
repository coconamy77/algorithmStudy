package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main_백준_14888_연산자끼워넣기_서울8반_정하정 {

	static int[] nums;
	static int[] oper;
	static int N, min, max;

	static void getAns(int dep, int[] sel, boolean[] vst) {
		if (dep == N - 1) {
			int tmpAns = nums[0];
			for (int i = 0; i < N - 1; i++) {
				switch (oper[sel[i]]) {
				case 0:
					tmpAns += nums[i + 1];
					break;
				case 1:
					tmpAns -= nums[i + 1];
					break;
				case 2:
					tmpAns *= nums[i + 1];
					break;
				case 3:
					tmpAns /= nums[i + 1];
					break;
				}
			}
			if (max < tmpAns) {
				max = tmpAns;
			}
			if (min > tmpAns) {
				min = tmpAns;
			}
		} else {
			Set<String> chk = new HashSet<>();
			for (int i = 0; i < N - 1; i++) {
				if (!vst[i] && !chk.contains(oper[i] + "")) {
					chk.add(oper[i] + "");
					vst[i] = true;
					sel[dep] = i;
					getAns(dep + 1, sel, vst);
					vst[i] = false;
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		nums = new int[N];

		oper = new int[N - 1];
		st = new StringTokenizer(br.readLine());
		for (int n = 0; n < N; n++) {
			nums[n] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		int idx = 0;
		for (int i = 0; i < 4; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			for (int j = 0; j < tmp; j++) {
				oper[idx++] = i;
			}

		}
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		getAns(0, new int[N - 1], new boolean[N - 1]);
		System.out.println(max);
		System.out.println(min);

	}
}
