package level1;

public class NumPY {
	
/*	�빮�ڿ� �ҹ��ڰ� �����ִ� ���ڿ� s�� �־����ϴ�. 
 * s�� 'p'�� ������ 'y'�� ������ ���� ������ True, 
 * �ٸ��� False�� return �ϴ� solution�� �ϼ��ϼ���. 
 * 'p', 'y' ��� �ϳ��� ���� ���� �׻� True�� �����մϴ�. 
 * ��, ������ ���� �� �빮�ڿ� �ҹ��ڴ� �������� �ʽ��ϴ�.

������� s�� pPoooyY�� true�� return�ϰ� Pyy��� false�� return�մϴ�.*/

	
	boolean solution(String s) {
        boolean answer = true;
        int cP =0, cY=0;
        for (char c: s.toCharArray()) {
        	if (c=='p' || c=='P') {
        		cP++;
        	}else if (c=='y'||c=='Y') {
        		cY++;
        	}
        }
        if (cP!=cY) answer=false;
        
       
        return answer;
        
      /* s = s.toUpperCase();
        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();*/
    }
	
	
	public static void main(String[] args) {
		NumPY num = new NumPY();
		String s = "ppyYs";
		System.out.println(num.solution(s));

	}

}
