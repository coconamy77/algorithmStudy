import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main6 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		String[] kim = input.split(" ");

		input = br.readLine();
		String[] lee = input.split(" ");

		int ans = 0;
		int sum = 0;
		for (int i = 0; i < kim.length; i++) {
			ans = Integer.parseInt(kim[i])-Integer.parseInt(lee[i])+sum;
			if (ans<0) {
				sum = ans;
				ans = 0;
			}else {
				sum = 0;
			}
			System.out.print(ans+" ");
		}
	}
}