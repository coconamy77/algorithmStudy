package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Solution_후보키 {
	static LinkedHashSet<Integer> cols = new LinkedHashSet<Integer>();

	public void getKeys(List<int[]> key, int n) {
		for (int i = 0; i < cols.size(); i++) {

		}
	}

	public int getCount(List<int[]> keys, String[][] relation) {
		int count = 0;
		Set<String> map = new HashSet<String>();
		boolean flag = true;
		for (int i = 0; i < keys.size(); i++) {// {0}
			int[] tmpArr = keys.get(i);
			for (int j = 0; j < relation.length; j++) {// 222,computer, 12~
				StringBuilder sb = new StringBuilder();
				for (int k = 0; k < tmpArr.length; k++) {
					sb.append(relation[j][tmpArr[k]]);
					sb.append(" ");
				}
				if (map.contains(sb.toString())) {
					flag = false;
					break;
				} else {
					map.add(sb.toString());
				}
			}
			if (flag) {
				count++;
				keys.remove(i--);
				for (int k = 0; k < tmpArr.length; i++) {
					if(cols.contains(tmpArr[k])) {
						cols.remove(tmpArr[k]);
					}
				}
			}
		}

		return count;
	}

	public int solution(String[][] relation) {
		int answer = 0;
		int length = relation.length;
		List<int[]> keys = new ArrayList<int[]>();
		for (int i = 0; i < length; i++) {
			cols.add(i);
			keys.add(new int[] { i });
		}

		answer += getCount(keys, relation);

		for (int i = 2; i <= length; i++) {
			getKeys(keys, i);
		}

		return answer;
	}

}
