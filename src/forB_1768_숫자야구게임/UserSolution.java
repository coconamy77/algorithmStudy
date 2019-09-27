package forB_1768_숫자야구게임;

public class UserSolution {

	public void doUserImplementation(int[] guess) {
		
		
		
		for (int i=0; i<10; i++) {
			guess[0] = i;
			for (int j =0; j<10; j++) {
				if (i==j) continue;
				guess[1] = j;
				for (int k = 0; k<10; k++) {
					if (i==k || j==k) continue;
					guess[2] = k;
					for (int l = 0; l<10; l++) {
						if (i==l || j==l || k==l)continue;
						guess[3] = l;
						Solution.Result r = Solution.query(guess);
						
					}
				}
			}
		}
	}
	

}
