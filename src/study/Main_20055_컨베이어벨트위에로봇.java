package study;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
/*
 * 
3 6
10 10 10 10 10 10
 */
public class Main_20055_컨베이어벨트위에로봇 {
	public static int go(int n, int N){
		n--;
		if(n==-1){
			n = N*2-1;
		}
		return n;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[] belt = new int[N*2];
		int s = 0; 
		int e = N-1;
		
		int count = 0;
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i<N*2; i++){
			belt[i] = Integer.parseInt(st.nextToken());
			if(belt[i]==0){
				count++;
			}
		}
		
		int answer = 0; 
		while(count<K){
			System.out.println(s+" "+e);
			System.out.println(Arrays.toString(belt));
			answer++;
			//1
			s = go(s,N);
			e = go(e,N);
			//2(count는 로봇이 올라갈때, -1은 로봇이 나갈때)
			if(belt[e]<0){
				belt[e] *=-1;
				belt[e]--;
			}
			for(int i = 1; i<N;i++){
				int now = e-i;
				if(now<0){
					now = N*2+now;
				}
				if(belt[now]<0){
					int next = now+1;
					if(next==N*2){
						next = 0;
					}
					if(belt[next]>0){
						belt[now] *=-1;
						belt[now]--;
						if(belt[next]==1){
							count++;
							if(count>=K){
								System.out.println(answer);
								return;
							}
						}
						belt[next] *= -1;
						if(next==e){
							
						}
					}
				}
			}
			if(belt[s]>0){
				if(belt[s]==1){
					count++;
				}
				belt[s] *= -1;
			}
			System.out.println("answer = "+answer);
			System.out.println(Arrays.toString(belt));
		}
		
		System.out.println(answer);
	}
}
