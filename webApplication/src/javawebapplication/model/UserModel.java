package javawebapplication.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.x.protobuf.MysqlxPrepare.Execute;

import javawebapplication.bean.UserBean;
import javawebapplication.utilility.JDBCDataSource;

public class UserModel {


	
	  public static long nextPk() {
		    long pk = 0;
		    Connection conn;
		    try {
		      conn = JDBCDataSource.getConnection();
		      PreparedStatement stmt = conn.prepareStatement("select Max(id) from user");
		      ResultSet rs = stmt.executeQuery();
		      while(rs.next()){
		        pk = rs.getLong(1);
		      }
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return pk+1;
		    
		  }
	  
	  
	  public static long addUser(UserBean user) {
		    int i = 0;
		    try {
		      Connection conn = JDBCDataSource.getConnection();
		      String sql = "insert into user(id, firstname, lastname, logId, password, dob, mobile) values('"
		    		  + nextPk() + "','" + user.getFirstName() + "','"+ user.getLastName()+ "','"
		    		  + user.getLoginId() + "','" + user.getPassword() +"','" + new java.sql.Date(user.getDob().getTime()) + "','" 
		    		  + user.getMobileNumber() + "')";
		      
		      PreparedStatement stmt = conn.prepareStatement(sql);
		      /*
		       PreparedStatement stmt = conn.prepareStatement("insert into user values(?,?,?,?,?,?,?)");
		       stmt.setLong(1, nextPk());
		      stmt.setString(2 , user.getFirstName() );
		      stmt.setString(3 , user.getLastName() );
		      stmt.setString(4 , user.getLoginId() );
		      stmt.setString(5 , user.getPassword() );
		      stmt.setDate(6 , new java.sql.Date(user.getDob().getTime()) );
		      stmt.setString(7 , user.getMobileNumber() );
		       */
		      
		      i =     stmt.executeUpdate();
		      
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    
		    return i;
		  }

	  
	  
	//Login User......
	  public static UserBean  UserLogin(String login, String password) {
	    Connection con;
	    UserBean user = null;
	    try {
	    	ResultSet rs = userList(login, password);
	      if(rs.next()) {
	        user = new UserBean();
	        System.out.println("ID: "+rs.getLong("id"));
	        user.setId(rs.getLong("id"));
	        user.setFirstName(rs.getString("firstname"));
	        user.setLastName(rs.getString("lastname"));
	        user.setLoginId(rs.getString("logId"));
	        user.setPassword(rs.getString("password"));
	        user.setDob(rs.getDate("dob"));
	        user.setMobileNumber(rs.getString("mobile"));    
	      }
	      
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return user;
	  }


	/**
	 * @param login
	 * @param password
	 * @return
	 * @throws Exception
	 * @throws SQLException
	 */
	private static ResultSet userList(String login, String password) throws Exception, SQLException {
		Connection con;
		con = JDBCDataSource.getConnection();
		PreparedStatement stmt = con.prepareStatement("Select * from user where logId=? and password = ?");
		stmt.setString(1,login);
		stmt.setString(2,password);
		ResultSet resultSet = stmt.executeQuery();
		return resultSet;
	}
	  
	  
	  // get data from database
	  public static List list() {
		  ArrayList<UserBean> list = new ArrayList<UserBean>();
		  Connection conn = null;
		  try {
		    conn = JDBCDataSource.getConnection();
		    PreparedStatement pstmt = conn.prepareStatement("Select * from user");
		    ResultSet rs =  pstmt.executeQuery();
		    while (rs.next()) {
		    UserBean user = new UserBean();
		 // System.out.print("ID: "+rs.getLong("id") + "\n");
		    user.setId(rs.getLong("id"));
		    user.setFirstName(rs.getString("firstname"));
		    user.setLastName(rs.getString("lastname"));
		    user.setLoginId(rs.getString("logId"));
		    user.setPassword(rs.getString("password"));
		    user.setDob(rs.getDate("dob"));
		    user.setMobileNumber(rs.getString("mobile"));
		    list.add(user);
		    }
		  } catch (Exception e) {
		    // TODO Auto-generated catch block
		    e.printStackTrace();
		  }finally {
		    JDBCDataSource.closeConnection(conn);
		  }
		  System.out.println(" user list size "+ list.size());
		  return list;
		}


	  //find user by id
	public UserBean findByPK(long id) {
	    Connection con;
	    UserBean user = null;
	    try {
	      con = JDBCDataSource.getConnection();
	      PreparedStatement stmt = con.prepareStatement("Select * from user where id=?");
	      stmt.setLong(1, id);
	      ResultSet rs = stmt.executeQuery();
	      if(rs.next()) {
	    	user = new UserBean();
	        System.out.println(" findByPK ID: "+rs.getLong("id"));
	        user.setId(rs.getLong("id"));
	        user.setFirstName(rs.getString("firstname"));
	        user.setLastName(rs.getString("lastname"));
	        user.setLoginId(rs.getString("logId"));
	        user.setPassword(rs.getString("password"));
	        user.setDob(rs.getDate("dob"));
	        user.setMobileNumber(rs.getString("mobile"));  
	      }
	      
	    } catch (Exception e) {
	      // TODO Auto-generated catch block
	      e.printStackTrace();
	    }
	    
	    return user;
	  }
	  
	
	//update user 
	  public static long UpdateUser(UserBean user) {
		    int i = 0;
		    try {
		      Connection conn = JDBCDataSource.getConnection();
		      PreparedStatement stmt = conn
		          .prepareStatement("update user set firstname=?, lastname=?, logid=?, password=?, dob=?,mobile=? where id=?");
		      stmt.setString(1, user.getFirstName());
		      stmt.setString(2, user.getLastName());
		      stmt.setString(3, user.getLoginId());
		      stmt.setString(4, user.getPassword());
		      stmt.setDate(5, new java.sql.Date(user.getDob().getTime()));
		      stmt.setString(6, user.getMobileNumber());
		      stmt.setLong(7, user.getId());
		      i = stmt.executeUpdate();
		      System.out.println(user.getFirstName() +": updated");
		    } catch (Exception e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    
		    return i;
		  }
	  
	  
	  public static long delete(long id) {
		  int i = 1;
		  try {
			  Connection conn = JDBCDataSource.getConnection();
			  PreparedStatement stmt = conn.prepareStatement("DELETE FROM user WHERE id = ?");
			  stmt.setLong(1, id);
			  i = stmt.executeUpdate();
			  
		  }catch (Exception e) {
			e.printStackTrace();
		}
		  return i;
	  }
	
	
	  
	  
}
