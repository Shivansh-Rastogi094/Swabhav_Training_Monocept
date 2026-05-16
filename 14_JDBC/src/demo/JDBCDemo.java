package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.sql.Statement;

public class JDBCDemo  {
	
	private static final String URL = "jdbc:mysql://localhost:3306/jdbcdemo";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "Rshivansh@094";

    // reusable method
    public static Connection getConnection(){
        try{
        	
        	// 1. making connection
        	return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
		return null;
        }
    }

public static void main(String[] args)  {
	String sql = "select * from Students";

	try {
		Connection connect= getConnection();
		
	// 2. Create Statement
//	Statement statement = connect.createStatement();
	PreparedStatement prepStatment = connect.prepareStatement(sql);
	
	// 3. Execute Query
	ResultSet result= prepStatment.executeQuery();	
	// 4. Process Result
	
	while(result.next()) {
	int id = result.getInt("id");
	String name = result.getString("name");
	String branch = result.getString("branch");
	int age = result.getInt("age");
	int grade = result.getInt("grade");
		System.out.println(id+" | "+name+" | "+age+" | "+branch+" | "+grade);	
	}
	connect.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		System.out.println(e.getMessage());
		System.out.println(e.getErrorCode());
	}
}

}
