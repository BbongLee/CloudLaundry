package cloudlaundry_1002;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DBConnection {
private Connection con;
private Statement st;
private ResultSet rs;

public DBConnection(){
	try {
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cloud", "root","root");
		st = con.createStatement(); //�� ������ ����
	}catch(Exception e) {
		System.out.println("�����ͺ��̽� ���� ���� : "+e.getMessage());
	}
	
}
}
