package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main_1516_단어세기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		Map<String, Integer> map = new HashMap<>();

		String s = st.nextToken();
		while (!s.equals("END")) {
			//System.out.println(st.toString());
			map.clear();
			List<String> list = new ArrayList<>();
			if (!map.containsKey(s)) {
				map.put(s, 1);
				list.add(s);
			} else {
				map.replace(s, map.get(s) + 1);
			}
			while (st.hasMoreTokens()) {
				s = st.nextToken();
				if (!map.containsKey(s)) {
					map.put(s, 1);
					list.add(s);
				} else {
					map.replace(s, map.get(s) + 1);
				}
			}
			
			Collections.sort(list,new Comparator<String>() {

				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return o1.compareTo(o2);
				}
			});
			
			for (String str: list) {
				System.out.println(str+" : "+map.get(str));
			}
			
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
		}
		
	}
}
