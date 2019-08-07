package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringWriter;

public class Hanoy_11729 {

	static int count = 0;
	static int idx;
	static StringWriter sw = new StringWriter();

	static void move(int h, int i) {

		int origin = i;
		if (h == 2) {

			for (int j = 1; j <= 3; j++) {
				if (j != idx && j != origin) {
					sw.append(origin + " ").append(j + "\n");
					count++;
				}
			}
			origin = idx;
			idx = idx - 1 < 1 ? 3 : idx - 1;
			count++;
			sw.append(origin + " ").append(idx + "\n");

		} else {
			for (int j = 1; j <= 3; j++) {
				if (j != idx && j != origin) {
					sw.append(origin + " ").append(j + "\n");
					count++;
					break;
				}
			}

			move(h - 1, idx);
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		idx = 3;
		count++;
		sw.append(1 + " ").append(idx + "\n");
		for (int h = 2; h <= n; h++) {
			move(h, 1);
		}
		System.out.println(count);
		System.out.println(sw.toString());
	}
}
