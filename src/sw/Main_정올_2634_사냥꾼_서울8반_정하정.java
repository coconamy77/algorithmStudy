package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_2634_사냥꾼_서울8반_정하정 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		int[] hunter = new int[M];
		List<int[]> ani = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for (int m = 0; m < M; m++) {
			hunter[m] = Integer.parseInt(st.nextToken());

		}
		int count = 0;
		for (int n = 0; n < N; n++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			if (y <= L)
				ani.add(new int[] { x, y });
		}

		Arrays.sort(hunter);
		Collections.sort(ani, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[0] + o1[1] > o2[0] + o2[1])
					return 1;
				else if (o1[0] + o1[1] == o2[0] + o2[1]) {
					if (o1[0] > o2[0])
						return 1;
				}
				return -1;
			}
		});
		int a = 0;
		int h = 0;

		while (h < M && a<ani.size()) {
			int x = ani.get(a)[0];
			int y = ani.get(a)[1];
			if (Math.abs(hunter[h] - x) + y <= L) {
				count++;
				a++;
			} else {
				if (hunter[h] < x)
					h++;
				else
					a++;
			}

		}
		System.out.println(count);

	}
}
