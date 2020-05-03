package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17825_주사위윷놀이 {

	static int[] dice = new int[10];
	static int[][] score = { { 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34, 36, 38, 40 },
			{ 0, 2, 4, 6, 8, 10, 13, 16, 19, 25, 30, 35, 40 },
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 25, 30, 35, 40 },
			{ 0, 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 28, 27, 26, 25, 30, 35, 40 } };

	static int answer = 0;

	static void getAns(int dep, int[] sel) {
		if (dep == 10) {
			int sum = 0;
			int[] diceLoc = new int[4];// 0->경로, 1->idx
			int tmp = 0;
			for (int i = 0; i < 10; i++) {
				tmp = sel[i];
				diceLoc[tmp] += dice[i];
				//System.out.println("현재위치 : " + Arrays.toString(diceLoc));

				if (diceLoc[tmp] / 100 == 0) {
					switch (diceLoc[tmp]) {
					case 5:
						diceLoc[tmp] += 100;
						break;
					case 10:
						diceLoc[tmp] += 200;
						break;
					case 15:
						diceLoc[tmp] += 300;
						break;
					case 20:
						diceLoc[tmp] = 112;
						break;
					}
				}else if (diceLoc[tmp] / 100 == 3){
					if (diceLoc[tmp]>=319) {
						diceLoc[tmp] = diceLoc[tmp]-319+109;
					}
				}else if (diceLoc[tmp] / 100 == 2){
					if (diceLoc[tmp]>=213) {
						diceLoc[tmp] = diceLoc[tmp]-213+109;
					}
				}
				
				if (diceLoc[tmp] % 100 < score[diceLoc[tmp] / 100].length) {
					
					for (int j = 0; j < 4; j++) {
						if (tmp == j) {
							continue;
						}
						if (diceLoc[tmp] == diceLoc[j]) {
							return;
						}
					}

					sum += score[diceLoc[tmp] / 100][diceLoc[tmp] % 100];
					//System.out.println(score[way][location]);
				}
			}
			if (sum > answer) {
//				System.out.println(Arrays.toString(sel));
//
//				System.out.println("경로 : " + Arrays.toString(diceLoc));
				answer = sum;
			}

		} else {
			for (int i = 0; i < 4; i++) {
				sel[dep] = i;
				getAns(dep + 1, sel);
			}
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < 10; i++) {
			dice[i] = Integer.parseInt(st.nextToken());
		}

		for (int i =0; i<4;i++ ) {
			int[] sel = new int[10];
			sel[0] = i;
			getAns(1, sel);
		}
		//getAns(10, new int[] { 0, 0, 1, 0, 2, 2, 2, 0, 2, 2 });
		System.out.println(answer);
	}
}
