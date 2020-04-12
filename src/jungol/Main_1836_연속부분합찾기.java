package jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1836_연속부분합찾기{

    public static void main(String args[]) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		int N = Integer.parseInt(st.nextToken());
		
		int max = 0;
		//int[] arr = new int[N];
		int tmp = 0, sum = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i<N; i++){
			
			tmp = Integer.parseInt(st.nextToken());
			if (tmp+sum<0){
				sum=0;
			}	
			else {
				sum += tmp;
				max  = sum>max?sum:max;
			}
		}
		System.out.println(max);
    }
}