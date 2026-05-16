package arrays;

public class q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[];
		int arr2[]=new int[5];
		arr2 = new int[] {1,2,3,4,5};
		arr= new int[] {6,7,8,9,10};
		
		for(int i:arr2) {
			System.out.print(i+",");
		}
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+",");
		}
}
}
