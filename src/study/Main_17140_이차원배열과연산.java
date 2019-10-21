package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int R = Integer.parseInt(st.nextToken()) - 1;
		int C = Integer.parseInt(st.nextToken()) - 1;
		int k = Integer.parseInt(st.nextToken());

		int[][] arr = new int[100][100];

		for (int r = 0; r < 3; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < 3; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}

		int[] count = new int[101];

		List<Integer> list = new ArrayList<Integer>();
		int cr = 3;
		int cc = 3;
		int ans = 0;
		while (arr[R][C] != k && ans<100) {
			ans++;
			if (cr >= cc) {
				
				for (int i = 0; i < 100; i++) {
					if (arr[i][0] == 0)
						break;
					for (int j = 0; j < 100; j++) {
						if (arr[i][j] == 0) {
							break;
						} else {
							if (!list.contains(arr[i][j])) {
								list.add(arr[i][j]);
							}
							count[arr[i][j]]++;
							//arr[i][j] = 0;
						}
					}
					System.out.println(ans);
					for (int ii = 0; ii<cr; ii++) {
						for (int j =0; j<cc; j++) {
							System.out.print(arr[ii][j]);
							arr[i][j] = 0;
						}
						System.out.println();
					}
					

					Collections.sort(list, new Comparator<Integer>() {

						@Override
						public int compare(Integer o1, Integer o2) {
							if (o1 == o2) {
								return Integer.compare(count[o1], count[o2]);
							}
							return Integer.compare(o1, o2);
						}
					});
					/*System.out.println(ans);
					for (int j = 0; j<list.size();j++) {
						System.out.print(list.get(j)+" "+ count[list.get(j)]+" ");
						//System.out.print(count[j+1]);
					}
					System.out.println();*/
					cc = list.size()*2>cc? list.size()*2:cc;
					for (int j = 0; j < list.size(); j++) {
						int t = list.remove(0);
						arr[i][j * 2] =count[t] ;
						arr[i][j * 2 + 1] = t;
						System.out.println(t+ " "+ count[t]);
						count[t] = 0;
					}

				}
				
			} else {
				for (int i = 0; i<100; i++) {
					if (arr[0][i] == 0) break;
					for (int j = 0; j<100; j++) {
						if (arr[j][i]==0) {
							break;
						}
						else {
							if (!list.contains(arr[j][i])) {
								list.add(arr[j][i]);
								count[arr[j][i]] = 1;
							}
							count[arr[j][i]]++;
							arr[j][i] = 0;
						}
					}
					
				Collections.sort(list, new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						if (o1==o2) {
							return Integer.compare(count[o1], count[o2]);
						}
						return Integer.compare(o1, o2);
					}
				});
				cr = list.size()*2>cr? list.size()*2:cr;
				for (int j  = 0; j<list.size();j++) {
					int t = list.remove(0);
					arr[j*2][i] = count[t];
					arr[j*2+1][i] = t;
					count[t] = 0;
				}
				
				}

			}

		}
		if (ans>100) ans = -1;
		System.out.println(ans);
	}

}
