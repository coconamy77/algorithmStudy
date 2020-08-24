package programmers;

class Solution_문자열압축 {

	public int solution(String s) {
		int answer = s.length();

		String tmp = "", before = "";
		//새로운 문자열, 비교대상 문자열
		
		int start, length, cnt; //문자열 시작 위치, 여태까지의 문자열 길이, 해당 문자 반복 횟수
		for (int i = 1; i < s.length(); i++) {
			
			if (answer<=i) {
				break;
			}
			
			start = 0;
			length = 0;
			cnt = 1;
			
			before = s.substring(start, start + i);
			start += i;
			System.out.println(i+"개로 잘랐을 때");
			while (start + i <= s.length()) {
				tmp = s.substring(start, start + i);
				start += i;
				if (tmp.equals(before)) {
					cnt++;
				} else {
					if (cnt > 1) {
						System.out.print(cnt);
						length += 1;
					}
					System.out.print(before);
					length += i;
					before = tmp;
					cnt = 1;
				}
			}
			if (cnt > 1) {
				length += 1;
				System.out.print(cnt);
			}
			length += i;
			
			length += s.length() - start;
			System.out.println(before +s.substring(start)+"    "+ length);
			
			if (answer>length) {
				answer = length;
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		Solution_문자열압축 s = new Solution_문자열압축();
		System.out.println(s.solution("abcabcabcabcdededededede"));
	}
}