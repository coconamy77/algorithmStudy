package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car implements Comparable<Car> {
	int in;
	int out;
	boolean checked;

	public Car(int in, int out) {
		this.in = in;
		this.out = out;
		this.checked = false;
	}

	@Override
	public int compareTo(Car o) {
		if (this.out < o.out) {
			return -1;
		} else if (this.out == o.out) {
			if (this.in <= o.in) {
				return -1;
			} else {
				return 1;
			}
		}
		return 1;
	}
}

public class Solution_단속카메라 {
	public int solution(int[][] routes) {
		int answer = 0;
		List<Car> list = new ArrayList<>();
		Car car;

		for (int[] c : routes) {
			int in = c[0];
			int out = c[1];
			car = new Car(in, out);

			list.add(car);
		}

		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			Car c = list.get(i);
			if (!c.checked) {
				int out = c.out;
				c.checked = true;
				answer++;
				for (int j = 0; j < list.size(); j++) {
					if (i == j) {
						continue;
					}
					c = list.get(j);
					if (!c.checked && c.in <= out) {
						c.checked = true;
					}
				}
			}
		}

		return answer;
	}
}
