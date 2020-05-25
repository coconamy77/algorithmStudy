package reference;

import java.util.Arrays;

public class Permutation {

	static int num[] = { 3, 4, 2, 1, 6 };
	static int list[];
	static boolean visited[];
	static int length = num.length;
	static int count;

	public static void permutation(int v, int limit, int cnt) {
		list[cnt] = num[v];
		if (cnt == limit) {
			System.out.println(Arrays.toString(list));
			return;
		}
		for (int i = 0; i < length; i++) {
			if (!visited[i]) {
				visited[i] = true;
				permutation(i, limit, cnt + 1);
				visited[i] = false;
			}
		}
	}

	// 메인 호출 부분!
//	visited = new boolean[length];
//	for (int i = 0; i < length; i++) {
//		list = new int[i+1];
//		for (int j = 0; j < length; j++) {
//			visited[j] = true;
//			permutation(j, i, 0);
//			visited[j] = false;
//		}
//	}
}
