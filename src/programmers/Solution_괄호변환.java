package programmers;

import java.util.Stack;

public class Solution_괄호변환 {
		
	public boolean check(String p) {
		Stack<Character> stack = new Stack<Character>();
		stack.push(p.charAt(0));
		for (int i = 1; i<p.length(); i++) {
			char c = p.charAt(i);
			switch(c) {
			case '(':
				stack.push(c);
				break;
			case ')':
				if (stack.isEmpty() || stack.pop()==c) {
					return false;
				}
				break;
			}
		}
		if (!stack.isEmpty()) return false;
		return true;
	}
	
	public String solution(String p) {
        //System.out.println(p);
		String answer = "";
		if (p.length() == 0) {
			return answer;
		}
		if (check(p)) {
			return p;
		}
		String u,v;
		int cnt = 0;
		for (int i = 0; i<p.length(); i++) {
			switch(p.charAt(i)) {
			case '(':
				cnt++;
				break;
			case ')':
				cnt--;
				break;
			}
			if (cnt == 0) {
				u = p.substring(0,i+1);
				v = p.substring(i+1);
				if (check(u)) {
					answer += u;
					answer += solution(v);
				}else {
					answer += "(";
					answer += solution(v);
					answer += ")";
					
					for (int j = 1; j<i;j++) {
						switch(u.charAt(j)) {
						case '(':
							answer += ")";
							break;
						case ')':
							answer += "(";
							break;
						}
					}
				}
                break;
			}
		}
        //System.out.println(answer);
		return answer;
	}


}
