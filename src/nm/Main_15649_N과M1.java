package nm;
//으아아아아아 왜 안돼
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15649_N과M1 {

	static int N;
	static int M;
	static int[] ans;
	static boolean[] vst;
	static StringBuilder sb = new StringBuilder();

	static void per(int depth) {
		if (depth == M) {
			for (int i : ans) {
				sb.append(String.valueOf(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = 0; i < N; i++) {
			if (!vst[i]) {
				ans[depth]=(i + 1);
				vst[i] = true;
				per(depth + 1);
				vst[i] = false;
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		vst = new boolean[N];
		ans = new int[M];

		per(0);
		
		bw.write(sb.toString());
		bw.flush();
        bw.close();
        br.close();
	}
}
