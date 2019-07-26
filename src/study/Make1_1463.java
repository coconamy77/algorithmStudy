package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Make1_1463 {
	static int[] count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		count = new int[N+1];
		
		for (int i = 2; i<N+1;i++) {
			int tmp = N,min = N;
			
			if (i%3==0) {
				min = count[i/3]+1;
				
			}
			if (i%2 == 0) {
				tmp = count[i/2]+1;
				min = tmp>=min?min:tmp;
			}
			tmp = count[i-1]+1;
			count[i] = tmp>=min?min:tmp;
		}
		
		System.out.println(count[N]);
		
		
	}

}



/*public class Main {
	private boolean[] isVisit = new boolean[1000001];
	private LinkedList<Node> queue = new LinkedList<>();
	
	private class Node {
		public int n;
		public int cnt;
		
		public Node(int n, int cnt) {
			this.n = n;
			this.cnt = cnt;
		}
	}
	
	private void enqueue(int n, int cnt) {
		if (n > 0 && !isVisit[n]) {
			isVisit[n] = true;
			queue.add(new Node(n, cnt));
		}
	}
	
	public int bfs(int startNode) {
		int result = -1;
		
		enqueue(startNode, 0);
		
		while (!queue.isEmpty()) {
			Node node = queue.removeFirst();
			int n = node.n;
			int cnt = node.cnt;
			
			if (n == 1) {
				result = cnt;
				break;
			}
			
			if (n % 3 == 0) {
				enqueue(n / 3, cnt + 1);
			}
			
			if (n % 2 == 0) {
				enqueue(n / 2, cnt + 1);
			}
			
			if (n > 1) {
				enqueue(n - 1, cnt + 1);
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Main m = new Main();
		int startNode = Integer.parseInt(br.readLine());
		
		System.out.println(m.bfs(startNode));
		
		br.close();
    }
}
*/