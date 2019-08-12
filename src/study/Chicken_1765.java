package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Chicken_1765 {

	static boolean[] chk; // visit배열
	static int[][] s;
	static int count = 0;

	static void getCount(int me, int friend, int rs) {

		if (rs == 1) { //둘의 관계가 친구이면
			if (chk[friend]) //방문표시
				return;
			chk[friend] = true;
		}
		for (int i = 0; i < s.length; i++) { //친구/원수의 관계조사
			if (i == me||i==friend) 	//자기 자신과 해당 관계의 친구라면 통과
				continue;
			if (s[friend][i] == rs) { //전의 관계와 같은 경우(원수의 원수, 친구의 친구 조사)
				getCount(friend, i, 1);	//친구 관계(1)로 다시 조사 ->원수의 원수도 내 친구, 그의 친구는 모두 내 친구
			}

		}
	}
	/*
	 * static void dfs(int x, int y) { chk[y]=true; for (int i = x+1;
	 * i<s.length;i++) { if (i<s.length && !chk[i] && s[y][i]==1) { dfs(y,i); } } }
	 */

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());

		s = new int[n][n];
		chk = new boolean[n];
		/*
		 * int[] q = new int[1001]; int qh = 0; int qt = 0;
		 */
		/* Queue<Integer> q = new LinkedList<Integer>(); */
		int m = Integer.parseInt(br.readLine());

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());

			char r = String.valueOf(st.nextToken()).charAt(0);

			int s1 = Integer.parseInt(st.nextToken());
			int s2 = Integer.parseInt(st.nextToken());

			s[s1 - 1][s2 - 1] = r == 'E' ? -1 : 1;
			s[s2 - 1][s1 - 1] = s[s1 - 1][s2 - 1];
		}

		/*
		 * for (int k = 0; k < n; k++) { for (int i = 0; i < n; i++) { for (int j = i +
		 * 1; j < n; j++) { if (s[k][i] == s[k][j] && s[k][i] != 0) { s[i][j] = 1;
		 * s[j][i] = 1; } } } }
		 */

		for (int[] a : s) {
			System.out.println(Arrays.toString(a));
		}

		for (int i = 0; i < n; i++) {
			if (chk[i]) {
				for (int j = 0; j < n; j++) {
					if (s[i][j] ==-1) { // 원수/친구 관계에 대한 조사
						getCount(i, j, s[i][j]);// 여기서 관계전달
						// q.add((i*1000+j)*s[i][j]);

					}
				}
			}

			else {
				count++;
				for (int j = 0; j < n; j++) {
					if (s[i][j] != 0) { // 원수/친구 관계에 대한 조사
						getCount(i, j, s[i][j]);// 여기서 관계전달
						// q.add((i*1000+j)*s[i][j]);

					}
				}
			}
			chk[i] = true;

			/*
			 * while(!q.isEmpty()) { int tmp = q.poll(); int x,y; if (tmp>0) { x = tmp/1000;
			 * y = tmp%1000; if (chk[y]) continue; chk[y] = true; for (int k = 0;k<n; k++) {
			 * if (k==x) { }else { if (s[y][k]==1) { q.add(y*1000+k); } }
			 * 
			 * } } else { x = -tmp/1000; y = -tmp%1000; for (int k = 0;k<n; k++) { if (k==x)
			 * { }else { if (s[y][k]==-1) { chk[y] = true; q.add(y*1000+k); } }
			 * 
			 * } }
			 * 
			 * }
			 */

		}

		/*
		 * for (int i = 0; i < n; i++) { if (chk[i]) continue; chk[i] = true; count++;
		 * for (int j=0; j<n;j++) { if(!chk[j]&& s[i][j]==1) { dfs(i,j); } } }
		 */
		System.out.println(count);
	}

}
