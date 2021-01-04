import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main4 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		
		Stack<String> s = new Stack<>();
		Stack<String> s2 = new Stack<>();
		
		String bank = "";
		while(st.hasMoreTokens()) {
			bank = st.nextToken();
			
			if (s.contains(bank)) {
				s.remove(bank);
			}
			s.add(bank);
			
			while(true) {
				System.out.print(s.peek());
				s2.add(s.pop());
				if (s.empty() || s2.size()==5) {
					break;
				}
				System.out.print(" ");
			}
			s.clear();
			System.out.println();
			while(!s2.empty()) {
				s.add(s2.pop());
			}
			
		}
		
	}

}
