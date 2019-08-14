package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ConSum_1912 {
	static int[] nums,ans;
	static int max;
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		nums = new int[n];
		ans = new int[n];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i<n; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = n-1;i>=0;i--) {
			getMax(i);
		}
		
		
		
		System.out.println(max);
	}
	
	static void getMax(int num) {
		if (num == ans.length-1) {
			ans[num] = nums[num];
			max = nums[num];
		}
		else {
			ans[num] = nums[num]>nums[num]+ans[num+1]? nums[num]:nums[num]+ans[num+1];
			max = max>ans[num]?max:ans[num];
		}
	}
}
