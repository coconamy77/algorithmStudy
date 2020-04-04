package jungol;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_1535_단어집합2 {
	public static void main(String[] args) throws Exception{
		//Set<String> set = new HashSet<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		String s = st.nextToken();
		List<String> list = new ArrayList<String>();
		
		while(!s.equals("END")) {
			if (!list.contains(s)) {
				list.add(s);
			}
			while(st.hasMoreElements()) {
				s = st.nextToken();
				if (!list.contains(s)) {
					list.add(s);
				}
			}
			
			for (String str: list) {
				System.out.print(str+" ");
			}
			System.out.println();
			st = new StringTokenizer(br.readLine());
			s = st.nextToken();
		}
	}
}
