package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
class Graph {
		class Node{
			int data;
			List<Node> linked;
			boolean visited;
			Node(int data){
				this.data = data;
				this.visited = false;
				linked = new LinkedList<Node>();
			}
			
			void setVisited() {
				visited = true;
			}
			
			boolean isVisited() {
				return visited;
			}
			
			
		}
		
		Node[] nodes;
		Graph(int size){
			this.nodes = new Node[size];
			
			for (int i=0; i<size;i++) {
				Node node = new Node(i+1);
				nodes[i] = node;
			}
		}
		void link(int id, int nLinked) {
			
			getNode(id).linked.add(getNode(nLinked));
			getNode(nLinked).linked.add(getNode(id));
		}
		
		Node getNode(int id) {
			
			return nodes[id-1];
		}
	}
*/
public class BfsDfs {
	/*
	 * StringBuilder sb = new StringBuilder(); void bfs(Node fNode) {
	 * sb.append("\n"); Queue<Node> q = new LinkedList<Node>(); q.add(fNode);
	 * fNode.setVisited(); while (!q.isEmpty()) { Node n = q.poll();
	 * sb.append(n.data).append(" ");
	 * 
	 * for (Node no : n.linked) { if(!no.visited) { q.add(no); no.setVisited(); } }
	 * }sb.append("\n"); }
	 * 
	 * void dfs(Node fNode) { sb.append(fNode.data).append(" "); fNode.setVisited();
	 * for (Node no : fNode.linked) { if (!no.isVisited()) { dfs(no); } } }
	 */

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int numNode = Integer.parseInt(st.nextToken());
		int numLink = Integer.parseInt(st.nextToken());
		int fNode = Integer.parseInt(st.nextToken());

		@SuppressWarnings("unchecked")
		ArrayList<Integer>[] a = (ArrayList<Integer>[]) new ArrayList[numNode + 1];

		for (int i = 0; i <= numNode; i++) {
			a[i] = new ArrayList<>();
		}

		boolean[] c = new boolean[numNode + 1];

		for (int i = 1; i <= numLink; i++) {
			st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());

			a[v1].add(v2);

			a[v2].add(v1);
		}

		for (int i = 1; i <= numNode; i++) {
			Collections.sort(a[i]);
		}

		dfs(a, c, fNode);
		System.out.println();
		Arrays.fill(c, false);
		bfs(a, c, fNode);

		/*
		 * 
		 * 
		 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 * StringTokenizer st = new StringTokenizer(br.readLine());
		 * 
		 * int numNode = Integer.parseInt(st.nextToken()); int numLink =
		 * Integer.parseInt(st.nextToken()); int fNode =
		 * Integer.parseInt(st.nextToken());
		 * 
		 * Graph g = new Graph(numNode);
		 * 
		 * 
		 * for (int i = 1; i<numLink; i++) { st = new StringTokenizer(br.readLine());
		 * g.link(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
		 * 
		 * }
		 * 
		 * for (int i=1; i<numNode+1;i++) { Collections.sort( g.getNode(i).linked,new
		 * Comparator<Node>() {
		 * 
		 * 
		 * @Override public int compare(Node o1, Node o2) { if (o1.data<o2.data ) {
		 * return -1;
		 * 
		 * } else if (o1.data>o2.data) { return 1; } return 0; }
		 * 
		 * }); }
		 * 
		 * BfsDfs result = new BfsDfs();
		 * 
		 * result.dfs(g.getNode(fNode)); result.bfs(g.getNode(fNode));
		 * System.out.println(result.sb);
		 * 
		 */
	}

	private static void bfs(ArrayList<Integer>[] a, boolean[] c, int v) {
		Queue<Integer> q = new LinkedList<>();

		q.add(v);
		c[v] = true;

		while (!q.isEmpty()) {
			v = q.poll();
			System.out.print(v + " ");

			for (int vv : a[v]) {

				if (!c[vv]) {
					q.add(vv);
					c[vv] = true;
				}

			}

		}

	}

	public static void dfs(ArrayList<Integer>[] a, boolean[] c, int v) {
		if (c[v]) {
			return;
		}

		c[v] = true;
		System.out.print(v + " ");

		for (int vv : a[v]) {

			if (!c[vv]) {
				dfs(a, c, vv);
			}

		}

	}

}
