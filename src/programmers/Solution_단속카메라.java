package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Car implements Comparable<Car> {
	int in;
	int out;

	public Car(int in, int out) {
		this.in = in;
		this.out = out;
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
			int in = c[0] + 3000;
			int out = c[1] + 3000;
			car = new Car(in, out);
			
			list.add(car);
		}
		
		Collections.sort(list);
		
		

		return answer;
	}
}
