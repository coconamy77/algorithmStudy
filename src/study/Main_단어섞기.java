package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_단어섞기 {

	static int wLen;
	static String[] words;
	static String word;

	public static boolean check(int wordIdx, int[] idx) {
		if(idx[2]==wLen) {
			return true;
		}
//		System.out.println(Arrays.toString(idx));
//		System.out.println(words[wordIdx].charAt(idx[wordIdx])+" "+word.charAt(idx[2]));
		
		if(word.charAt(idx[2])==words[wordIdx].charAt(idx[wordIdx])) {
			idx[wordIdx]++;
			idx[2]++;
			boolean tf = true;
			if(idx[0]<words[0].length()) {
				tf =  check(0, idx);
			}			
			if(!tf && idx[1]<words[1].length()) {
				tf =  check(1, idx);
			}
			return tf;
		}
		return false;
	}

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			words = new String[] { st.nextToken(), st.nextToken() };

			word = st.nextToken();
			wLen = word.length();

			if (check(0,new int[] {0,0,0}) || check(1,new int[] {0,0,0}) ){
				System.out.println("Data set " + t + ": yes");
			} else {
				System.out.println("Data set " + t + ": no");
			}

		}

	}

}
