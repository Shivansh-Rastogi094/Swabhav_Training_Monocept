package arrays;

public class q2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= new int[] {5,7,3,10,60};
		int max=arr[0];
		for(int i:arr) {
			if(i>max)
				max=i;
		}
		System.out.println("Largest Element: "+max);
	}

}
