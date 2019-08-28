package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_1828_냉장고_서울8반_정하정 {
	static List<int[]> ref;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		ref = new ArrayList<int[]>();
		//ArrayList<Integer> temp = new ArrayList<>();
		/*int min = -270;
		int max = 10000;*/
		
		for(int n = 0; n<N; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int l = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			ref.add(new int[] {l,h});
		
		}
		
		Collections.sort(ref,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]>o2[1])	return 1;
				else return -1;
			}
		});
		
		int j = 0,count = 1;
		for (int i = 1; i<ref.size(); i++) {
			if (ref.get(j)[1]<ref.get(i)[0]) {
				count++;
				j = i;
			}
			
		}
		
		
		
		System.out.println(count);
		
	}
}
