package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main_정올_2247_도서관_서울8반_정하정 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		List<int[]> stu = new ArrayList<>();
		for (int n=0; n<N; n++) {
			st = new StringTokenizer(br.readLine());
			stu.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		Collections.sort(stu, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0]>o2[0])return 1;
				else if(o1[0]==o2[0]) {
					if (o1[1]>o2[1]) {
						return 1;
					}
				}
				return -1;
			}
		});
		int s = stu.get(0)[0]; int e = stu.get(0)[1];
		int emp = s-1;
		int ful = e-s;
		for (int i = 1; i<N; i++) {
			if (e>=stu.get(i)[0]) {
				e = e>stu.get(i)[1]?e:stu.get(i)[1];
				ful = ful>e-s?ful: e-s;
			}else {
				s = stu.get(i)[0];
				emp = emp>s-e?emp:s-e;
				e = stu.get(i)[1];
			}
		}
		
		//if (e!=25) {
			//emp = emp>25-e? emp: 25-e;
		//}
		
		System.out.println(ful+" "+emp);
		
		
		
	}
}
