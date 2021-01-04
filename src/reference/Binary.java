package reference;

public class Binary {
	public String getBinaryWithN(int number,int n){//n은 자리수
        StringBuilder sb = new StringBuilder();
        while(n-->0){
            if(number%2==0){
                sb.insert(0,0);
            }else{
                sb.insert(0,1);
            }
            number/=2;
        }
        return sb.toString();
    }

	public String getBinary(int number){//n은 자리수
		StringBuilder sb = new StringBuilder();
		while(number>0){
			if(number%2==0){
				sb.insert(0,0);
			}else{
				sb.insert(0,1);
			}
			number/=2;
		}
		return sb.toString();
	}
}
