package level1;

import java.util.*;

public class Exam {
	
	/*�����ڴ� ������ ������ ����� �ظ��Դϴ�. ������ ���ι��� ���ǰ�翡 ���� ������ ���� ������ �մϴ�. 
	 * �����ڴ� 1�� �������� ������ �������� ������ ���� ����ϴ�.

	1�� �����ڰ� ��� ���: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2�� �����ڰ� ��� ���: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3�� �����ڰ� ��� ���: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

	1�� �������� ������ ���������� ������ ������� ���� �迭 answers�� �־����� ��, 
	���� ���� ������ ���� ����� �������� �迭�� ��� return �ϵ��� solution �Լ��� �ۼ����ּ���.
*/
	
	public int[] solution(int[] answers) {
		List<Integer> answerList = new ArrayList<Integer>();
        int[][] magi = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] count = {0,0,0};
        int max=0;
        for (int j=0; j<3; j++) {
        	for(int i=0; i<answers.length;i++) {
        		if (answers[i]==magi[j][i%magi[j].length]) {
        			count[j]++;
        		}
        	}
        	if (max<count[j]) {
        		max=count[j];
        	}
        }
        
        for (int i=0; i<3;i++) {
        	if (count[i]==max) {
        		answerList.add(i+1);
        	}
        }


        
        return answerList.stream().mapToInt(i->i.intValue()).toArray();
    }
	
	public static void main(String[] args) {
		Exam ex = new Exam();
		int[] answers = {1, 3, 2, 4, 2};
		int[] hiest = ex.solution(answers);
		
		for (int i : hiest) {
			System.out.println(i);
		}
	}
}
