// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
	
	
    public int solution(String[] A) {
    	int[] alpha = new int[26+1];
    	boolean[] ans = new boolean[A.length];
    	
    	for (int i = 0; i<A.length;i++) {
    		for (char c: A[i].toCharArray()) {
    			if (alpha[c-'a']>0) {
    				if (A[alpha[c-'a']].length()<=A[i].length()) {
    					ans[alpha[c-'a']] = false;
    					ans[i] = true;
    					alpha[c-'a'] = i+1;
    				}
    			}
    		}
    		
    		
    	}
    	
    	
    	
		return 0;
    }
}