package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class AdminDAOImpl implements AdminDAO {
	
	private final String getAdminQuery = "SELECT * FROM admin WHERE username = ? and password = ? ";
	
	@Override
	public int getAdmin(String username, String password) {
		try {
			Connection u = DatabaseUtilities.getConnect();
			PreparedStatement ps = u.prepareStatement(getAdminQuery);
			ps.setString(1, username);
			ps.setString(2, password);
			ResultSet s = ps.executeQuery();
			if(s.next())
			{
				return 1;
			}
			u.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
