package HW;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_D3_1208_Flatten_서울8반_정하정 {

	
	public static void main(String args[]) throws Exception {
		
		System.setIn(new FileInputStream("res/input_d3_1208.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		
		int D = 0,max = 0,min = 0;
		int[] a = new int[100];
		boolean check;
		for (int t=1; t<=10; t++) {
			D = sc.nextInt();
		
			for(int l = 0;l<100;l++) {
				a[l]=sc.nextInt();
			}
			
			for ( int d=0; d<D;d++) {
				Arrays.sort(a);
				a[0]++;
				a[a.length-1]--;
				
				
			}
			Arrays.sort(a);
			System.out.println("#"+t+" "+(a[a.length-1]-a[0]));
			
		
		}
	}
}
