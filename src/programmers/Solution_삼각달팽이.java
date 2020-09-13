package programmers;

class Solution_삼각달팽이 {
    public int[] solution(int n) {
       int[] answer = new int[n*(n+1)/2];
           int[][] map = new int[n][n];
           int index=1;
           int direction=0;
           int curX=0;
           int curY=0;
           while(n*(n+1)/2>=index) {
              if(direction==0) {
                 map[curX++][curY]=index++;
                 if(curX>=n || map[curX][curY]!=0) {
                    curX--;
                    curY++;
                    direction=1;
                 }
                 
              }else if(direction==1) {
                 map[curX][curY++]=index++;
                 if(curY>=n || map[curX][curY]!=0) {
                    curY--;
                    curY--;
                    curX--;
                    direction=2;
                 }
              }else if(direction==2) {
                 map[curX--][curY--]=index++;
                 if(map[curX][curY]!=0) {
                    curX++;
                    curX++;
                    curY++;
                    direction=0;
                 }
              }
           }
           int answerIndex=0;
           for(int i=0; i<n; i++) {
              for(int j=0; j<=i; j++) {
                 answer[answerIndex++]=map[i][j];
              }
           }
           
           
          return answer;
    }
}