package programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_오픈채팅방 {

   public String[] solution(String[] record) {
      String[] answer = {};
      Map<String, String> map = new HashMap<>();
      StringTokenizer st;
      int cnt=0;
      for (int i = 0; i < record.length; i++) {
         st = new StringTokenizer(record[i], " ");
         switch (st.nextToken()) {
         case "Leave": {
            cnt++;
         }
            break;
         case "Enter":{
            cnt++;
         }
         default:
            map.put(st.nextToken(), st.nextToken());
            break;
         }
      }
      answer = new String[cnt];
      cnt=0;
      for(int i=0; i<record.length; i++) {
         st = new StringTokenizer(record[i], " ");
         switch (st.nextToken()) {
         case "Enter": {
            answer[cnt++]=map.get(st.nextToken())+"님이 들어왔습니다.";
         }
            break;
         case "Leave":
            answer[cnt++]=map.get(st.nextToken())+"님이 나갔습니다.";
            break;
         }
      }
      
      
      return answer;
   }
}