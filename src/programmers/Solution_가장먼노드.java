package programmers;
import java.util.*;

class NodeF{
    int name;
    List<Integer> children;
    public NodeF(int name){
        this.name = name;
        this.children = new ArrayList<>();
    }
}

class Solution_가장먼노드 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int now = 0;
    
        NodeF[] nodes = new NodeF[n];
        for(int[] e: edge){
            int from = e[0]-1;
            int to  = e[1]-1;
            
            if(nodes[from]==null){
                nodes[from] = new NodeF(from);
            }
            if(nodes[to]==null){
                nodes[to] = new NodeF(to);
            }
            
            nodes[to].children.add(from);
            nodes[from].children.add(to);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});
        boolean[] vst = new boolean[n];
        vst[0] = true;
        
        while(!q.isEmpty()){
            int[] tmp = q.poll();
            if(now!=tmp[0]){
                now = tmp[0];
                answer = q.size()+1;
            }
            for(int child: nodes[tmp[1]].children){
                if(vst[child]){
                    continue;
                }else{
                    vst[child] = true;
                    q.add(new int[]{now+1,child});
                }
            }
        }
        
        return answer;
    }
}