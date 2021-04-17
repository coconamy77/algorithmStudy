package programmers;

import java.util.*;

class Solution_전화번호목록 {

//	public boolean solution(String[] phone_book) {
//
//		Arrays.sort(phone_book);
//
//		int len = 0;
//		for (int i = 0; i < phone_book.length - 1; i++) {
//			if (phone_book[i].length() > phone_book[i + 1].length()) {
//				System.out.println("11");
//				continue;
//			}
//			len = phone_book[i].length();
//			if (phone_book[i].equals(phone_book[i + 1].substring(0, len))) {
//				System.out.println("22");
//				return false;
//			}
//		}
//
//		return true;
//	}

	public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length()-o2.length();
			}
		});
        String s1,s2;
        for(int i = 0; i<phone_book.length-1; i++) {
        	s1 = phone_book[i];
        	for(int j = i+1; j<phone_book.length;j++) {
        		s2 = phone_book[j];
        		if(s1.length()==s2.length()) {
        			continue;
        		}
        		if(s2.substring(0,s1.length()).equals(s1)) {
        			return false;
        		}
        	}
        }
        
        return answer;
    }
}
