package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.io.StringWriter;

public class Hanoy_11729 {

	static int count = 0;
	static int idx;
	static StringBuilder sw = new StringBuilder();
	
	
	static void move(int h, int i) {

		int origin = i;
		if (h == 1) {
			origin = i;
			idx = i - 1 < 1 ? 3 : i - 1;
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
			int nOrigin = idx;
			for (int n=1;n<=h-1;n++) {
				move(n,nOrigin);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		//idx = 1;
		
		if (n%2==0)idx = 2;
		else idx = 3;
		count++;
		sw.append(1 + " ").append(idx + "\n");
		
		for (int h = 2; h <= n; h++) {
			move(h, 1);
		}
		System.out.println(count);
		System.out.print(sw);
	}
}
