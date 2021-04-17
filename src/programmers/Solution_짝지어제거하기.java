package programmers;

import java.util.Stack;

public class Solution_짝지어제거하기 {
	public int solution(String s) {
	    {
	        if(s.length()%2==1){
	            return 0;
	        }

	        Stack<Character> stack = new Stack<Character>();
	        for(char c: s.toCharArray()){
	            if(stack.size()==0){
	                stack.add(c);
	            }else{
	            if(stack.peek()==c){
	                stack.pop();
	            }else{
	                stack.add(c);
	            }
	            }
	        }

	        if(stack.size()>0){
	            return 0;
	        }
	        return 1;
	    }
	}
}
