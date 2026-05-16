package demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CRUD {
public static void main(String[] args) {
	try {
		Connection connect = JDBCDemo.getConnection();
		
		// Insert | Create operation
		String print = "select * from students";
		String sql = "insert into students (id, name, age, branch, grade) values (?,?,?,?,?)";
		PreparedStatement prepStatment1 = connect.prepareStatement(sql);
		PreparedStatement printStatment = connect.prepareStatement(print);
		
		prepStatment1.setInt(1,16);
		prepStatment1.setString(2,"Yash Raghav");
		prepStatment1.setInt(3,22);
		prepStatment1.setString(4,"Electrical");
		prepStatment1.setInt(5,85);
		
//		prepStatment1.executeUpdate();
		
//		printStatment.executeQuery();
		
		// Update 
		
		String sql2 ="update students set name=?  where id=?";
		PreparedStatement prepStatment2 = connect.prepareStatement(sql2);
		prepStatment2.setInt(2,16);
		prepStatment2.setString(1,"Yash Paliwal");
		
//		prepStatment2.executeUpdate();

		// Delete 
		
		String sql3 ="DELETE FROM students WHERE id = ?";
		PreparedStatement prepStatment3 = connect.prepareStatement(sql3);
		prepStatment3.setInt(1,305);
		prepStatment3.executeUpdate();
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	}
}
}
