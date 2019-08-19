package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Lab3_17142 {
	// 연구소 맵
	static int[][] lab;
	static int N;//크기
	static int[] virus;//바이러스 배열
	static int M;//바이러스 개수
	static int idx;//바이러스 실제 개수 

	static int dfs(int i, int[] v, int d) {
		//i 선택한 바이러스 인덱스, d는 선택한 개수
		v[d] = virus[i];//선택한 바이러스 배열
		int min = N * N;
		boolean ch = false;
		if (d == M - 1) { //마지막 바이러스 선택 후
			return bfs(v); 
		}
		for (int j = i + 1; j < idx ; j++) {
			int tmp = dfs(j, v, d + 1);
			if (tmp != -1) {
				min = min < tmp ? min : tmp;
				ch = true;
			}
		}
		return ch?min:-1;// 모두 방문한 경우가 한번도 없을 경우 -1 저장
	}
	
	public static int bfs(int[] v) {
		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };
		int[][] tmp = new int[N][N];
		
		//임시 맵 복사 ( 바이러스 가능장소는 복사 하지 않고, 벽/ 빈칸만 복사)
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				tmp[i][j] = lab[i][j];
			}
		}

		Queue<Integer> q = new LinkedList<Integer>();
		//dfs로 선택한 바이러스들 큐에 저장
		for (int i = 0; i < M; i++) {
			q.add(v[i]);
		}

		while (!q.isEmpty()) {
			//bfs
			int t = q.poll();

			for (int d = 0; d < 4; d++) {
				int nx = t / 100 + dx[d];
				int ny = t % 100 + dy[d];

				if (nx >= 0 && ny >= 0 && nx < N && ny < N && tmp[nx][ny] == 0) {
					//전 바이러스 칸 +1 ->큐에 저장
					tmp[nx][ny] = tmp[t / 100][t % 100] + 1;
					q.add(nx * 100 + ny);
				}
			}
		}
		//System.out.println();
		
		//바이러스가 시작된 곳이 0으로 되어있고, 바이러스 있는곳이 최대값이 나올 수 있기 때문에 -1로 변경
		for (int i = 0;i<idx; i++) {
			int p = virus[i];
			tmp[p / 100][p % 100] = -1;
		}
		
		// 한번의 선택 중에서 제일 높은 값 = 최종적으로 다 옮기는데 걸리는 시간
		int max = 0;
		for (int[] a : tmp) {
			//System.out.println(Arrays.toString(a));
			for (int b : a) {
				if (b == 0) {
					//아직 빈곳이 있다면 -1리턴
					return -1;
				}
				//가장 높은값 저장
				max = max > b ? max : b;
			}
		}
		return max;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		lab = new int[N][N];
		M = Integer.parseInt(st.nextToken());
		virus = new int[11];
		idx = 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int t = Integer.parseInt(st.nextToken());
				if (t == 2) {
					//바이러스 위치 저장, 지도에는 따로 표시하지 않는다.
					virus[idx++] = i * 100 + j;
				} else if (t == 1) {
					//벽은 -1로 저장
					lab[i][j] = -1;
				}
			}
		}
		//연구소의 모든 빈칸에 바이러스가 있게 되는 최소 시간
		int min = N * N;
		boolean ch = false;//모두 찾는 지 검사하기 위한 변수
		for (int i = 0; i < idx; i++) {
			int[] v = new int[M]; //선택한 바이러스 위치를 저장할 배열
			int tmp = dfs(i, v, 0); 
			if (tmp != -1) {
				//-1이 아닌 값들 중 가장 작은 수 저장
				min = min > tmp ? tmp : min;
				ch = true;
			}
		}
		//전부다 전염시키는 방법이 하나도 없다면 -1 저장
		min = ch? min : -1;
		System.out.println(min);
	}

}
