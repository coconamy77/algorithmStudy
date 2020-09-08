package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_뉴스클러스터링 {

	public List<String> getSet(String str) {
		List<String> list = new ArrayList<>();
		//System.out.println("---------------" + str + "-------------");
		for (int i = 0; i < str.length() - 1; i++) {
			if (str.charAt(i) < 'a' || str.charAt(i) > 'z' || str.charAt(i+1) < 'a' || str.charAt(i+1) > 'z') {
				continue;
			}
			list.add(str.substring(i, i + 2));
			//System.out.print(str.substring(i, i + 2)+", ");

		}
		//System.out.println();
		Collections.sort(list);
		return list;

	}

	// aa,ab,ac,bb,be,ds aa,bb,ca,cb,cc,cd

	public int solution(String str1, String str2) {
		int answer = 0;

		List<String> set1 = getSet(str1.toLowerCase());
		List<String> set2 = getSet(str2.toLowerCase());

		if (set1.size() + set2.size() == 0) {
			return 1;
		}
		if (set1.size()*set2.size()==0){
            return 0;
        }

		int c1 = 0, c2 = 0;
		int compare = 0;
		int mul = 0;
		while (c1 < set1.size() && c2 < set2.size()) {
			compare = set1.get(c1).compareTo(set2.get(c2));
			if (compare > 0) {
				c2++;
			} else if (compare < 0) {
				c1++;
			} else {
				mul++;
				c2++;
				c1++;
			}
		}
		// System.out.println("교집합: "+mul+" 합 : "+(set1.size()+set2.size()-mul));
		answer = (mul * 65536) / (set1.size() + set2.size() - mul);

		return answer;
	}

	public static void main(String[] args) {
		Solution_뉴스클러스터링 s = new Solution_뉴스클러스터링();
		System.out.println(s.solution("handshake", "shake hands"));
	}
}
