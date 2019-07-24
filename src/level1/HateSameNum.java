package level1;

import java.util.ArrayList;
import java.util.List;

public class HateSameNum {
	
	/*�迭 arr�� �־����ϴ�. �迭 arr�� �� ���Ҵ� ���� 0���� 9������ �̷���� �ֽ��ϴ�. �̶�, �迭 arr���� ���������� ��Ÿ���� ���ڴ� �ϳ��� ����� ���� �����Ϸ��� �մϴ�. 
	 * �迭 arr���� ���� �ǰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���. ��, ���ŵ� �� ���� ������ ��ȯ�� ���� �迭 arr�� ���ҵ��� ������ �����ؾ� �մϴ�.
	�������

	arr = [1, 1, 3, 3, 0, 1, 1] �̸� [1, 3, 0, 1] �� return �մϴ�.
	arr = [4, 4, 4, 3, 3] �̸� [4, 3] �� return �մϴ�.
	�迭 arr���� ���������� ��Ÿ���� ���ڴ� �����ϰ� ���� ������ return �ϴ� solution �Լ��� �ϼ��� �ּ���.
	*/
	public int[] solution(int []arr) {
		
		List<Integer> answerList = new ArrayList<Integer>();
        int index=0;
        answerList.add(index,arr[0]);
        
        
        for (int i=1; i<arr.length;i++) {
        	if (answerList.get(index)!=arr[i]) {
        		answerList.add(++index,arr[i]);
        	}
        }
        
        int[] answer = new int[answerList.size()];
        for (int i=0; i<answerList.size();i++) {
        	answer[i]=answerList.get(i);
        }
        

        return answer;
	}
	
	public static void main(String[] args) {
		HateSameNum hsn = new HateSameNum();
		int[] arr= {1,1,3,3,0,1,1};
		int[] answer = hsn.solution(arr);
		
		for (int i : answer) {
			System.out.println(i);
		}
		

	}

}
