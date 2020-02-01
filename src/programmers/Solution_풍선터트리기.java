package programmers;

import java.util.Stack;

public class Solution_풍선터트리기 {
	public int solution(int[] a) {

		Stack<Integer> stack = new Stack<>();

		int i = 0;
		stack.add(a[i++]);

		int before = 0, num = 0, next = 0;

		boolean max = false;

		for (; i < a.length - 1; i++) {
			num = a[i];
			next = a[i + 1];
			before = stack.peek();
//			System.out.println("현재 i: "+i);
//			System.out.println(before+" "+num+" "+next);
			if (num > next && num > before) {
				max = true;
			}
			while (max) {
				System.out.println(num+"삭제");
				if (stack.size() == 1) {
					max = false;
					num = stack.pop();
					break;
				}
				num = stack.pop();
				//System.out.println("stack 현황: "+stack.peek());
				before = stack.peek();
				//System.out.println(before+" "+num+" "+next);
				if (num < next || num < before) {
					max = false;
				}

			}
			stack.add(num);

		}
		stack.add(a[i]);
//		System.out.println();
//		for (int n: stack) {
//			System.out.print(n+" ");
//		}

		return stack.size();
	}
	public static void main(String[] args) {
		Solution_풍선터트리기 solution = new Solution_풍선터트리기();
		solution.solution(new int[] {-16,27,65,-2,58,-92,-71,-68,-61,-33});
	}
}
