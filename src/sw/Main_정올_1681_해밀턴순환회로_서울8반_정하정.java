package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_정올_1681_해밀턴순환회로_서울8반_정하정 {

	static int[][] map;
	static int N;
	static int min;

	static void getAns(int from, int dep, int sum, boolean[] vst) {
		if (dep == N) {
			if (map[from][0]==0) return;
			sum+=map[from][0];
			
			min=min<sum?min:sum;
			return;
		}
		if (sum>min)return;
		for (int i =1; i < N; i++) {
			if (!vst[i] && map[from][i]!=0) {
				vst[i] = true;
				getAns(i, dep+1, sum+map[from][i], vst);
				vst[i] = false;
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] sel = new int[N + 1];
		sel[N] = 0;
		sel[0] = 0;

		min = Integer.MAX_VALUE;

		getAns(0, 1, 0, new boolean[N]);

		System.out.println(min);

	}
}
