package reference;

public class Range {
	public boolean range(int x, int y, int n, int m) {
		if (x >= 0 && y >= 0 && x < n && y < m) {
			return true;
		}
		return false;
	}
}
