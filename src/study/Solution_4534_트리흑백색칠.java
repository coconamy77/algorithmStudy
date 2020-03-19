package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Tree{
	int name;
	List<Integer> children;	
	public Tree(int name) {
		children = new ArrayList<Integer>();	
	}
}

public class Solution_4534_트리흑백색칠 {
	
	static Tree[] tree;
	static int N,T;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t<=T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			
			tree = new Tree[N+1];
			int x, y;
			for (int n = 1; n<N;n++) {
				st = new StringTokenizer(br.readLine());
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				if (tree[x]==null) {
					tree[x] = new Tree(x);
				}
				tree[x].children.add(y);
			}
		}
		
		
		
		
	}
}
