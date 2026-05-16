package arrays;

public class q7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]=new int[] {4,5,7,40,8,5,8,20,5,7};
		int n=arr.length;
		for(int i=0;i<n;i++) {
		if((i == 0 || arr[i] >= arr[i-1]) &&
	               (i == arr.length-1 || arr[i] >= arr[i+1])) {
			 System.out.println("Peak element: " + arr[i]);	
		}
		}
	}

}
