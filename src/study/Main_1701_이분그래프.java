package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Node {
	int i;
	Node next;
	Node last;
	
	public Node(int i, Node next) {
		this.i = i;
		this.next = next;
		this.last = next;
	}

	public Node(int i) {
		this.i = i;
		this.next = null;
	}

	public void add(int i) {
//		Node tNode = this;
//		while (tNode.next != null) {
//			tNode = tNode.next;
//		}
//		tNode.next = new Node(i);
		
		if (this.next==null) {
			this.next = new Node(i);
			this.last = this.next;
		}else {
			this.last.next = new Node(i);
			this.last = this.last.next;
			
		}
		
	}
}

public class Main_1701_이분그래프 {
	static int V, E;
	static Node[] graph;
	static int[] team;
	static boolean fin;

	static void getAns(int i, int t) {
		//System.out.println("i = " + i + " t = " + t);
		if (!fin) {
			return;
		}
		if (team[i] == t) {
			return;
		} else if (team[i] == 0) {
			team[i] = t;
			Node tNode = graph[i].next;
			while (tNode != null && fin) {
				getAns(tNode.i, ((t + 2) % 2) + 1);
				tNode = tNode.next;
			}

		} else {
			fin = false;
			return;
		}

	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		int x, y;

		for (int t = 1; t <= T; t++) {
			fin = true;
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());

			graph = new Node[V + 1];
			team = new int[V + 1];

			for (int e = 0; e < E; e++) {
				st = new StringTokenizer(br.readLine());

				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());

				if (graph[x] == null) {
					graph[x] = new Node(x, new Node(y));
				} else {
					graph[x].add(y);
				}
				if (graph[y] == null) {
					graph[y] = new Node(y, new Node(x));
				} else {
					graph[y].add(x);
				}

			}

//			for (int i = 1; i <= 3; i++) {
//				System.out.println(i);
//				Node tn = graph[i].next;
//				while (tn != null) {
//					System.out.println("->" + tn.i);
//					tn = tn.next;
//				}
//				// System.out.println("->"+tn.i);
//			}

			for (int i = 1; i <= V; i++) {
				if (graph[i] != null && team[i] == 0 && fin) {
					getAns(i, 1);
				}
			}

			if (fin) {
				System.out.println("YES");

			} else {
				System.out.println("NO");
			}

		}

	}
}
