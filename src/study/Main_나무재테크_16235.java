package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Rand {
	List<Integer> tree = new ArrayList<>();
	List<Integer> tmptree = new ArrayList<>();
	int nour;

	public Rand(int nour) {
		this.nour = nour + 5;
	}

	public int getNum() {

		// 크기반환 메소드
		return tree.size();
	}

	public void sort() {
		// 정렬메소드
		Collections.sort(tree);
	}

	public void die(int i) {
		// i 이상의 나무 삭줴(정렬한 후라 뒤에있는거 걍 삭제하면 됨, 삭제하면서 죽은 나무리스트로 변환)
		for (int j = i; j < tree.size();) {
			tmptree.add(tree.remove(j));

		}
	}

	public void spring() {
		// 봄메서드
		for (int i = 0; i < tree.size(); i++) {
			// 정렬 후라 걍 앞에서부터-> 어린순
			int age = tree.get(i);
			if (age <= nour) {
				nour -= age;// 나이만큼 양분 감소
				tree.set(i, ++age);// 양분 먹었으면 나이 증가
			} else {
				die(i);
				break;
			}

		}
	}

	public void summer() {
		for (int i = 0; i < tmptree.size();) {
			nour += tmptree.remove(i) / 2;
		}
	}

	public void fall() {
		for (int i = 0; i < tmptree.size();) {
			tree.add(tmptree.remove(i));
		}

		sort();
	}

}

public class Main_나무재테크_16235 {

	static Rand[][] map;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { 1, 1, 0, -1, -1, -1, 0, 1 };
	static int N;
	static int k = 0;
	static int[][] winter;
	static List<Integer> rand = new ArrayList<>(N * N);

	static void fall(int x, int y) {

		for (int t : map[x][y].tree) {
			if (t % 5 == 0) {
				for (int d = 0; d < 8; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
						if (map[nx][ny] == null) {
							map[nx][ny] = new Rand(k * winter[nx][ny]);
							rand.add(nx * N + ny);
						}
						map[nx][ny].tmptree.add(1);
					}
				}
			}
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		winter = new int[N][N];// 겨울에 추가되는 양분?
		map = new Rand[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				winter[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int m = 0; m < M; m++) {
			st = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(st.nextToken()) - 1;
			int j = Integer.parseInt(st.nextToken()) - 1;
			int age = Integer.parseInt(st.nextToken());
			if (map[i][j] == null) {
				map[i][j] = new Rand(0);
				rand.add(i * N + j);
			}

			map[i][j].tree.add(age);
		}

		for (int i = 0; i < rand.size(); i++) {// 나무가 있는 땅들은 정렬!
			int x = rand.get(i);
			map[x / N][x % N].sort();

		}

		for (; k < K; k++) {
			// 봄: 나무가 자신의 나이만큼 땅에 있는 양분을 먹고, 나이가 1증가-> 어린나무부터...-> 모자르면 죽음
			for (int i = 0; i < rand.size(); i++) {
				int x = rand.get(i);
				map[x / N][x % N].spring();

			}

			// 여름 : 죽은 나무가 양분으로 변한다-> 죽은 나무의 나이/2 만큼 추가
			for (int i = 0; i < rand.size(); i++) {
				int x = rand.get(i);
				map[x / N][x % N].summer();
			}

			// 가을 : 나무가 번식, 나이가 5의 배수인 나무만 번식하며, 인접한 8개의 칸에 나이가 1인 나무
			for (int i = 0; i < rand.size(); i++) {
				int x = rand.get(i);
				fall(x / N, x % N);

			}

			// 가을 : 나무가 번식, 나이가 5의 배수인 나무만 번식하며, 인접한 8개의 칸에 나이가 1인 나무
			for (int i = 0; i < rand.size(); i++) {
				int x = rand.get(i);
				map[x / N][x % N].fall();
			}

			for (int i = 0; i < rand.size(); i++) {
				int x = rand.get(i);
				map[x / N][x % N].nour += winter[x / N][x % N];
					
			}

		}
		int total = 0;
		for (int i = 0; i < rand.size(); i++) {
			int x = rand.get(i);
			total += map[x / N][x % N].getNum();
		}
		System.out.println(total);

	}
}
