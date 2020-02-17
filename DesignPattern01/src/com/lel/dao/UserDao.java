package com.lel.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lel.Utils.DBUtils;
import com.lel.bean.User;

public class UserDao {
		public  int  login(User user) throws SQLException {
			String sql = "select *  from  login where username = ? and  userpwd = ? ;";
			Connection conn = DBUtils.getConnection();
			 PreparedStatement stat = conn.prepareStatement(sql);
			
		    stat.setString(1, user.getUsername());
		    stat.setString(2, user.getUserpwd());
		   ResultSet resultSet = stat.executeQuery();
		  while(resultSet.next()) {
		   if(resultSet.getString("username")!=null) {
			   return 1;
		   }
		   
		   else return 0;
		}
		  return 0;
		}
}
