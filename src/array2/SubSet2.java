package array2;

import java.util.Arrays;

public class SubSet2 {
	public static int[] data = { 1, 2, 3, 4 };
	
	
	/* i = 0~15
	 0 0000
	 1 0001
	 2 0010
	 3 0011
	 4 0100
	 5 0101
	 6 0110
	 7 0111
	 8 1000
	 9 1001
	10 1010
	11 1011
	12 1100
	13 1101
	14 1110
	15 1111

	 */
	public static void main(String[] args) {
		for (int i = 0; i < (1<<data.length)/* 10000 = 16*/; i++) {
			int sum = 0;
			for (int j = 0; j < data.length; j++) {
				System.out.println("i = "+i+", j = "+j);
				if((i&(1<<j))> 0) { 
					
					//System.out.print(data[j] + " ");
					//sum = sum+ data[j];
				}
			}
			System.out.println("sum = " + sum);
		
		}

	}

}