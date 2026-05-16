package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PracticeQuery2 {
public static void main(String[] args) {
	try {
	Connection connect = JDBCDemo.getConnection();
	String sql ="insert into students (id, name, age, branch, grade) values (?,?,?,?,?)";
	PreparedStatement ps = connect.prepareStatement(sql);
	
	// Student 1
	ps.setInt(1, 16);
	ps.setString(2, "Aman");
	ps.setInt(3, 20);
	ps.setString(4, "CSE");
	ps.setInt(5, 88);
	ps.addBatch();

	// Student 2
	ps.setInt(1, 17);
	ps.setString(2, "Riya");
	ps.setInt(3, 21);
	ps.setString(4, "IT");
	ps.setInt(5, 89);
	ps.addBatch();

	// Student 3
	ps.setInt(1, 18);
	ps.setString(2, "Karan");
	ps.setInt(3, 22);
	ps.setString(4, "Mechanical");
	ps.setInt(5, 87);
	ps.addBatch();

	// Student 4
	ps.setInt(1, 19);
	ps.setString(2, "Neha");
	ps.setInt(3, 20);
	ps.setString(4, "Electrical");
	ps.setInt(5, 89);
	ps.addBatch();

	// Student 5
	ps.setInt(1, 20);
	ps.setString(2, "Vikram");
	ps.setInt(3, 23);
	ps.setString(4, "Civil");
	ps.setInt(5, 86);
	ps.addBatch();
	
	int [] result = ps.executeBatch();
	System.out.println("Inserted " + result.length + " records successfully!");

	}catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	}
	
}
}
