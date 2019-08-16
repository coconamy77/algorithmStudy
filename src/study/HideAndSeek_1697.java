package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class HideAndSeek_1697 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int subin = Integer.parseInt(st.nextToken());
		int sis = Integer.parseInt(st.nextToken());

		Queue<Integer> q = new LinkedList<Integer>();
		
		int[] vst = new int[100001];
		
		q.add(subin);
		vst[subin] = 0;
		int count = 0;
		boolean chk = true;
		if (subin == sis) {
			System.out.println(count);
			chk = false;
		}

		while (chk && !q.isEmpty()) {
			
			int a = q.poll();
			
			count = vst[a]+1;
			int[] dd = { 1, -1, a };
			for (int i = 0; i < 3; i++) {
				int nsubin = a+dd[i];
				
				if (nsubin<0 || nsubin> 100000  || vst[nsubin]!=0) {
					continue;
				}
				
				if (nsubin == sis) {
					System.out.println(count);
					chk = false;
					break;
				}else {
						vst[nsubin] = count;
						q.add(nsubin);
					
				}
			}
		}
		
	}
}
