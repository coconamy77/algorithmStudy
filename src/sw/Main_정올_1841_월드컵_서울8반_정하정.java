package sw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_정올_1841_월드컵_서울8반_정하정 {
	static int[][] arr;
	static int result;

	static void solve(int A,int B, int count) {
		if(result==1) {
			return;
		}
		if(count >= 15) {
			result=1;
			return;
		}
		if(B==6) {
			A++;
			B = A+1;
		}
		//for(int[] ii:arr)System.out.println(Arrays.toString(ii));
		//A가 이김
		if(arr[A][0]>0 && arr[B][2]>0) {
			arr[A][0]--; arr[B][2]--;
			solve(A,B+1,count+1);
			arr[A][0]++; arr[B][2]++;
		}
		//비김
		if(arr[A][1]>0 && arr[B][1]>0) {
			arr[A][1]--; arr[B][1]--;
			solve(A,B+1,count+1);
			arr[A][1]++; arr[B][1]++;
		}
		//짐
		if(arr[A][2]>0 && arr[B][0]>0) {
			arr[A][2]--; arr[B][0]--;
			solve(A,B+1,count+1);
			arr[A][2]++; arr[B][0]++;
		}
		
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int tc = 0; tc < 4; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			arr = new int[6][3];
			result=0;
			for (int i = 0; i < 18; i++) {
				arr[i/3][i%3] = Integer.parseInt(st.nextToken());
				if(arr[i/3][i%3]>5)result=1;
			}
			if(result==1) {
				System.out.print("0 ");
				continue;
				
				
				
			}
			result=0;
			solve(0,1,0);
			
			System.out.print(result+" ");
		}
	}
}

/*
	static int[][] result;
	static int[][] num;
	
	public static boolean win(int team) {
		int win = num[team][0];
		int lose = num[team][2];
		int draw = num[team][1];
		if (team==5) {
			for (int i = 0; i<5; i++) {
				if (result[i][5]==1) {
					result[5][i] = -1;
					lose--;
				}
				else if (result[i][5] == -1) {
					result[5][i] = 1;
					win--;
				}else {
					draw--;
				}
			}
			System.out.println("->"+team+"->");
			for (int[] a: result) {
				System.out.println(Arrays.toString(a));
			}
			if (lose==0 && win==0 && draw==0)
				return true;
			else {
					System.out.println("false");
				return false;
			}
		}
		boolean[] vst = new boolean[6];
		vst[team] = true;
		
		while(true) {
			if (vst[5]) return false;
			for (int i=0; i<6; i++) {
				if (vst[i]) continue;
				if (result[i][team]==1) {
                    result[team][i] = -1;
					lose--;
				}
				else if (result[i][team] == -1) {
					result[team][i] = 1;
					win--;
				}else {
					if (win>0) {
						result[team][i] = 1;
						win--;
						vst[i] = true;
					}
					else if(lose>0) {
						result[team][i] = -1;
						lose--;
						vst[i] = true;
					}
					else draw--;
				}
				
			}
			
			if (lose!=0 || win!=0 || draw!=0) {
				return false;
			}
			if (win(team+1)) {
				return true;
			}
		}
			
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		
		for (int t = 1; t<=4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			result = new int[6][6];
			num = new int[6][3];
			
			for (int i = 0; i<6; i++) {
				for (int j = 0; j<3; j++) {
					num[i][j] = Integer.parseInt(st.nextToken());
					//System.out.println(i+":"+j+"->"+num[i][j]);
				}
			}
			
			if (win(0)) System.out.print(1+" ");
			else System.out.print(0+" ");
			

		}
		
	}*/