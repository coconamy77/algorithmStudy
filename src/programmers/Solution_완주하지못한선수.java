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
}
