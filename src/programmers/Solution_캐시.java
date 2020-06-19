package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_캐시 {
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        if(cacheSize==0) {
        	return cities.length*5;
        }
        
        Queue<String> queue =  new LinkedList<>();
        
        for(String city: cities) {
                city = city.toLowerCase();
        	if (queue.contains(city)) {
        		answer += 1;
        		queue.remove(city);
        	}else {
        		if(queue.size()==cacheSize) {
        			queue.poll();
        		}
        		answer += 5;
        	}
        	queue.add(city);
        }
        
        return answer;
    }
}
