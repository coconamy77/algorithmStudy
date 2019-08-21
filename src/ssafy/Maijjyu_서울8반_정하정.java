package ssafy;

import java.util.LinkedList;
import java.util.Queue;

public class Maijjyu_서울8반_정하정 {

	public static void main(String[] args) {
		Queue<Integer> q = new LinkedList<>();
		int mychu = 100;// 마이쮸 개수
		int i = 1;// 사람 번호
		while (mychu > 0) { //마이쮸가 0보다 작아질때까지 반복
			int p = i++ * 100 + 1; // 처음 들어오는 사람은 1개의 마이쭈를 받음
			q.add(p);//i번째 사람이 줄을 선다
			int tmp = q.poll();
			System.out.println("사람 = " +tmp);
			mychu -= tmp++%100;//맨 앞에 서있던 사람이 받는 갯수를 받아와서 마이쭈에서 제공
			System.out.println("마이쮸개수 = "+mychu);
			if (mychu <= 0)//마이쭈가 0이 되었다면 답 출력
				System.out.println(tmp / 100 + "번 사람이 마이쮸를 먹어버림");
			q.add(tmp);//마이쭈 받았던 사람 다시 줄 서기
		}
	}
}

/*class Person {
	int num;
	int name;

	Person(int name) {
		this.name = name;
		num = 1;
	}
}*/
/*Queue<Person> q = new LinkedList<>();
	int mychu = 20;
	int i = 1;
	int ans = 0;
	while (mychu > 0) {

		q.add(new Person(i++));

		Person p = q.poll();
		mychu -= p.num++;
		if (mychu<=0) ans = p.name;
		q.add(p);
	}
	System.out.println(ans);
 */
/*Queue<int[]>q = new LinkedList<>();
		int mychu = 20;//마이쮸 개수
		int i = 1;//사람 번호
		while (mychu > 0) {
			int[] p = {i++,1};
			q.add(p);
			int[] tmp = q.poll();
			mychu -= tmp[1]++;
			if (mychu<=0) System.out.println(tmp[0]+"번 사람이 마이쮸를 먹어버림");
			q.add(tmp);
		}*/