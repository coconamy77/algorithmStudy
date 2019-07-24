package level1;

public class StringArray {

	/*
	 * 문자열 s의 길이가 4혹은 6이고, 숫자로만 구성되있는지 확인해주는 함수, solution을 완성하세요. 예를들어 s가 a234이면
	 * False를 리턴하고 1234라면 True를 리턴하면 됩니다.
	 * 
	 * 제한 사항 s는 길이 1 이상, 길이 8 이하인 문자열입니다.
	 */

	public boolean solution(String s) {
		boolean answer = true;

		if (!(s.length() == 4 || s.length() == 6)) {
			answer = false;
		} else {
			try {
				Integer.parseInt(s);
			} catch (NumberFormatException e) {
				answer = false;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		StringArray sa = new StringArray();
		System.out.println(sa.solution("123333"));
		

	}

}
