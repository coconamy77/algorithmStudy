package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node{
	int i;
	Node next;
	public Node(int i, Node next) {
		this.i = i;
		this.next = next;
	}
	public Node(int i ) {
		this.i = i;
	}
}

public class Main_1701_이분그래프 {
	static int V, E;
	static Node[] graph;
	static boolean fin;

	static boolean getAns(int dep, int[] sel) {
		if (fin) {
			return fin;
		}
		if (dep == V + 1) {
			for (int i = 1; i <= V; i++) {
				if (graph[i]!=null && !check(i, sel, sel[i])) {
					return false;
				}
			}
			fin = true;
			return fin;
		}

		sel[dep] = 1;
		getAns(dep + 1, sel);

		if (fin)
			return fin;
		sel[dep] = 0;
		getAns(dep + 1, sel);

		return fin;
	}

	static boolean check(int i, int[] sel, int val) {
		Node tNode = graph[i].next;
		while(tNode!=null) {
			if (sel[tNode.i]==val) {
				return false;
			}
			
			tNode = tNode.next;
		}
		return true;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int x, y;

		for (int t = 1; t <= T; t++) {
			fin = false;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new Node[V+1];

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				if (graph[x]==null) {
					
					graph[x] = new Node(x,new Node(y));
				}else {
					Node tNode = graph[x];
					while(tNode.next!=null) {
						tNode = tNode.next;
					}
					tNode.next = new Node(y);
				}

			}
			
			int[] sel = new int[V+1];
			
			if (getAns(1, sel)) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}

	}
}
