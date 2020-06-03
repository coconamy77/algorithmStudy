package reference;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class NumberLength {
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long num = Long.parseLong(br.readLine());
		long tmp = num;
		int loc = 1;
		while (tmp > 1) {
			tmp /= 10;
			loc++;
		}
		
		System.out.println(loc);
	}
}