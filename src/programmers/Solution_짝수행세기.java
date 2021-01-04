package programmers;

class Solution_짝수행세기 {
    int mod = 10000019;
    public int solution(int[][] a) {
        int answer = -1;
        // if(a[0].length <4)return 0;
        int[][] combi = new int[301][301];
        combi[0][0]=1;
        for(int i=1; i<301; i++){
            for(int j=0; j<=i; j++ ){
                if(j==0)combi[i][j]=1;
                else combi[i][j]=(combi[i-1][j-1]+combi[i-1][j])%mod;
            }
        }

        // int[] col = {2,1,0,1,2}
        int[] col = new int[a[0].length];
        for(int i=0; i<a.length; i++){
            for(int j=0; j<a[0].length; j++){
                if(a[i][j]==1)col[j]++;
            }
        }
        int R = a.length;
        //int C = a[0].length;
        int[][] evenCountArr = new int[2][a.length+1];
        evenCountArr[0][R-col[0]] = combi[R][col[0]];

        for(int i=1; i<col.length; i++){
            int numCol = col[i];
            for(int j=0; j<R+1; j++){ // 행 수 만큼 반복
                int m =j; //짝수 행 개수
                int n =R-j; //홀수 행 개수
                int leftVal = evenCountArr[0][j];
                for(int k=0; k<=numCol; k++){ // 열에 들어있는 1의 개수만큼.
                    if(k>m)continue;
                    if(m-2*k+numCol >R || m-2*k+numCol <0 )continue;
                    long val = combi[m][k]*(long)combi[n][numCol-k]%mod;
                    val = val*leftVal%mod;
                    evenCountArr[1][m-2*k+numCol] += val;
                }
            }

            // System.out.println(Arrays.toString(evenCountArr[0]));
            // System.out.println(Arrays.toString(evenCountArr[1]));
            // System.out.println();
            for(int j=0; j<=R; j++){
                evenCountArr[0][j] = evenCountArr[1][j];
                evenCountArr[1][j] =0;
            }
        }
        answer = evenCountArr[0][evenCountArr[0].length-1];
        // System.out.println(answer);
        return answer;
    }
}
