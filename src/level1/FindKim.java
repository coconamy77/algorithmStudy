package level1;

public class FindKim {

	public String solution(String[] seoul) {
	      String answer = "";
	      
	      for (int i=0; i<seoul.length;i++) {
	    	  if (seoul[i].equals("Kim")) {
	    		  answer="김서방은 "+i+"에 있다";
	    		  break;
	    	  }
	      }
	      
	      //int x = Arrays.asList(seoul).indexOf("Kim");
	      
	      return answer;
	  }
	
	public static void main(String[] args) {
		FindKim kim = new FindKim();
        String[] names = {"Queen", "Tod","Kim"};
        System.out.println(kim.solution(names));

	}

}
