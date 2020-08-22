package com.blog.controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blog.dao.BlogDAO;
import com.blog.dao.BlogDAOImpl;
import com.blog.models.Blog;
import com.blog.pagination.Pagination;

@WebServlet("/admin/updateblog")
public class BlogController2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String getId = req.getParameter("id");
		if (getId == null)
			resp.sendRedirect("viewBlog.jsp");
		BlogDAO b = new BlogDAOImpl();
		long parseGetId = Long.parseLong(getId);
		Blog blog = b.getBlog(parseGetId);
		req.setAttribute("blog", blog);
		req.getRequestDispatcher("updateBlog.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String getId = req.getParameter("id");
		String getTitle = req.getParameter("title");
		String getContent = req.getParameter("editor1");
		if (getId == null)
			resp.sendRedirect("viewBlog.jsp");
		long getLongId = Long.parseLong(getId);
		BlogDAO blog = new BlogDAOImpl();
		int i = blog.updateBlog(getLongId, getTitle, getContent);
		Pagination p = new Pagination();
		p.yap(req, resp);
		req.getRequestDispatcher("viewBlog.jsp").forward(req, resp);
		
	}
}
