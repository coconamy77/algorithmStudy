package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution_디스크컨트롤러 {
	static int min = 50000000;
	static int size = 0;
	static PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[0], o2[0]);
			}
		});
	public void getSel(int start, int turn, boolean[] sel, int sum) {
		if (sum/size>=min) {
			return;
		}
		if(turn == size) {
		
			return;
		}
		for (int i = start;;i++) {
		}
	}
	
	public int solution(int[][] jobs) {
        int answer = 0;
        size = jobs.length;
        
        for (int[] a: jobs) {
        	pq.add(a);
        }
        
        getSel(0, 0, new boolean[size], 0);
        
       
        
        return answer;
    }
}
