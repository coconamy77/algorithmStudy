package programmers;

import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int x;
	int y;
	int name;
	int num;
	public Node(int x, int y, int name) {
		super();
		this.x = x;
		this.y = y;
		this.name = name;
	}
	@Override
	public int compareTo(Node o) {
		if (this.x<o.x) {
			return 1;
		}else if (this.x>o.x) {
			return -1;
		}else {
			if (this.y>o.y) {
				return 1;
			}else {
				return -1;
			}
		}
	}
	
	
}

public class Solution_길찾기게임 {
	public int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};
        Node node;
        int x, y;
        
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        
        for (int i = 0; i<nodeinfo.length; i++) {
        	x = nodeinfo[i][1];
        	y = nodeinfo[i][0];
        	
        	pq.add(new Node(x, y, i+1));
        }
        System.out.println();
        while(!pq.isEmpty()) {
        	System.out.print(pq.poll().name);
        }
        return answer;
    }
	
	public static void main(String[] args) {
		Solution_길찾기게임 s = new Solution_길찾기게임();
		s.solution(new int[][] {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}});
	}
}
