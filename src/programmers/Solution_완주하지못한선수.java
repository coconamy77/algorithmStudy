package programmers;

import java.util.HashMap;
import java.util.Map;

class Solution_완주하지못한선수 {
   public String solution(String[] participant, String[] completion) {
	   String answer = "";
       Map<String, Integer> map = new HashMap<>();
       for(String name: completion){
           if(map.containsKey(name)){
               map.replace(name,map.get(name)+1);
           }else{
               map.put(name, 1);
           }
       }
       
       for(String name: participant){
           if(!map.containsKey(name)){
               return name;
           }
           int c = map.get(name);
           if(c==1){
               map.remove(name);
           }else{
                map.replace(name,c-1);
           }
       }
       return answer;
   }
   
   public String solution2(String[] participant, String[] completion) {
       String answer = "";
       Map<String, Integer> map = new HashMap<>();
       
       for(String p: participant){
           map.put(p, map.getOrDefault(p, 0)+1);
       }
       
       for(String c: completion){
           int tmp = map.get(c);
           
           if(tmp==1){
               map.remove(c);
           }else{
               map.replace(c, tmp-1);
           }
       }
       
       answer = (String)map.keySet().toArray()[0];
       
       return answer;
   }
   
}
