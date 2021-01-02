package programmers;

import java.util.StringTokenizer;

public class Solution_추석트래픽 {
	public int solution(String[] lines) {
        int answer = 0;
        StringTokenizer st;
        String[] time;
        
        for (int i = 0; i<lines.length; i++) {
        	st = new StringTokenizer(lines[i]);
        	
        	st.nextToken();
        	
        	time = st.nextToken().split(":");
        	System.out.println(time);
        }
        
        return answer;
    }
}