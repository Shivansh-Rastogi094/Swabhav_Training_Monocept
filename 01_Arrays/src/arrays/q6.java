package arrays;

public class q6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			int arr[]=new int[] {4,5,7,4,8,5,8,2,5,7};
			int target_element=10;
			int freq=0;
			for(int i:arr) {
				if(i==target_element)
					freq++;
			}
			if(freq==0)
				System.out.println("Target Element is not present inthe array");
			else
				System.out.println("Frequency of "+target_element+" is: "+freq);
	}

}
