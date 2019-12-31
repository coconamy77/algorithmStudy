package programmers;

class Solution_키패드누르기 {
	public int getD(int now, int goal) {
		int d = 0;
		int nowRow = now % 3;
		if (now % 3 != 2) {
			d += 1;
		}
		d += Math.abs((now-1) / 3 - (goal-1) / 3);

		return d;
	}

	public String solution(int[] numbers, String hand) {
		String answer = "";
		int handInt = 0;
		char[] finger = { 'R', 'L' };
		int[] locationNum = { 10, 12 };
		if (hand.equals("left")) {
			handInt = 1;
		}

		for (int n : numbers) {
            if(n==0){
                n = 11;
            }
			int row = n % 3;
			if (row == 2) {
				int rd = getD(locationNum[0], n);
				int ld = getD(locationNum[1], n);
                System.out.println(n+"  rd : "+rd+", ld : "+ld);
                System.out.println("오른손: "+locationNum[0]+", 왼송:   "+locationNum[1]);
                
				if (rd < ld) {
					row = 0;
				} else if (ld < rd) {
					row = 1;
				} else {
					row = handInt;
				}
			}

			locationNum[row] = n;
			answer += finger[row];
		}

		return answer;
	}
}