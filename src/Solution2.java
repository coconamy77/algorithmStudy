import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Solution2 {

	/*화장실
오프라인 필기 테스트의 시험 감독을 맡게 된 코니는 혹시 부정행위가 일어나지는 않을까 시험장을 구석구석 살펴보았다. 지원자들을 매의 눈으로 주시하던 코니는 놓친 부분을 발견했다. 바로 화장실이었다! 지원자들이 화장실에 같이 가서 답을 공유하지는 않을까? 걱정이 많은 코니는 한 가지 사실을 깨닫고 마음을 놓을 수 있었다. LINE의 화장실은 모든 지원자들을 서로 다른 화장실로 보낼 수 있을 만큼 넉넉하다는 것이었다.
지원자의 수와 지원자들이 화장실에 간 시간과 화장실에서 돌아온 시간의 목록이 주어졌을 때, 모든 지원자들이 서로 다른 화장실에 들어갈 수 있는 화장실의 최소 개수를 구하여라.

입력 형식
첫 번째 줄에는 지원자의 수 N이 들어온다
N은 1000 이하의 양의 정수이다
두 번째 줄부터 N+1번째 줄까지 각 지원자가 화장실에 간 시간과 화장실에서 돌아온 시간이 주어진다
화장실에 간 시간과 화장실에서 돌아온 시간은 모두 150 이하의 음이 아닌 정수이며, 화장실에서 돌아온 시간은 화장실에서 간 시간보다 항상 크다
화장실에 가지 않는 지원자는 없다
출력 형식
모든 지원자들이 서로 다른 화장실에 들어갈 수 있는 화장실 수의 최솟값을 출력한다
입출력 예제
입력

3
0 10
10 15
20 30
출력

1
입력

2
5 15
0 10
출력

2

*/
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		List<int[]> cr = new ArrayList<int[]>();
		for (int n = 0; n<N;n++) {
			st = new StringTokenizer(br.readLine());
			cr.add(new int[] {Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(cr,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if (o1[1]>o2[1]) return 1;
				else if(o1[1]==o2[1]) {
					if (o1[0]>o2[0]) return 1;
				}
				return -1;
			}
		});
		int max = 0;
		for (int i = 0; i<N; i++) {
			 int count = 1;
			for (int j = i+1;j<N; j++) {
				if (cr.get(j)[0]<cr.get(i)[1]) {
					count++;
				}
			}
			max = count>max?count:max;
		}
		
		System.out.println(max);
	}
}