package study;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D3_3307_LIS {
	
	/*static int getNext(int[] a, int idx, int count) {
		int max = count;
		int c = 0;
		if (idx > a.length - 1) {
			return max;
		}
		for (int i = idx; i < a.length - 1; i++) {
			if (a[i] < a[i + 1]) {
				c = getNext(a, i + 1, count) + 1;
				max = max < c ? c : max;
			}
		}

		return max;
	}

	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());

			int[] nums = new int[K];
			int max = 0, c = 0;
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < K; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < K; i++) {
				if (max > K - i) {
					break;
				}
				c = 0;
				c = getNext(nums, i, c) + 1;
				max = max > c ? max : c;
			}

			System.out.println("#" + t + " " + max);

		}
	}*/
	
	static int idx;
	
	static void bs(int[] a, int num) {
		/*int start = 0;
		int end = idx;
		int middle = (start+end)/2;
		while(start<end) {
			if(a[middle]==num) {
				return;
			}
			else if (a[middle]>num) {
				end = middle -1;
				
			}
			else start = middle +1;
			middle = (start+end)/2;
		}
		a[middle] = num;*/
		for (int i = 0; i<=idx; i++) {
			
			if (a[i]>=num) {
				a[i]=num;
				return;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/input_d3_3307_LIS.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			int K = Integer.parseInt(st.nextToken());
			idx = 0;
			int[] nums = new int[K];
			int[] ans = new int[K];
			st = new StringTokenizer(br.readLine());
			nums[0] = Integer.parseInt(st.nextToken());
			ans[0] = nums[0];
			for (int i = 1; i < K; i++) {
				nums[i] = Integer.parseInt(st.nextToken());
				if (ans[idx]<nums[i]) {
					idx++;
					ans[idx] = nums[i];
				}else {
					bs(ans, nums[i]);
				}
			}
			
			System.out.println("#"+ t+" "+(idx+1));
			
			
			
		}
	}
}
