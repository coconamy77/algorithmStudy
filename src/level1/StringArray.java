package level1;

public class StringArray {

	/*
	 * ���ڿ� s�� ���̰� 4Ȥ�� 6�̰�, ���ڷθ� �������ִ��� Ȯ�����ִ� �Լ�, solution�� �ϼ��ϼ���. ������� s�� a234�̸�
	 * False�� �����ϰ� 1234��� True�� �����ϸ� �˴ϴ�.
	 * 
	 * ���� ���� s�� ���� 1 �̻�, ���� 8 ������ ���ڿ��Դϴ�.
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
