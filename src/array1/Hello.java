package array1;

public class Hello {
	
	public static void main(String[] args) {
		int i = 3;
		if(i%2 ==0) {
			System.out.println("짝수");
			
		}else {
			System.out.println("홀수");
		}
		System.out.println(i%2 ==0?"짝수":"홀수");
	}

}
