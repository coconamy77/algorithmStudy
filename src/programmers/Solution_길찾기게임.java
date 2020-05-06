package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
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
		if (this.x < o.x) {
			return 1;
		} else if (this.x > o.x) {
			return -1;
		} else {
			if (this.y > o.y) {
				return 1;
			} else {
				return -1;
			}
		}
	}

}

public class Solution_길찾기게임 {

	static int smallest = 0;

	public int findPre(Node node,int i, int idx, int[] pre, List<Node> list) {
		//Node node = list.remove(parent);
		pre[idx++] = node.name;
		System.out.println(Arrays.toString(pre));
		
		if (node.x==smallest) {
			list.add(node);
			
			return idx;
		}
		
		Node tmp;
		int child = 0;
		if (node.x > smallest) {
			for (int j = i; j < list.size(); j++) {
				tmp = list.get(j);
				if (tmp.x<child) {
					break;
				}
				if (node.x != tmp.x) {
					child = tmp.x;
					if (tmp.y<node.y) {
						node.num = 1;
						idx = findPre(list.remove(j),j--,idx,pre, list);
					}else {
						node.num++;
						idx = findPre(list.remove(j),j--,idx,pre, list);
						break;
					}
				}

			}
		}
		list.add(node);
		return idx;

	}

	public int[][] solution(int[][] nodeinfo) {
		int[][] answer = {};
		int x, y;

		List<Node> list = new ArrayList<Node>();
		int i = 0;
		for (; i < nodeinfo.length; i++) {
			x = nodeinfo[i][1];
			y = nodeinfo[i][0];

			list.add(new Node(x, y, i + 1));
		}

		Collections.sort(list);
		smallest = list.get(i - 1).x;

		int[] pre = new int[i];

		findPre(list.remove(0),0, 0, pre, list);
		
		System.out.println(Arrays.toString(pre));

		return answer;
	}

	public static void main(String[] args) {
		Solution_길찾기게임 s = new Solution_길찾기게임();
		s.solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } });
	}
}
