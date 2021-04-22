package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class TreePie{
	int name;
	int length;
	List<TreePie> children;
	
	public TreePie(int name, int length) {
//		System.out.println(name);
		this.name = name;
		this.length = length;
	}
	
	public void addChild(TreePie c) {
		if(children==null) {
			children = new ArrayList<TreePie>();
		}
		children.add(c);
	}
}

public class Main_1967_트리의지름 {
	public static int answer = 0;
	public static int getLong(TreePie tree) {
		if(tree.children==null) { 
			return tree.length;
		}
		
		int max = 0;
		int sec = 0;
		int length = 0;
		for(TreePie t: tree.children) {
			length = getLong(t);
			if (length>max) {
				sec = max;
				max = length;
			}else if(length>sec) {
				sec = length;
			}
		}
//		System.out.println(tree.name+":"+max+" "+sec);
		if(max+sec>answer) {
			answer = max+sec;
		}
		
		return tree.length+max;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		
		int p,c,l;
		
		TreePie t = new TreePie(1, 0);
		TreePie[] tree = new TreePie[n+1];
		tree[1] = t;
		for(int i = 2; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());
			l = Integer.parseInt(st.nextToken());
//			System.out.println(p+" "+c+" "+l);
			t = new TreePie(c, l);
			tree[c] = t;
			tree[p].addChild(t);
		}
		
		getLong(tree[1]);
		
		System.out.println(answer);
		
	}
}
