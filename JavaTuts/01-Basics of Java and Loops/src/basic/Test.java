package basic;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Scanner sc = new Scanner(System.in);
//
//System.out.println("Enter your roll no");
//int roll = sc.nextInt();
//
//System.out.println("Enter your name");
//String name = sc.nextLine();
//
//System.out.println("Your roll is "+ roll+" and your name is "+name);
//sc.close();
		
//		int x;
//		System.out.println(x);
		String s1="Shivansh",s2="Shivansh",s3=new String("Shivansh") ,s4=new String("Shivansh");
		System.out.println(s1==s2); //false
		System.out.println(s2==s3); //false
		System.out.println(s3==s4); //false
		System.out.println(s1.equals(s2)); //True
		System.out.println(s2.equals(s3)); //True
		System.out.println(s3.equals(s4)); //True
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
	}

}
