package programmers;

import java.util.*;

public class Solution_디스크컨트롤러 {
	
	public int solution(int[][] jobs) {
        
	    int size = jobs.length;
		List<int[]> list = new ArrayList<>();		
        for (int[] a: jobs) {
        	list.add(a);
        }
		
        Collections.sort(list, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return Integer.compare(o1[1], o2[1]);
			}
		});
		
		int time =0;
		int idx = 0;
		int sum = 0;
		
		while(list.size()>0){
			if (list.get(idx)[0]<=time){
				int[] tmp = list.remove(idx);
				time += tmp[1];
				sum += time-tmp[0];
				idx = 0;		
			}else{
				if (idx==list.size()-1){
					time++;
					idx = 0;
				}else{
					idx++;
				}
			}		
		}
        
        
       
        
        return sum/size;
    }
}

