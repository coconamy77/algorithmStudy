package array1;

import java.util.Scanner;

public class Solution_D3_1289_원재의메모리복구하기_서울8반_정하정
{
	
	/*
	원재가 컴퓨터를 만지다가 실수를 저지르고 말았다. 메모리가 초기화된 것이다.

	다행히 원래 메모리가 무슨 값이었는지 알고 있었던 원재는 바로 원래 값으로 되돌리려고 했으나 메모리 값을 바꿀 때 또 문제가 생겼다.

	메모리 bit중 하나를 골라 0인지 1인지 결정하면 해당 값이 메모리의 끝까지 덮어씌우는 것이다.

	예를 들어 지금 메모리 값이 0100이고, 3번째 bit를 골라 1로 설정하면 0111이 된다.

	원래 상태가 주어질 때 초기화 상태 (모든 bit가 0) 에서 원래 상태로 돌아가는데 최소 몇 번이나 고쳐야 하는지 계산해보자.
	
	
	2
	0011    1
	100     2
	
	
	10
10001
110011
010
00100
100010
1101
1100
011
0101
000111
	*/
	
	
	
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		
		char[][] c = new char[n][];
		for (int i=0; i<n;i++) {
			String as= sc.nextLine();
			c[i] = as.toCharArray();
			
		}
		
		char check;
		int num;
		for (int j = 0; j< c.length;j++) {
			num = 0;
			check='0';
			for (int i=0;i<c[j].length;i++) {
				if (check!=c[j][i]) {
					num++;
					check=c[j][i];
				}
			}
			System.out.println("#"+(j+1)+" "+(num));
			
		}
		
	}
}