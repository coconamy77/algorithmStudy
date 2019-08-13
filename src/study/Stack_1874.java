package study;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 왜 안풀리지??
public class Stack_1874 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringWriter sw = new StringWriter();

		Stack<Integer> s = new Stack<Integer>(); // 연속된 숫자
		Queue<Integer> nums = new LinkedList<Integer>(); // 입력된 수열 저장

		for (int i = 0; i < n; i++) {
			nums.offer(Integer.parseInt(br.readLine()));
		}

		for (int i = 1; i <= n; i++) {
			s.push(i);
			sw.append("+");

			while (!s.isEmpty() && !nums.isEmpty() && s.peek().equals(nums.peek())) {
				s.pop();
				nums.poll();
				sw.append("-");
			}
		}

		if (s.isEmpty()) {
			System.out.println(sw.toString());
		} else {
			System.out.println("NO");

		}
	}
}