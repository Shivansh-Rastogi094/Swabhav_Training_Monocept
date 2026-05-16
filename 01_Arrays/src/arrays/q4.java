package arrays;

public class q4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[] {34,53,67,45,78};
		int largest=0, second_largest=0;
		for(int i:arr) {
			if(i>largest) {
				second_largest=largest;
				largest=i;
			}
		}
		System.out.println("Second Largest: "+second_largest);
	}

}
