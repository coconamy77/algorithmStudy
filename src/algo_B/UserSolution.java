package algo_B;

class Trie {
	Trie[] next;
	int count;

	Trie() {
		next = new Trie[26];
	}

}

public class UserSolution {
	static Trie root;

	public void init() {
		root = new Trie();
	}

	public void insert(int buffer_size, String buf) {
		
		Trie t = root;
		for (char c: buf.toCharArray()) {
			if (t.next[c - 'a'] == null) {
				t.next[c - 'a'] = new Trie();
			}
			t = t.next[c - 'a'];
			t.count++;
		}
	}

	public int query(int buffer_size, String buf) {
		Trie t = root;
		for (char c: buf.toCharArray()) {
			
			if (t.next[c - 'a'] == null) {
				return 0;
			}
			t = t.next[c - 'a'];
		}
		
		return t.count;
	}
}
