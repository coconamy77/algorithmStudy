package HW;

import java.util.LinkedList;
import java.util.Queue;

/*class Person {
	int num;
	int name;

	Person(int name) {
		this.name = name;
		num = 1;
	}
}*/

public class MyChu_서울8반_정하정 {

	public static void main(String[] args) {

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
		Queue<int[]>q = new LinkedList<>();
		int mychu = 20;
		int i = 1;
		int ans = 0;
		while (mychu > 0) {
			int[] p = {i++,1};
			q.add(p);

			int[] tmp = q.poll();
			mychu -= tmp[1]++;
			if (mychu<=0) ans = tmp[0];
			q.add(tmp);
		}
		System.out.println(ans);
	}

}
