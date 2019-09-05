package nm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_15650_N과M2 {

	static int N;
	static int M;
	static int[] ans;
	static StringBuilder sb = new StringBuilder();

	static void per(int depth,int last) {
		if (depth == M) {
			for (int i : ans) {
				sb.append(String.valueOf(i)).append(" ");
			}
			sb.append("\n");
			return;
		}

		for (int i = last; i < N; i++) {
				ans[depth]=(i + 1);
				per(depth + 1,i+1);
	
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = new int[M];

		per(0,0);
		
		bw.write(sb.toString());
		bw.flush();
        bw.close();
        br.close();
	}
}
