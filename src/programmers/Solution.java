package programmers;

import java.util.Arrays;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	int first = 0;
    	int last = 0;
    	int now = truck_weights[0];
    	int[] left = new int[truck_weights.length];
    	left[0] = bridge_length;
    	boolean justleft = false;
        int answer = 0;
        int newt = 1;
        for (int i = 1; i<truck_weights.length; i++) {
        	System.out.println("현재 : "+i+", 처음 : "+first+", 마지막 : "+last+", answer: "+answer);
        	System.out.println(Arrays.toString(left));
        	if (now+truck_weights[i]<=weight && last-first+1<bridge_length) {
        		System.out.println(i+"들어옴");
        		if (!justleft) {        			
        			newt++;
        		}else {
        			justleft = false;
        		}
        		now += truck_weights[i];
        		last = i;
        		left[i] = bridge_length;
        	}else {
        		System.out.println(first+"나감");
        		justleft = true;
        		answer += left[first];
        		now -= truck_weights[first];
        		for (int j = first+1; j<=last;j++) {
        			left[j] -= newt-1;
        		}
        		first++;
        		
        		i--;
        		newt = 1;
        	}
        }
        
        answer += left[last]+newt;
        
        return answer;
    }
}
