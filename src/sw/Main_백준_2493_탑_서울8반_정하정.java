package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_백준_2493_탑_서울8반_정하정 {

	
	public static void main(String[] args) throws Exception{
		Stack<int[]> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		int[] a = new int[num];
		String[] ints = br.readLine().split(" ");
		int n = Integer.parseInt(ints[num-1]);
		stack.push(new int[] {n,num});
		
		for (int i =num-1; i>0; i--) {
			n = Integer.parseInt(ints[i-1]);
			
			while(!stack.isEmpty() && stack.peek()[0]<=n) {
				
				a[stack.pop()[1]-1] = i; 
			}
			stack.push(new int[] {n,i});
		}
		
		for (int ai: a) {
			System.out.print(ai+" ");
		}
		
	}
}
