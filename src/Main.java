
public class Main {
	public static void main(String[] args) {
		int number = 11;
		String answer = "";
		
		while(number>0) {
			answer+=number%2;
			number/=2;
		}
		
		System.out.println(answer);
	}
}
