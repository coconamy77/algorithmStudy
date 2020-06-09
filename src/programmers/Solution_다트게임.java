package programmers;

public class Solution_다트게임 {
	public int getPow(int num, int pow){
        int answer = num;
        while(pow-->1){
            answer *= num;
        }
        return answer;
    }
    
    public int getBonus(char c){
        if(c=='S'){
            return 1;
        }
        if(c=='D'){
            return 2;
        }
        return 3;
    }
    
    public int solution(String dartResult) {
        int[] answerArr = new int[3];
        int index = 0;
        
        String n = "";
        int number = 0;
        int bonus = 0;
        
        for(char c: dartResult.toCharArray()){
            switch(c){
                case 'S':
                case 'D':
                case 'T':
                    bonus = getBonus(c);
                    number = Integer.parseInt(n);
                    n = "";
                    answerArr[index++] = getPow(number, bonus);
                    break;
                
                case '*':
                    if(index>1) {
                        answerArr[index-2] *=2;
                    }
                    answerArr[index-1] *= 2;
                    break;
                    
                case '#':
                    answerArr[index-1] *= -1;
                    break;
                    
                default:
                    n+=String.valueOf(c);
            } 
        }
        
        int answer = 0;
        
        for(int num: answerArr){
            answer += num;
        }
        return answer;
    }
}
