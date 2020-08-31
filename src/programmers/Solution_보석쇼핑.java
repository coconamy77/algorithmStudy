package programmers;

import java.util.ArrayList;
import java.util.List;

class Solution_보석쇼핑 {
	public int[] solution(String[] gems) {
       // int[] answer = new int[2];
        
        List<String> list = new ArrayList<>();
        list.add(gems[0]);
        int last = 0,first = 0;
        for (int i = 1; i<gems.length; i++) {
        	if(!list.contains(gems[i])) {
        		while(last<i) {
        			list.add(gems[++last]);
        		}
        	}
        }
        
        //String tmp = list.remove(0);
        while(list.contains(list.remove(0))) {
        	first++;
        	
        	//tmp = list.remove(0);
        }
        
        
        return new int[]{first+1,last+1};
    }
}
