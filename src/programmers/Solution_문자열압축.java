package programmers;

class Solution_문자열압축 {

	public int solution(String s) {
		int answer = s.length();

		String tmp = "", before = "";
		//새로운 문자열, 비교대상 문자열
		
		int start, length, cnt; //문자열 시작 위치, 여태까지의 문자열 길이, 해당 문자 반복 횟수
		for (int i = 1; i < s.length(); i++) {
			//길이 늘려가면서 짜르기!
			if (answer<=i) {
				// 현재 최소값보다 긴 길이는 답이 될 수 없다-> 가지치기
				break;
			}
			
			start = 0;
			length = 0;
			cnt = 1;
			
			before = s.substring(start, start + i);
			// 제일 처음 문자열
			start += i;
			// 다음 문자열 시작 위치 조정 
			System.out.println(i+"개로 잘랐을 때");
			while (start + i <= s.length()) {
				//문자열 조사
				
				tmp = s.substring(start, start + i);
				//자르기!
				start += i;
				if (tmp.equals(before)) {
					cnt++;
					//전의 문자열과 같으면 갯수 추가
				} else {
					// 전의 문자열과 다를때
					if (cnt > 1) {
						//만약 1개 이상 있다면 길이 추가 (2a-> 길이: 2, a-> 길이 :1)
						System.out.print(cnt);
						length += 1;
					}
					//해당 문자열 길이 추가
					System.out.print(before);
					length += i;
					//비교대상 문자열 변환
					before = tmp;
					cnt = 1;
				}
			}
			if (cnt > 1) {
				length += 1;
				System.out.print(cnt);
			}
			length += i;
			
			//해당 길이로 짜르고 남은 문자열 체크!
			length += s.length() - start;
			//abc-> ab:2 + (3-2)=3
			System.out.println(before +s.substring(start)+"    "+ length);
			
			if (answer>length) {
				//현재 길이가 답보다 짧을 경우 답 변경
				answer = length;
			}
		}

		return answer;
	}
	
	public static void main(String[] args) {
		Solution_문자열압축 s = new Solution_문자열압축();
		System.out.println(s.solution("ababcdcdababcdcd"));
	}
}