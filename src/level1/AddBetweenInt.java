package level1;

public class AddBetweenInt {
	
	/*�� ���� a, b�� �־����� �� a�� b ���̿� ���� ��� ������ ���� �����ϴ� �Լ�, solution�� �ϼ��ϼ���. 
	���� ��� a = 3, b = 5�� ���, 3 + 4 + 5 = 12�̹Ƿ� 12�� �����մϴ�.

	���� ����
	a�� b�� ���� ���� �� �� �ƹ� ���� �����ϼ���.
	a�� b�� -10,000,000 �̻� 10,000,000 ������ �����Դϴ�.
	a�� b�� ��Ұ���� ���������� �ʽ��ϴ�.*/

	public long solution(int a, int b) {
	      long answer = 0;
	      int i=a,j=b;
	      if (a>b) {
	    	  i=b;
	    	  j=a;
	      }
	      for (int index=i;index<=j;index++) {
	    	  answer +=index;
	      }
	      
	      
	      new Thread(()->{

	    	    System.out.println("���� ǥ������ ����� ��ȸ�� ������ ����");

	    	}).start();
	      
	      
	      return answer;
	  }
	
	
	/*
	public long solution(int a, int b) {
        return sumAtoB(Math.min(a, b), Math.max(b, a));
    }

    private long sumAtoB(long a, long b) {
        return (b - a + 1) * (a + b) / 2;
    }*/
	
	public static void main(String[] args) {
		AddBetweenInt abi = new AddBetweenInt();
		System.out.println(abi.solution(4823, 5884));

	}

}
