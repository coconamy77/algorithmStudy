package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_메뉴리뉴얼 {
	static List<String> list = new ArrayList();
	static int index = 0;

	public void getCourse(String order, int count, int[] intCourse, int start, int dept) {
		if (dept == count) {
			char[] course = new char[count];
			for (int i = 0; i < count; i++) {
				course[i] = order.charAt(intCourse[i]);
			}
			Arrays.sort(course);
			String strCourse = "";
			for (char c : course) {
				strCourse += c;
			}
			int contains = list.indexOf(strCourse);
			if (contains >= index) {
				System.out.println(strCourse + " " + contains + " " + order);
				list.remove(contains);
				list.add(index, strCourse);
				index++;
			} else if (contains == -1) {

				System.out.println("하나도 없을 때 " + strCourse);
				list.add(strCourse);
			}
		} else {
			for (int i = start; i < order.length(); i++) {
				intCourse[dept] = order.charAt(i);
				getCourse(order, count, intCourse, i + 1, dept + 1);
			}
		}
	}

	public String[] solution(String[] orders, int[] course) {
		for (String order : orders) {
			for (int c : course) {
				if (order.length() >= c) {
					getCourse(order, c, new int[c], 0, 0);
				}
			}
		}

		Collections.sort(list.subList(0, index), new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}

		});

		String[] answer = new String[index];
		for (int i = 0; i < index; i++) {
			answer[i] = list.get(i);
		}

		return answer;
	}
}
