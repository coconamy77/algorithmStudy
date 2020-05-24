package reference;

public class FloydWarshall {

	static int num = 4;
	static int INF = 1000000;
	static int map[][] = {{0, 5, INF, 8},{7, 0, 9, INF}, {2, INF, 0, 4}, {INF, INF, 3, 0}};
	
	public static void floydWarshall() {
		int d[][] = new int[num][num];
		
		for(int i=0; i<num; i++) {
			for(int j=0; j<num; j++) {
				d[i][j]=map[i][j];
			}
		}
		//경출도
		for(int k=0; k<num; k++) {
			for(int i=0; i<num; i++) {
				for(int j=0; j<num; j++) {
					if(d[i][k]+d[k][j] < d[i][j]) {
						d[i][j] = d[i][k] + d[k][j];
					}
				}
			}
		}
	}
}
