package reference;

import java.util.Arrays;

public class Combination {

	static int num[] = { 3, 4, 2, 1, 6 };
	static int list[] = new int[num.length];
	static int length = num.length;

	public static void combination(int v, int limit, int cnt) {
		list[cnt] = num[v];
		if (cnt == limit) {
			System.out.println(Arrays.toString(list));
			return;
		}
		for (int i = v + 1; i < length; i++) {
			combination(i, limit, cnt + 1);
		}
	}

// 메인쪽! 조합 호출!
//	  for(int i=0; i<length; i++){
//  	for(int j=0; j<length; j++){		
//  		combination(j, i, 0);
//  	}
//  }

}
