import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;


class Main5 {
   public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringTokenizer st = new StringTokenizer(br.readLine());

      HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
      
      int n = 0;
      while(st.hasMoreTokens()) {
    	  n = Integer.parseInt(st.nextToken());
    	  if (!map.containsKey(n)) {    		  
    		  //map.put(n, Function.compute(n));
    	  }
    	  System.out.print(map.get(n)+" ");
    	  
      }
   }
}