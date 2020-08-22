package com.blog.dao;

import java.util.List;

import com.blog.models.Blog;

public interface BlogDAO {
	
	public int addBlog(String title,String content);
	public List<Blog> blogList(int start,int total);
	public int removeBlog(long blogId);
	public Blog getBlog(long blogId);
	public int updateBlog(long blogId,String title,String content);
	public double countBlog();
}
