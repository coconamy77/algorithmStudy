package programmers;

public class Solution_정수삼각형 {
	public int solution(int[][] tri) {
        int answer = 0;
        int[][] dp = new int[tri.length][];
        int i = 0;
        dp[i++] = new int[]{tri[0][0]};
        
        for(; i<tri.length-1; i++){
            dp[i] = new int[i+1];
            int j = 0;
            dp[i][j++] = dp[i-1][0]+tri[i][0];
            for (;j<tri[i].length-1; j++){
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+tri[i][j];
            }
            dp[i][j] = dp[i-1][j-1]+tri[i][j];
        }
        
        dp[i] = new int[i+1];
        int j = 0;
        dp[i][j++] = dp[i-1][0]+tri[i][0]; 
        if (answer<dp[i][j]){
            answer = dp[i][j];
        }

        for (;j<tri[i].length-1; j++){
            dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j])+tri[i][j];
            if (answer<dp[i][j]){
                answer = dp[i][j];
            }
        }
        dp[i][j] = dp[i-1][j-1]+tri[i][j];
        if (answer<dp[i][j]){
            answer = dp[i][j];
        }
       
        
        return answer;
    }
}
