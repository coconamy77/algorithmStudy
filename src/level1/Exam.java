package level1;

import java.util.*;

public class Exam {
	
	/*수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 
	 * 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

	1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
	2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
	3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

	1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 
	가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.
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
