package test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
//    public int[] solution(int[][] v) {
//        int[] answer = new int[2];
//        int[] tmp = new int[2];
//        tmp[0] = v[0][0];
//        tmp[1] = v[0][1];
//        for (int i =1; i<3; i++) {
//        	for (int j = 0; j<2; j++) {
//        		if (answer[j]==0) {
//        			answer[j] = v[i][j];
//        		}else {
//        			if (answer[j]==v[i][j]) {
//        				answer[j] = tmp[j];
//        			}else if(tmp[j]!=v[i][j]){
//        				answer[j] = v[i][j];
//        			}
//        		}
//        	}
//        }
//
//        return answer;
//    }
//    
//    public static void main(String[] args) {
//		Solution s= new Solution();
//		System.out.println(Arrays.toString(s.solution(new int[][] {{1,4},{3,4},{3,10}})));
//		System.out.println(Arrays.toString(s.solution(new int[][] {{1,1},{2,2},{1,2}})));
//	}
//	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i<m;i++) {
			for (int j = 0; j<n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
}
