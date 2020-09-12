package programmers;

import java.util.Arrays;

public class Solution_삼각달팽이 {
	public int[] solution(int n) {

		int max = (n * (n + 1)) / 2;

		int[] answer = new int[max];

//        1, n, 
//        
//        1,2,3,4,5,6,7,8,9,10
//        
//        	1	3	5	6	7
//        1->1    	 
//        2->3	3	
//        3->6	6	3	5
//        4->10	9	10	8
//        5->15	12	13	11
//        6->21	15	16	14
//        7->28	18	19	17
//        
//              01
//             02 18
//            03 19 17
//           04 20 27 16
//          05 21 28 26 15
//         06 22 23 24 25 14
//        07 08 09 10 11 12 13
//        
//        [1,2,18,3,19,17,4,20,27,16,5,21,28,26,15,6,22,23,24,25,14,7,8,9,10,11,12,13]
//        
		int idx = 0,num = 1, j = 0;
		while (num <= n) {
			
			for (int i = 0; i < n-j; i++) {
//				for (int j = 0; j < i+1; j++) {
//					idx++;
//				}
				idx+=i;
				answer[idx] = num++;

			}
			
			for (int i = 1; i<n-j-1; i++) {
				answer[++idx] = num++;
			}
			
			for (int i = n-j; i>0+j+1;i--) {
				idx-=i;
				answer[idx] = num++;
				System.out.println(idx+" "+num);
			}
			
			
			j++;
		}
		
			System.out.println(Arrays.toString(answer));
		return answer;
	}
	
	public static void main(String[] args) {
		Solution_삼각달팽이 s = new Solution_삼각달팽이();
		s.solution(7);
	}
}