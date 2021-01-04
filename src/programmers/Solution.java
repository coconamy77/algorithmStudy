package programmers;

class Solution {
	 public int solution(int bridge_length, int weight, int[] truck_weights) {
	        int answer = 1;
	        int idx = 0;
	        int now = truck_weights[idx];
	        int cnt = 1;
	        int fin = (bridge_length-1)*-1;
	        while(idx<truck_weights.length) {
	        	if (fin==0) {
	        		
	        	}
	        	if (cnt==bridge_length || now+truck_weights[idx+1]>weight) {
	        		
	        	}else {
	        		
	        	}
	        	
	        	
	        	
	        	answer++;
	        }
	        
	        
	        return answer;
	    }
	
	
//    public int solution(int bridge_length, int weight, int[] truck_weights) {
//    	int first = 0;
//    	int last = 0;
//    	int now = truck_weights[0];
//    	int[] left = new int[truck_weights.length];
//    	left[0] = bridge_length+1;
//    	//boolean justleft = false;
//        int answer = 0;
//        //int newt = 1;
//        for (int i = 1; i<truck_weights.length; i++) {
//        	System.out.println("현재 : "+i+", 처음 : "+first+", 마지막 : "+last+", answer: "+answer);
//        	System.out.println(Arrays.toString(left));
//        	if (now+truck_weights[i]<=weight && last-first+1<bridge_length) {
//        		System.out.println(i+"들어옴");
//        		now += truck_weights[i];
//        		last = i;
//        		left[i] = bridge_length+1;
//        	}else {
//        		System.out.println(first+"나감");
//        		answer += left[first];
//        		now -= truck_weights[first];
//        		for (int j = first+1; j<=last;j++) {
//        			left[j] = left[j]-();
//        		}
//        		first++;
//        		i--;
//        	}
//        }
//        
//        answer += left[last];
//        
//        return answer;
//    }
}
