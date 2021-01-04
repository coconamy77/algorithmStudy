package programmers;

public class Solution_크레인인형뽑기게임 {
	public int solution(int[][] board, int[] moves) {
        int answer = 0;
        int[] moved = new int[moves.length+1];
        int index = 0;
        
        for(int j: moves){
            j = j-1;
            int i = 0;
            while(i<board.length && board[i][j]==0){
                i++;
            }
            
            if(i==board.length){
                continue;
            }else{
                if(moved[index]==board[i][j]){
                    answer+=2;
                    index--;
                }else{
                    moved[++index] = board[i][j];
                }
                board[i][j] = 0;
            }
        }
        
        return answer;
    }
}
