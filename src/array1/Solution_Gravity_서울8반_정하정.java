package array1;

import java.util.Scanner;

public class Solution_Gravity_서울8반_정하정 {

	/*
	 * 상자들이 쌓여있는 방이 있다. 방이 오른쪽으로 90도 회전하여 상자들이 중력의 영향을 받아 낙하한다고 할 때, 
	 * 낙차가 가장 큰 상자를 구하여 그 낙차를 리턴 하는 프로그램을 작성하시오 
	 * 
	 * 
	 
	 * 중력은 회전이 완료된 후 적용된다.
	 * 상자들은 모두 한쪽 벽면에 붙여진 상태로 쌓여 2차원의 형태를 이루며 벽에서 떨어져서 쌓인 상자는 없다.
	 * 방의 가로길이는 항상 100이며, 세로 길이도 항상 100이다.
	 * 즉, 상자는 최소 0, 최대 100 높이로 쌓을 수 있다.
	 * 
8
4 2 0 0 6 0 7 0
->7
9
7 4 2 0 0 6 0 7 0
*/	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] box = new int[N];
		int[] fall = new int[N];
		int max = 0;
		for (int i=0; i<N; i++) {
			box[i] = sc.nextInt();
		}
		
		int c = 0;
		for (int i=0; i<N;i++) {
			for (int j = i+1;j<N;j++) {
				c = box[i]<=box[j]?c+1:c;
			}
			fall[i] = N-1-i-c;
		}
		
		for (int f: fall) {
			max = max<f?f:max;
		}
		
		System.out.println(max);
		
		
	}

}
