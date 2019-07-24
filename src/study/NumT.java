package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NumT {
	
	/*
	�� ���� ���̰� 1cm�� ���簢�� ����� Ÿ���� �ִ�. �� Ÿ�ϵ��� ���ΰ� xcm, ���ΰ� ycm�� ���簢�� ����� ���� ��ƴ���� �ٿ���. x�� y�� �����̴�.
	�� ���簢���� �ϳ��� �밢���� �׷ȴ�. ���簢���� �پ� �ִ� x*y���� Ÿ�� �߿��� �밢���� �׷��� Ÿ�ϵ� �ְ�, �׷��� ���� Ÿ�ϵ� �ִ�. 
	x*y���� Ÿ�� �߿��� �밢���� �׷��� �ִ� Ÿ���� ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
	*/
	
	static int gcd(int x, int y) {
		if (y==0) return x;
		return gcd(y,x%y);
	}

	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int g =1;
        if (n> m) g= gcd(m,n);
        else g = gcd(m,n);
        
       
        System.out.println(n+m-g);
	}

}
