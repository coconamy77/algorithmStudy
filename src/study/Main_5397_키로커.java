package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_5397_키로커 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			String s = br.readLine();

			Stack<Character> st1 = new Stack<>();
			Stack<Character> st2 = new Stack<>();

			for (char c : s.toCharArray()) {
				if (c == '<') {

					if (!st1.isEmpty()) {
						st2.add(st1.pop());
					}
				} else if (c == '>') {

					if (!st2.isEmpty()) {
						st1.add(st2.pop());
					}
				} else if (c == '-') {

					if (!st1.isEmpty()) {
						st1.pop();
					}
				} else {

					st1.add(c);
				}

			}

			while (!st2.isEmpty()) {
				st1.add(st2.pop());
			}

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < st1.size(); i++) {
				sb.append(st1.elementAt(i));
			}

			System.out.println(sb);
		}

	}

}
