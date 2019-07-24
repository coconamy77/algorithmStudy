package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class GetArea {
	
	static int dx[] = { 0, 0, 1, -1 };
	static int dy[] = { 1, -1, 0, 0 };
	/*
	ù° �ٿ� M�� N, �׸��� K�� ��ĭ�� ���̿� �ΰ� ���ʷ� �־�����. M, N, K�� ��� 100 ������ �ڿ����̴�. 
	��° �ٺ��� K���� �ٿ��� �� �ٿ� �ϳ��� ���簢���� ���� �Ʒ� �������� x, y��ǥ���� ������ �� �������� x, y��ǥ���� ��ĭ�� ���̿� �ΰ� ���ʷ� �־�����. 
	�������� ���� �Ʒ� �������� ��ǥ�� (0,0)�̰�, ������ �� �������� ��ǥ��(N,M)�̴�. �ԷµǴ� K���� ���簢������ ������ ��ü�� ä��� ���� ����.*/

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
       
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[][] area = new int[M][N];
        
        for (int i=0; i<K; i++) {
        	st = new StringTokenizer(br.readLine());
        	
        	int x1 = Integer.parseInt(st.nextToken());
        	int y1 = Integer.parseInt(st.nextToken());
        	
        	int x2 = Integer.parseInt(st.nextToken())-1;
        	int y2 = Integer.parseInt(st.nextToken())-1;
        	
        	for (int x = x1; x<=x2;x++) {
        		for (int y = y1; y<=y2; y++) {
        			area[y][x]++;
        		}
        		
        	}
        	
        }
        
        ArrayList<Integer> num = new ArrayList<Integer>();
        boolean[][] vst = new boolean[M][N];
        
        for (int i=0; i<area.length; i++) {
			for (int j = 0; j<area[0].length; j++) {
				if (area[i][j]==0 && !vst[i][j]) {
					num.add(count(area,vst,i,j));
					
				}
			}
		}
        
        Collections.sort(num);
        
        System.out.println(num.size());
        for (int a : num) {
        	
        	System.out.print(a + " ");
        }
	}

	static int count(int[][] area, boolean[][] vst, int x, int y) {
		int c=0;
		if (vst[x][y]) {
			return 0;
		}
		else {
			vst[x][y]=true;
			c++;
			for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                //���� ��
                if (0 <= nx && nx < area.length && 0 <= ny && ny < area[0].length)
                {
                	if (area[nx][ny]==0) {
                		c=c+count(area,vst,nx,ny);
                	}
                	
                    
                }
            }
		}
		
		return c;
	}
	
	
	

}
