package assignment6;

public class User {

	private String name;
	private int age;
	private String status;

	public User(String name, int age, String status) {
		this.name = name;
		this.age = age;
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStatus() {
		return status;
	}
}