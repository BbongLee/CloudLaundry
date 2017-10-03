package exam2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnection {
private Connection con;
private Statement st;
private ResultSet rs;

public DBConnection(){
	try {
		//database : cloud / table : score
		Class.forName("com.mysql.cj.jdbc.Driver");
		//?autoReconnect=true&useSSL=false
		//jdbc:mysql://localhost/test?" +"user=minty&password=greatsqldb
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cloud?verifyServerCertificate=false&useSSL=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root","root");
		st = con.createStatement(); //실 데이터 추출
	}catch (SQLException ex) {
	    // handle any errors
	    System.out.println("SQLException: " + ex.getMessage());
	    System.out.println("SQLState: " + ex.getSQLState());
	    System.out.println("VendorError: " + ex.getErrorCode());
	}catch (Exception e) {
	    System.out.print("에러 : ");
	    e.printStackTrace();
	}
}
public boolean isName() {
	try {
		String SQL = "select name from score";
		rs = st.executeQuery(SQL);
		if(rs.next()) {
			return true;			
		}
	}catch (Exception e) {
	    System.out.print("에러 : ");
	    e.printStackTrace();
	    
	}
	return false;
}
}
