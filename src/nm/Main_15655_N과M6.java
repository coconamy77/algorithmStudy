package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_15655_N과M6 {

	static int N;
	static int M;
	static int[] ans,num;
	static StringBuilder sb = new StringBuilder();

	static void per(int depth,int s) {
		if (depth == M) {
			for (int i : ans) {
				sb.append(num[i]).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = s; i < N; i++) {
				ans[depth]=i;
				per(depth + 1,i);
	
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];
		num = new int[N];
		st = new StringTokenizer(br.readLine());

		for (int n = 0; n<N; n++) {
			num[n] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(num);
		
		per(0,0);
		
		bw.write(sb.toString());
		bw.flush();
	}
}
