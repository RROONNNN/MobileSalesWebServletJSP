/*package Connection2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {
	private final String serverName="DESKTOP-MBLDMG3\\SQLEXPRESS";
	private final String dbName="Company";
	private final String portNumber="1433";
	private final String instance="";
	private final String userID="sa";
	private final String password="22012004";
public Connection getConnection() throws ClassNotFoundException, SQLException {
	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	String url="jdbc:sqlserver://"+serverName+":"+portNumber
			+"//"+instance+";databaseName="+dbName;
	if(instance==null ||instance.trim().isEmpty())
	url="jdbc:sqlserver://"+serverName+":"+portNumber
		+";databaseName="+dbName+";encrypt=false;integratedSecurity=true;";
	
	return DriverManager.getConnection(url,userID,password);
}
}
*/

package Connection2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBContext {
	 
	 public Connection getConnection() {
	     String user="root",password="";
	     Connection myConn = null;
         try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/quanlycuahangoo";
	        myConn=  DriverManager.getConnection(url,user,password);
	        System.out.println("Connect succesful!");
	        return myConn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         return myConn;
	}
}
