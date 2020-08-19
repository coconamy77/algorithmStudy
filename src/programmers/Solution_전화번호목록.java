import java.util.*;
class Solution_전화번호목록{
    public boolean solution(String[] phone_book) {
        
        Arrays.sort(phone_book);
        
        int len = 0;
        for (int i =0; i<phone_book.length-1; i++){
            if (phone_book[i].length()>phone_book[i+1].length()){
                System.out.println("11");
                continue;
            }
            len = phone_book[i].length();
            if(phone_book[i].equals(phone_book[i+1].substring(0,len))){
                 System.out.println("22");
                return false;
            }
        }
        
        return true;
    }
}
