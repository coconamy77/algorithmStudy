package array2;

public class BinarySearch1_반복_서울8반_정하정 {
	
	public static boolean binarySearch(int[] a, int key) {
		int start = 0; 
		int end = a.length-1;
		while(start<=end) {
			int middle = (start+end)/2;
			if (a[middle]==key) {
				return true;
				
			}
			else if (a[middle]>key) {
				end = middle -1;
				
			}
			else start = middle +1;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		int[] a = {2,4,7,9,11,19,23};
		
		System.out.println(binarySearch(a, 7));
		
		
	}
}
