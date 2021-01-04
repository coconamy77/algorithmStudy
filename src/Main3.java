import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class Main3 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		Set<Integer> lotto = new HashSet<>();
		int before = Integer.parseInt(st.nextToken());
		lotto.add(before);
		int now = 0;
		for (int i =1; i<6; i++) {
			if (!st.hasMoreTokens()) {
				System.out.println("false");
				return;
			}
			now = Integer.parseInt(st.nextToken());
			if (now>=46 || now<=0) {
				System.out.println("false");
				return;
			}
			if (before>=now) {
				System.out.println("false");
				return;
			}
			if (lotto.contains(now)) {
				System.out.println("false");
				return;
			}
			lotto.add(now);
			before = now;
		}
		System.out.println("true");
	}

}
