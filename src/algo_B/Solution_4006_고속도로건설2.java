package algo_B;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Road{
	int next;
	int val;
	int id;
	
	public Road(int id, int next, int val) {
		this.id = id;
		this.next = next;
		this.val = val;
	}
}   

public class Solution_4006_고속도로건설2 {
	
	static int N;
	static int M;
	static int[] uf;
	
	static int find(int x) {
		if (uf[x]==0) {
			uf[x] = x;
		}else if (uf[x]!=x) {
			uf[x] = find(uf[x]);
		}
		return uf[x];
	}
	
	static boolean union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if (x==y) {
			return false;
		}
		if (x>y) {
			uf[x] = y;
		}else {
			uf[y]= x;
		}
		return true;
		
	}
	
	private static Road[] DoMergeSort(Road[] value)
	{
		if (value.length==1) return value;
		Road[] left = new Road[value.length/2];
		Road[] right = new Road[value.length-value.length/2];
		int i,j;
		for (i=0;i<left.length;i++) left[i] = value[i];
		for (;i<value.length;i++) right[i-left.length] = value[i];
		left = DoMergeSort(left);
		right = DoMergeSort(right);
		i=0; j=0;
		while(i<left.length && j<right.length){
			if (left[i].val > right[j].val){
				value[i+j] = right[j];
				j++;
			}
			else{
				value[i+j] = left[i];
				i++;
			}
		}
		for (;i<left.length;i++) value[i+j] = left[i];
		for (;j<right.length;j++) value[i+j] = right[j];
		return value;
	}
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
			N = Integer.parseInt(st.nextToken());
			uf = new int[N+1];
			M =  Integer.parseInt(st.nextToken());
			
			Road[] city = new Road[M];
			
			
			int s=0, e=0, v=0;
			
			for (int m = 0; m<M; m++) {
				st = new StringTokenizer(br.readLine());
				s = Integer.parseInt(st.nextToken());
				e = Integer.parseInt(st.nextToken());
				v = Integer.parseInt(st.nextToken());
				
				city[m] = new Road(s,e,v);
				
				
			}
			
			DoMergeSort(city);
		
			int ans = 0;
			
			for (int i = 0; i<M; i++) {
				s = city[i].id;
				e = city[i].next;
				v = city[i].val;
				
				if (union(s,e)) {
					ans+=v;
				}
			}
			System.out.println(ans);
	}
	
}
