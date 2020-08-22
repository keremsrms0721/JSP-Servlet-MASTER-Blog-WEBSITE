package com.blog.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogDAO;
import com.blog.dao.BlogDAOImpl;
import com.blog.models.Blog;
import com.blog.pagination.Pagination;

@WebServlet("/admin/addblog")
public class BlogController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("editor1");
		BlogDAO blog = new BlogDAOImpl();
		int i = blog.addBlog(title, content);
		Pagination p = new Pagination();
		p.yap(req, resp);
		req.getRequestDispatcher("viewBlog.jsp").forward(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String stringBlogId = req.getParameter("id");
		BlogDAO blog = new BlogDAOImpl();
		if (stringBlogId != null) {
			int i = blog.removeBlog(Long.parseLong(stringBlogId));
		}
		Pagination p = new Pagination();
		p.yap(req, resp);
		req.getRequestDispatcher("viewBlog.jsp").forward(req, resp);
	}

}
