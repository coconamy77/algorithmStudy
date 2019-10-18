package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.StringTokenizer;

public class Main_17140_이차원배열과연산 {
	public static void main(String[] args) throws Exception {

		int[][
		      ] arr = new int[100][100];

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken())-1;
		int c = Integer.parseInt(st.nextToken())-1;
		int k = Integer.parseInt(st.nextToken());
		for (int i = 0; i < 3; i++) {
			 st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int rn = 3;
		int cn = 3;
		int ans = 0;
		//while (arr[r][c] != k) {
			ans++;
			if (rn >= cn) {
				int countr = 0;
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int i = 0; i < rn; i++) {
					for (int j = 0; j < cn; j++) {
						int a = arr[i][j];
						if (a == 0)
							break;
						else {
							if (map.containsKey(a)) {
								int count = map.get(a);
								map.replace(a, count++);
							} else {
								map.put(a, 1);
							}
						}
					}
					List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
					
					Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							int comp = o1.getValue() - o2.getValue();
							comp = comp == 0 ? o1.getKey() - o2.getKey() : comp;
							return comp;
						}
					});
					countr = countr > list.size() * 2 ? countr : list.size() * 2;
					for (int j = 0; j < list.size(); j++) {
						arr[i][j*2] =((Map.Entry<Integer, Integer>) list.get(j)).getKey();
						arr[i][j*2+1] =((Map.Entry<Integer, Integer>) list.get(j)).getValue();
					}
					System.out.println(list);
				}
				
			} else {
				int countc = 0;
				Map<Integer, Integer> map = new HashMap<Integer, Integer>();
				for (int j = 0; j < rn; j++) {
					for (int i = 0; i < cn; i++) {
						int a = arr[i][j];
						if (a == 0)
							break;
						else {
							if (map.containsKey(a)) {
								int count = map.get(a);
								map.replace(a, count++);
							} else {
								map.put(a, 1);
							}
						}
					}
					List<Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
					
					Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {

						@Override
						public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
							int comp = o1.getValue() - o2.getValue();
							comp = comp == 0 ? o1.getKey() - o2.getKey() : comp;
							return comp;
						}
					});
					countc = countc > list.size() * 2 ? countc : list.size() * 2;
					for (int i = 0; i < list.size(); i++) {
						arr[i*2][j] =((Map.Entry<Integer, Integer>) list.get(i)).getKey();
						arr[i*2+1][j] =((Map.Entry<Integer, Integer>) list.get(i)).getValue();
					}
					System.out.println(list);
				}
			}
		//}
			for (int[] aaa: arr) {
				System.out.println(Arrays.toString(aaa));
			}
		System.out.println();
		System.out.println(ans);

	}

}
