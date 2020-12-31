package programmers;

public class Solution_비밀지도 {
	public String getAnswer(int number,int n){
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            if(number%2==0){
                sb.insert(0," ");
            }else{
                sb.insert(0,"#");
            }
            number/=2;
        }
        return sb.toString();
    }
    
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for(int i = 0; i<n; i++){
            int number = arr1[i] | arr2[i];
            answer[i] = getAnswer(number,n);
        }
        
        return answer;
    }
}
