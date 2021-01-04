import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main2 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int i = 0;
		for (; i<input.length()-1; i++) {
			if (input.charAt(i)=='1') {
				if (input.charAt(i+1)=='1') {
					System.out.println("false");
					return;
				}
			}
		}
		if(input.charAt(i)=='1')
			System.out.println("false");
		else{
			System.out.println("true");
		}
	}

}
