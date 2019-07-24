package level1;

public class NExpression {

	/*아래와 같이 5와 사칙연산만으로 12를 표현할 수 있습니다.

	12 = 5 + 5 + (5 / 5) + (5 / 5)
	12 = 55 / 5 + 5 / 5
	12 = (55 + 5) / 5

	5를 사용한 횟수는 각각 6,5,4 입니다. 그리고 이중 가장 작은 경우는 4입니다.
	이처럼 숫자 N과 number가 주어질 때, N과 사칙연산만 사용해서 표현 할 수 있는 방법 중 N 사용횟수의 최솟값을 return 하도록 solution 함수를 작성하세요.
	*/
	
	int answer = -1;

    public int solution(int N, int number) {
        dfs(N, 0, 0, number, "");
        return answer;
    }

    public void dfs(int n, int pos, int num, int number, String s) {
        if (pos > 8)
            return;
        if (num == number) {
            if (pos < answer || answer == -1) {
                System.out.println(s);
                answer = pos;
            }
            return;
        }
        int nn=0;
        for (int i = 0; i < 8; i++) {
            nn=nn*10+n;
            dfs(n, pos + 1+i, num + nn, number, s + "+");
            dfs(n, pos + 1+i, num - nn, number, s + "-");
            dfs(n, pos + 1+i, num * nn, number, s + "*");
            dfs(n, pos + 1+i, num / nn, number, s + "/");
        }
        // dfs(n,pos+1,num*10+n,number,s+"5");
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

