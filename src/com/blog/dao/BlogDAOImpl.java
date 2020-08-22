package com.blog.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.blog.models.Blog;

public class BlogDAOImpl implements BlogDAO {

	private final String sqlInsert = "INSERT INTO blog (title,content) VALUES (?,?)";
	private final String sqlList = "SELECT * FROM blog limit ";
	private final String sqlListAll = "SELECT * FROM blog";
	private final String sqlLimit = "SELECT COUNT(*) FROM blog";
	private final String sqlRemove = "DELETE FROM blog WHERE id = ?";
	private final String sqlGetBlog = "SELECT * FROM blog WHERE id = ?";
	private final String sqlUpdateBlog = "UPDATE blog SET title = ? , content = ? WHERE id = ?";
	@Override
	public int addBlog(String title, String content) {
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = DatabaseUtilities.getConnect();
			ps = connect.prepareStatement(sqlInsert);
			ps.setString(1, title);
			ps.setString(2, content);
			int status = ps.executeUpdate();
			connect.close();
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public List<Blog> blogList(int start,int total) {
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Blog blog = null;
		List<Blog> blogList = null;
		try {
			blogList = new ArrayList<>();
			connect = DatabaseUtilities.getConnect();
			ps = connect.prepareStatement(sqlList+(start-1)+","+total);
			rs = ps.executeQuery();
			while (rs.next()) {
				long blogId = rs.getLong("id");
				String blogTitle = rs.getString("title");
				String blogContent = rs.getString("content");
				blog = new Blog(blogId, blogTitle, blogContent);
				blogList.add(blog);
			}
			connect.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return blogList;
	}

	@Override
	public int removeBlog(long blogId) {
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = DatabaseUtilities.getConnect();
			ps = connect.prepareStatement(sqlRemove);
			ps.setLong(1, blogId);
			int status = ps.executeUpdate();
			connect.close();
			return status;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public Blog getBlog(long blogId) {
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Blog blog = null;
		try
		{
			connect = DatabaseUtilities.getConnect();
			ps = connect.prepareStatement(sqlGetBlog);
			ps.setLong(1, blogId);
			rs = ps.executeQuery();
			if(rs.next())
			{
				long id = rs.getLong("id");
				String title = rs.getString("title");
				String content = rs.getString("content");
				blog = new Blog(id,title,content);
				return blog;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int updateBlog(long blogId, String title, String content) {
		Connection connect = null;
		PreparedStatement ps = null;
		try
		{
			connect = DatabaseUtilities.getConnect();
			ps = connect.prepareStatement(sqlUpdateBlog);
			ps.setString(1, title);
			ps.setString(2, content);
			ps.setLong(3, blogId);
			int status = ps.executeUpdate();
			return status;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public double countBlog() {

		Connection connect = null;
		Statement ps = null;
		ResultSet rs = null;
		double count = 0;
		try
		{
			connect = DatabaseUtilities.getConnect();
			ps = connect.createStatement();
			rs = ps.executeQuery(sqlLimit);
			rs.next();
			count = rs.getInt(1);
			System.out.println(count);
			connect.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return count;
	}

}
