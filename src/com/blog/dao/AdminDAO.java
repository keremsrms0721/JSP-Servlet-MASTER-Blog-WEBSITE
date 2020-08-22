package com.blog.dao;

import com.blog.models.Admin;

public interface AdminDAO {
	
	public int getAdmin(String username,String password);
	
}
