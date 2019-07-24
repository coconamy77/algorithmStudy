package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ThreeKang {

	/*Ļ�ŷ� �� ������ �縷���� ��� �ִ�. �縷���� �������� �ϳ� �ְ�, Ļ�ŷ�� ���� �ٸ� �� ��ǥ ���� �ִ�.

	�� �� ������ ��, �ٱ����� �� Ļ�ŷ� �� �� ������ �ٸ� �� Ļ�ŷ� ������ ���� ��ǥ�� �����Ѵ�. �� ��ǥ ���� �ִ� Ļ�ŷ簡 �� ���� �̻��� ���� ����.

	Ļ�ŷ�� �ִ� �� �� ������ �� ������?*/
	
	
	
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
	/*	Scanner s = new Scanner(System.in);
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();*/
        
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        //int max = Math.Max(b-a,c-b);
        //System.out.println(max-1);
        
		if (b-a>c-b) {
			System.out.println(b-a-1);
			
		}else {
			System.out.println(c-b-1);
		}
		
	}

}
