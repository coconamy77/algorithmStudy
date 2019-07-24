package level1;

import java.util.ArrayList;
import java.util.List;

public class PEUniform {

	/*
	 * ������ ü�������� �ִ� ���Դϴ�. �׷��� ���ɽð��� ������ ��� ��� �л��� ü������ ������ ���߽��ϴ�. ������ �Ϻ� �л����� ������
	 * ü������ �����Խ��ϴ�. �л����� ��ȣ�� ü�� ������ �Ű��� �ֱ� ������ �ٷ� �չ�ȣ�� �л��̳� �ٷ� �޹�ȣ�� �л����Ը� ü������ �����ַ���
	 * �մϴ�.
	 * 
	 * ���� ���, 4�� �л��� 3�� �л��̳� 5�� �л����Ը� ü������ ������ �� �ֽ��ϴ�. �翬�� ü������ 2�� ������ �л��� ü������ ������
	 * ���ߴٸ�, ������ ü������ ������ �� �����ϴ�.
	 * 
	 * ü������ ������ ü�������� ���� �� ���� ������ ü������ ������ ���� �ִ��� ���� �л��� ü�������� ��� �ͽ��ϴ�.
	 * 
	 * ��ü �л��� �� n, ü������ �������� �л����� ��ȣ�� ��� �迭 lost, ������ ü������ ������ �л����� ��ȣ�� ��� �迭
	 * reserve�� �Ű������� �־��� ��, ü�������� ���� �� �ִ� �л��� �ִ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
	 */

	int[] newleft;
	
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = n - lost.length;
		
		

		answer=Math.max(lt(gt(answer,reserve,lost),newleft,lost),gt(lt(answer,reserve,lost),newleft,lost));
		
		return answer;
	}
	
	private int lt(int answer, int[] reserve, int[] lost) {
		int borrow = 0;
		List<Integer> left = new ArrayList<Integer>();
		for (int res : reserve) {
			for (int los : lost) {
				if (res - 1 == los) {
					answer++;
					borrow++;
				}

			}
			if (borrow == 0) {
				left.add(res);
			}else
			borrow=0; 
		}
		newleft = left.stream().mapToInt(i->i.intValue()).toArray();
		return answer;
		
	}

	private int gt(int answer,int[] reserve, int[] lost) {
		int borrow = 0;
		List<Integer> left = new ArrayList<Integer>();
		for (int res : reserve) {
			for (int los : lost) {
				if (res + 1 == los) {
					answer++;
					borrow++;
				}

			}
			if (borrow == 0) {
				left.add(res);
			}else
			borrow=0; 
		}
		newleft = left.stream().mapToInt(i->i.intValue()).toArray();
		return answer;
	}

	public static void main(String[] args) {
		PEUniform pe = new PEUniform();
		int[] lost = {2,4};
		int[] reserve = {1,3,5};
		System.out.println(pe.solution(5, lost, reserve));

	}

}
