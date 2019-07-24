package level1;

import java.util.HashMap;

public class Marathon {
	
	//완주 못한 한명의 마라톤 선수 찾기 ( 동명이인 있음 )

	public static void main(String[] args) {
		Solution s = new Solution();
		String[] s1 = { "leo", "kiki", "eden" };
		String[] s2 = { "eden", "kiki" };
		String ans = s.solution(s1, s2);
		System.out.println(ans);

	}

}

class Solution {
	public String solution(String[] participant, String[] completion) {
		String answer = "";
		HashMap<String, Integer> hm = new HashMap<>();
		for (String player : participant)
			hm.put(player, hm.getOrDefault(player, 0) + 1);
		for (String player : completion)
			hm.put(player, hm.get(player) - 1);

		for (String key : hm.keySet()) {
			if (hm.get(key) != 0) {
				answer = key;
			}
		}
		return answer;

	}

}
