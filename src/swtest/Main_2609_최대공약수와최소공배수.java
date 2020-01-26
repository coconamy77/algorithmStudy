package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2609_최대공약수와최소공배수 {
	
	static int getGcd(int a, int b) {
		int r = a%b;
		while (r>0) {
			a = b;
			b = r;
			r = a%b;
		}
		return b;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int gcd = 0;
		
		if (a>b) {
			gcd = getGcd(a,b);
			
		}else {
			gcd = getGcd(b,a);
		}
		
		System.out.println(gcd);
		System.out.println(a*b/gcd);
		
	}
}
