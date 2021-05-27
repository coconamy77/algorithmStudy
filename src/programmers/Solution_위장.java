package programmers;

import java.util.*;

class Solution_위장 {

    public int solution(String[][] clothes){
        int a = 1;
        Map<String, Integer> map = new HashMap<>();
        int all = clothes.length;
        int[] count = new int[all];
        int N = 0;

        for(String[] cl: clothes){
            if(map.containsKey(cl[1])){
                count[map.get(cl[1])]++;
            }else{
                map.put(cl[1], N);
                count[N++]++;
            }
        }
        
        for(int i= 0; i<N; i++){
            a *= count[i]+1;
            
        }
        return a-1;
    }
}