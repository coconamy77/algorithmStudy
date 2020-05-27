package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Node implements Comparable<Node> {
	int x;
	int y;
	int name;

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
	static int smallest = 0, postIdx = 0;

	public int findPre(Node node, int limL, int limR, int i, int idx, int[][] ans, List<Node> list) {
		ans[0][idx++] = node.name;

		if (node.x == smallest) {
			ans[1][postIdx++] = node.name;
			return idx;
		}

		Node tmp;
		int child = 0;
		for (int j = i; j < list.size(); j++) {
			tmp = list.get(j);
			if (tmp.x < child) {
				break;
			}
			if (node.x != tmp.x) {
				child = tmp.x;
				if (tmp.y < node.y && tmp.y > limL) {
					idx = findPre(list.remove(j), limL, node.y, j--, idx, ans, list);
				} else if (tmp.y > node.y && tmp.y < limR) {
					idx = findPre(list.remove(j), node.y, limR, j--, idx, ans, list);
					break;
				}
			}
		}
		ans[1][postIdx++] = node.name;
		return idx;

	}

	public int[][] solution(int[][] nodeinfo) {
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
		//System.out.println(smallest);
		int[][] answer = new int[2][i];

		findPre(list.remove(0), -1, 100001, 0, 0, answer, list);
//		System.out.println(Arrays.toString(answer[0]));
//		System.out.println(Arrays.toString(answer[1]));
		return answer;
	}

	public static void main(String[] args) {
		Solution_길찾기게임 s = new Solution_길찾기게임();
		s.solution(new int[][] { { 5, 3 }, { 11, 5 }, { 13, 3 }, { 3, 5 }, { 6, 1 }, { 1, 3 }, { 8, 6 }, { 7, 2 },
				{ 2, 2 } });
		// s.solution(new int[][] { { 5, 3 } });
	}
}
