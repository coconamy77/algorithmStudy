package algo_B;

import java.io.IOException;
import java.util.Scanner;

public class Solution_3819_최대부분배열 {
	
	// i~j까지의 합 = 1~j까지의 합- 1~(i-1)까지의 합
	//-> 배열의 합을 다 더해서 하나의 배열을 만든다 ( 누적합 배열 생성)
	//-> 가장 큰 값에서 가장 작은 값을 빼는 것이 가장 큰 값을 반환한다.
	//-> 뒤에부터....? 다 돌려...?( minimum배열 생성)
	/*static int N,max;
	static int[] a;
	
	static void getMax(int dep, int sum) {
		if (dep==N-1) {
			sum +=a[dep];
			max = sum>max? sum: max;
			return;
		}
		sum +=a[dep];
		if (sum<=0) {
			return;
		}
		max = sum>max? sum: max;
		getMax(dep+1, sum);
	}
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			a = new int[N];
			
			for (int n = 0; n<N; n++) {
				a[n] = Integer.parseInt(br.readLine());
			}
			max = a[N-1];
			for (int n=0; n<N-1; n++) {
				getMax(n+1,a[n]);
			}
			
			
			System.out.println("#"+t+" "+max);
		}
		
	}
	#include <stdio.h>
#include <algorithm>
#include <vector>
using namespace std;

int n,sum,ans=-1e9,local_min=0;
int main(){
    int i;
    scanf("%d",&n);
    for (i=1;i<=n;i++){
        int a;
        scanf("%d",&a);
        sum += a;
        ans = max(ans, sum-local_min);
        local_min = min(local_min, sum);        
    }
    printf("%d",ans);
}
	*
	*
	*
	*
	*/
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int[] A = new int[N];
			A[0] = sc.nextInt();
			int max = A[0];
			for (int i = 1; i < N; i++) {
				int num = sc.nextInt();
				A[i] = num;
				if (A[i - 1] + A[i] > A[i]) {
					A[i] = A[i - 1] + A[i];
				}
				if (max < A[i]) {
					max = A[i];
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}