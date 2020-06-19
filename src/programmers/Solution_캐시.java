package programmers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Cache{
	String city;
}

public class Solution_캐시 {
	public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        if(cacheSize==0) {
        	return cities.length*5;
        }
        
        Map<String, Cache> cacheMap = new HashMap<String, Cache>();
        Queue<Cache> queue =  new LinkedList<>();
        Cache cache;
        
        for(String city: cities) {
                city = city.toLowerCase();
        	if (cacheMap.containsKey(city)) {
        		answer += 1;
        		cache = cacheMap.get(city);
        		queue.remove(cache);
        		queue.add(cache);
        	}else {
        		if(cacheMap.size()<cacheSize) {
        			cache = new Cache();
        		}else {
        			cache = queue.poll();
        			cacheMap.remove(cache.city);
        		}
        		cache.city = city;
        		queue.add(cache);
        		cacheMap.put(city, cache);
        		answer += 5;
        	}
        }
        
        return answer;
    }
}
